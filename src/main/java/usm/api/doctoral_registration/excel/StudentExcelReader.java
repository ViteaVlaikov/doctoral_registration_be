package usm.api.doctoral_registration.excel;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import usm.api.doctoral_registration.dto.country.CountryDto;
import usm.api.doctoral_registration.dto.science.SpecialityDto;
import usm.api.doctoral_registration.dto.student.StudentDto;
import usm.api.doctoral_registration.model.science.ScienceSchool;
import usm.api.doctoral_registration.model.student.properties.Financing;
import usm.api.doctoral_registration.model.student.properties.Gender;
import usm.api.doctoral_registration.model.student.properties.StudyType;
import usm.api.doctoral_registration.model.student.properties.YearStudy;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static usm.api.doctoral_registration.model.student.properties.YearStudy.toYearStudy;

@Slf4j
@Component
public class StudentExcelReader {

    private final static String ORDER_REGEX = "$[0-9]{1,10}-c";

//    private final SupervisorRepository supervisorRepository;
//
//    private final SupervisorMapper supervisorMapper;
//
//    @Autowired
//    public StudentExcelReader(SupervisorRepository supervisorRepository, SupervisorMapper supervisorMapper) {
//        this.supervisorRepository = supervisorRepository;
//        this.supervisorMapper = supervisorMapper;
//    }

    enum TypeBook {

        XLS(".xls"),

        XLSX(".xlsx");

        public final String code;

        TypeBook(String code) {
            this.code = code;
        }
    }

    enum DateTemplate {

        EUROPE("dd.MM.yyyy", "[0-3][0-9](\\.|/)[0-1][0-9](\\.|/)[1-2][0-9]{3}"),

        EUROPE_SHORT("dd.MM.yy", "[0-3][0-9](\\.|/)[0-1][0-9](\\.|/)[0-9]{2}"),

        YEAR("yyyy", "[1-2][0-9]{3}");

        public final String code;

        public final String regex;

        DateTemplate(String code, String pattern) {
            this.code = code;
            this.regex = pattern;
        }

        public static LocalDate toLocalDate(String date) {
            Optional<DateTemplate> formatterTemplate = Arrays.stream(DateTemplate.values())
                    .filter(template -> date.matches(".*" + template.regex + ".*")).findFirst();
            if (formatterTemplate.isEmpty()) {
                throw new IllegalArgumentException("error date: " + date);
            }
            if (date.matches("^" + formatterTemplate.get().regex + "$")) {
                return LocalDate.parse(date, DateTimeFormatter
                        .ofPattern(formatterTemplate.get().code));
            }
            Pattern pattern = Pattern.compile(formatterTemplate.get().regex);
            Matcher matcher = pattern.matcher(date);
            if (matcher.find()) {
                return LocalDate.parse(matcher.group(), DateTimeFormatter
                        .ofPattern(formatterTemplate.get().code));
            }
            throw new IllegalArgumentException("error date: " + date);
        }

        public static boolean isDate(String date) {
            Optional<DateTemplate> dateTemplate =
                    Arrays.stream(DateTemplate.values())
                            .filter(template -> date.matches("^" + template.regex + "$"))
                            .findFirst();
            return dateTemplate.isPresent();
        }
    }

    public static String substring(String date, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        if (matcher.find()) {
            return matcher.group();
        }
        throw new IllegalArgumentException("not found regex.");
    }

    private Workbook getWorkbook(String fileName, FileInputStream file) throws IOException {
        System.out.println(fileName);
        if (fileName.endsWith(TypeBook.XLS.code)) {
            return new HSSFWorkbook(file);
        } else if (fileName.endsWith(TypeBook.XLSX.code)) {
            return new XSSFWorkbook(file);
        }
        throw new IllegalArgumentException("fileName invalid.");
    }

    public List<StudentDto> read(String fileLocation, int removeLines) {
        List<StudentDto> listStudentsDTO = new ArrayList<>();
        try (FileInputStream file = new FileInputStream(fileLocation)) {
            Workbook workbook = getWorkbook(fileLocation, file);

            Sheet sheet = workbook.getSheetAt(0);

            int i = 0;
            for (Row row : sheet) {
                if (removeLines != 0) {
                    removeLines--;
                    continue;
                }

                listStudentsDTO.add(convertToStudentDTO(row));
                //714
                if (i++ == 282)
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listStudentsDTO;
    }

    private StudentDto convertToStudentDTO(Row row) {
        StudentDto studentDTO = new StudentDto();
//        studentDTO.setStudy(new StudyDto());
//        studentDTO.getStudy().setOrderDTO(new OrderDto());

        Iterator<Cell> cellIterator = row.cellIterator();
        Cell cellInfo = null;

        try {
            while (cellIterator.hasNext()) {
                cellInfo = cellIterator.next();
                switch (cellInfo.getColumnIndex()) {
                    case 0 -> readStudentNumber(cellInfo, studentDTO);
                    case 1 -> readFirstNameLastName(cellInfo, studentDTO);
                    case 2 -> readYearStudy(cellInfo, studentDTO);
                    case 3 -> readYearBirth(cellInfo, studentDTO);
                    case 4 -> readGender(cellInfo, studentDTO);
                    case 5 -> readFinancing(cellInfo, studentDTO);
                    case 6 -> readDateAndOrderBegin(cellInfo, studentDTO);
                    case 7 -> readDateEnd(cellInfo, studentDTO);
                    case 8 -> readStudyType(cellInfo, studentDTO);
                    case 9 -> readSciencesDomain(cellInfo, studentDTO);
                    case 10 -> readSciencesBranch(cellInfo, studentDTO);
                    case 11 -> readSciencesProfile(cellInfo, studentDTO);
                    case 12 -> readIdSpeciality(cellInfo, studentDTO);
                    case 13 -> readSpecialty(cellInfo, studentDTO);
                    case 14 -> readDoctoralSchoolNew(cellInfo, studentDTO);
                    case 15 -> readDoctoralSchoolOld(cellInfo, studentDTO);
                    case 16 -> readFaculty(cellInfo, studentDTO);
                    case 17 -> readScientificSupervisor(cellInfo, studentDTO);
                    case 18 -> readSteeringCommittee(cellInfo, studentDTO);
                    case 19 -> readAdmissionInformation(cellInfo, studentDTO);
                    case 20 -> readPersonalContactData(cellInfo, studentDTO);
                    case 21 -> readRemark(cellInfo, studentDTO);
                    case 22 -> readCitizenship(cellInfo, studentDTO);
                    case 23 -> readStatus(cellInfo, studentDTO);
                }
            }
        } catch (RuntimeException e) {
            String ingoMessage = "";
            if (cellInfo != null) {
                ingoMessage = ". ROW : " + cellInfo.getRowIndex() +
                        "; COL : " + cellInfo.getColumnIndex();
            }
            throw new IllegalArgumentException(e.toString() + ingoMessage, e);
        }

//        System.out.println(studentDTO);

        return studentDTO;
    }

    private void readStudentNumber(Cell cell, StudentDto studentDTO) {
        cell.getStringCellValue();
    }

    private void readFirstNameLastName(Cell cell, StudentDto studentDTO) {
        List<String> fullName = new ArrayList<>(Arrays
                .stream(cell.getStringCellValue().split(" ")).toList());

        String firstName = fullName.remove(fullName.size() - 1);
        String lastName = String.join(" ", fullName);

        studentDTO.setFirstName(firstName);
        studentDTO.setLastName(lastName);
    }

    private void readYearStudy(Cell cell, StudentDto studentDTO) {
        String year = cell.getStringCellValue();
        YearStudy yearStudy;
        switch (year) {
            case "grație I-II" -> yearStudy = YearStudy.EXTRA_II;
            case "grație II" -> yearStudy = YearStudy.EXTRA_I;
            case "I" -> yearStudy = YearStudy.I;
            case "II" -> yearStudy = YearStudy.II;
            case "III" -> yearStudy = YearStudy.III;
            case "IV" -> yearStudy = YearStudy.IV;
            default -> yearStudy = null;
        }
        studentDTO.setYearStudy(yearStudy);
    }

    private void readYearBirth(Cell cell, StudentDto studentDTO) {
        int year = 0;
        switch (cell.getCellType()) {
            case STRING -> {
                String field = cell.getStringCellValue();
                if (field == null) {
                    return;
                }
                year = Integer.parseInt(substring(cell.getStringCellValue(), "[0-9]{4}"));
            }
            case NUMERIC -> year = (int) cell.getNumericCellValue();
        }
        studentDTO.setYearBirth(year);
    }

    private void readGender(Cell cell, StudentDto studentDTO) {
        String gender = cell.getStringCellValue().toUpperCase();
        Gender gender1;
        if(gender.equals("F")) {
            gender1 = Gender.F;
        } else {
            gender1 = Gender.M;
        }
        studentDTO.setGender(gender1);
    }

    private void readFinancing(Cell cell, StudentDto studentDTO) {
        String financingType = cell.getStringCellValue();
        switch (financingType) {
            case "b" -> financingType = Financing.BUDGET.toString();
            case "c" -> financingType = Financing.CONTRACT.toString();
        }
        ;
//        studentDTO.getStudy().setFinancing(financingType);
    }

    private void readDateAndOrderBegin(Cell cell, StudentDto studentDTO) {
        LocalDate dateBegin = null;
        String orderNumber;
        LocalDate orderDate;
        if (cell.getCellType() == CellType.NUMERIC) {
//            dateBegin = cell.getLocalDateTimeCellValue().toLocalDate();
//            studentDTO.getStudy().setBeginStudies(dateBegin);
            return;
        }
        List<String> dateAndOrderBegin = Arrays.stream(cell.getStringCellValue().split("(, )|(,\n)")).toList();
//        dateBegin = DateTemplate.toLocalDate(dateAndOrderBegin.get(0));
        if (dateAndOrderBegin.size() == 1) {
//            studentDTO.getStudy().setBeginStudies(dateBegin);
            return;
        }
        if (DateTemplate.isDate(dateAndOrderBegin.get(1))) {
            orderDate = DateTemplate.toLocalDate(dateAndOrderBegin.get(1));
//            studentDTO.setBeginStudies(dateBegin);
//            studentDTO.getStudy().getOrderDTO().setOrderDate(orderDate);
            return;
        }
        orderNumber = dateAndOrderBegin.get(1);
        if (orderNumber.matches(ORDER_REGEX)) {
            throw new IllegalArgumentException("order number invalid");
        }
        orderDate = DateTemplate.toLocalDate(dateAndOrderBegin.get(2));
        String dateRegex = "\\d{1,4}([/.-])\\d{1,2}\\1\\d{1,4}";

        Pattern pattern = Pattern.compile(dateRegex);
        Matcher matcher = pattern.matcher(cell.getStringCellValue());
        if (matcher.find()) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                dateBegin = LocalDate.parse(matcher.group(), formatter);
            }catch (DateTimeParseException e){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                dateBegin = LocalDate.parse(matcher.group(), formatter);
            }
        }
        studentDTO.setBeginStudies(dateBegin);
//        studentDTO.getStudy().getOrderDTO().setOrderNumber(orderNumber);
//        studentDTO.getStudy().getOrderDTO().setOrderDate(orderDate);
    }

    private void readDateEnd(Cell cell, StudentDto studentDTO) {
        LocalDate dateEnd = null;
        switch (cell.getCellType()) {
            case NUMERIC -> dateEnd = cell.getLocalDateTimeCellValue().toLocalDate();
            case STRING -> dateEnd = DateTemplate.toLocalDate(cell.getStringCellValue());
        }
//        studentDTO.getStudy().setEndStudies(dateEnd);
    }

    private void readStudyType(Cell cell, StudentDto studentDTO) {
        String studyType = cell.getStringCellValue();
        switch (studyType) {
            case "fr" -> studyType = StudyType.FREQUENCY.toString();
            case "zi" -> studyType = StudyType.LOW_FREQUENCY.toString();
        }
        ;
//        studentDTO.getStudy().setStudyType(studyType);
    }

    private void readSciencesDomain(Cell cell, StudentDto studentDTO) {
        cell.getStringCellValue();
    }

    private void readSciencesBranch(Cell cell, StudentDto studentDTO) {
//        ScienceBranch scienceBranch = new ScienceBranch();
//        String[] components = cell.getStringCellValue().split("\\.");
//        scienceBranch.setId(Float.valueOf(components[0]));
//        scienceBranch.setName(components[1].strip());
//        studentDTO.setScienceBranch(scienceBranch);

        cell.getStringCellValue();
    }

    private void readSciencesProfile(Cell cell, StudentDto studentDTO) {
        cell.getStringCellValue();
    }

    private void readIdSpeciality(Cell cell, StudentDto studentDTO) {
        Float idSpeciality = null;
        switch (cell.getCellType()) {
            case STRING -> idSpeciality = Float.parseFloat(
                    substring(cell.getStringCellValue(), "[0-9]{3}\\.[0-9]{2}"));
            case NUMERIC -> idSpeciality = Float.parseFloat(cell.getStringCellValue());
        }
        SpecialityDto specialityDto = new SpecialityDto();
        specialityDto.setId(idSpeciality);
//        studentDTO.setSpecialityId(specialityDto.getId());
    }

    private void readSpecialty(Cell cell, StudentDto studentDTO) {
        cell.getStringCellValue();
    }

    // TODO: add doctoral school
    private void readDoctoralSchoolNew(Cell cell, StudentDto studentDTO) {
        ScienceSchool scienceSchool = new ScienceSchool();
        scienceSchool.setName(cell.getStringCellValue());
//        studentDTO.setScienceSchool(scienceSchool);
    }

    private void readDoctoralSchoolOld(Cell cell, StudentDto studentDTO) {
        cell.getStringCellValue();
    }

    // TODO: add faculty
    private void readFaculty(Cell cell, StudentDto studentDTO) {
        cell.getStringCellValue();
    }

    // TODO: parse to scientific adviser
    private void readScientificSupervisor(Cell cell, StudentDto studentDTO) {
        String supervisorName = cell.getStringCellValue().split(",")[0];
//        Supervisor supervisor = supervisorRepository.findByFullName(supervisorName).orElseThrow();
//        studentDTO.setSupervisor(supervisorMapper.toDto(supervisor));
    }

    // TODO: parse to steering committee
    private void readSteeringCommittee(Cell cell, StudentDto studentDTO) {
        List<String> supervisors =
                Arrays.stream(cell.getStringCellValue().split("\n"))
                        .map(supervisor -> supervisor.split(",")[0]).toList();

//        Set<SupervisorDTO> supervisorsDTO = supervisors.stream()
//                .map(supervisorRepository::findByFullName)
//                .map(Optional::orElseThrow).map(supervisorMapper::toDto).collect(Collectors.toSet());
//
//        studentDTO.setSteeringCommittee(supervisorsDTO);
    }

    // TODO: parse to admission information
    private void readAdmissionInformation(Cell cell, StudentDto studentDTO) {
        cell.getStringCellValue();
    }

    private void readPersonalContactData(Cell cell, StudentDto studentDTO) {
        cell.getStringCellValue();
    }

    // TODO: parse to remark (V)
    private void readRemark(Cell cell, StudentDto studentDTO) {
        cell.getStringCellValue();
    }

    private void readCitizenship(Cell cell, StudentDto studentDTO) {
        String country = cell.getStringCellValue();
        CountryDto countryDTO = new CountryDto();

        switch (country) {
            case "RM" -> {
                countryDTO.setId(1);
                countryDTO.setCountry("Republica Moldova");
            }
            case "RO" -> {
                countryDTO.setId(2);
                countryDTO.setCountry("România");
            }
            case "Georgia" -> {
                countryDTO.setId(3);
                countryDTO.setCountry("Georgia");
            }
            case "GR" -> {
                countryDTO.setId(4);
                countryDTO.setCountry("Grecia");
            }
            case "Rusia" -> {
                countryDTO.setId(5);
                countryDTO.setCountry("Federația Rusă");
            }
            case "Israel" -> {
                countryDTO.setId(6);
                countryDTO.setCountry("Israel");
            }
            case "Ucr.", "Ucraina" -> {
                countryDTO.setId(7);
                countryDTO.setCountry("Ucraina");
            }
            case "Polonia" -> {
                countryDTO.setId(8);
                countryDTO.setCountry("Polonia");
            }
        }

        studentDTO.setCitizenship(countryDTO);
    }

    // TODO: resolve value: "CA"
    private void readStatus(Cell cell, StudentDto studentDTO) {
        String status = cell.getStringCellValue();

        switch (status) {
            case "Activ" -> status = "ACTIVE";
            case "CA" -> status = "INACTIVE";   // temp, is not inactive
        }
        status = "ACTIVE";
        studentDTO.setStatus(status);
    }
}
