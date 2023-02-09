package usm.api.doctoral_registration.excel;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import usm.api.doctoral_registration.DTO.order.OrderDTO;
import usm.api.doctoral_registration.DTO.student.StudentDTO;
import usm.api.doctoral_registration.DTO.student.StudyDTO;
import usm.api.doctoral_registration.model.sciences.ScienceSchool;
import usm.api.doctoral_registration.model.sciences.SciencesBranch;
import usm.api.doctoral_registration.model.student.Financing;
import usm.api.doctoral_registration.model.student.StudyType;
import usm.api.doctoral_registration.model.student.YearStudy;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class StudentExcelReader {

    private final static String ORDER_REGEX = "$[0-9]{1,10}-c";

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

    public List<StudentDTO> read(String fileLocation, int removeLines) {
        List<StudentDTO> listStudentsDTO = new ArrayList<>();
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
                if(i++ == 100)
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listStudentsDTO;
    }

    private StudentDTO convertToStudentDTO(Row row) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudyDTO(new StudyDTO());
        studentDTO.getStudyDTO().setOrderDTO(new OrderDTO());

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
                    case 17 -> readScientificAdviser(cellInfo, studentDTO);
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

        System.out.println(studentDTO);

        return studentDTO;
    }

    private void readStudentNumber(Cell cell, StudentDTO studentDTO) {
        cell.getStringCellValue();
    }

    private void readFirstNameLastName(Cell cell, StudentDTO studentDTO) {
        List<String> fullName = new ArrayList<>(Arrays
                .stream(cell.getStringCellValue().split(" ")).toList());

        String firstName = fullName.remove(fullName.size() - 1);
        String lastName = String.join(" ", fullName);

        studentDTO.setFirstName(firstName);
        studentDTO.setLastName(lastName);
    }

    private void readYearStudy(Cell cell, StudentDTO studentDTO) {
        String yearStudy = cell.getStringCellValue();
        switch (yearStudy) {
            case "grație I-II" -> yearStudy = YearStudy.EXTRA_II.toString();
            case "grație II" -> yearStudy = YearStudy.EXTRA_I.toString();
            default -> yearStudy = cell.getStringCellValue();
        }
        studentDTO.getStudyDTO().setYearStudy(yearStudy);
    }

    private void readYearBirth(Cell cell, StudentDTO studentDTO) {
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

    private void readGender(Cell cell, StudentDTO studentDTO) {
        String gender = cell.getStringCellValue().toUpperCase();
        studentDTO.setGender(gender);
    }

    private void readFinancing(Cell cell, StudentDTO studentDTO) {
        String financingType = cell.getStringCellValue();
        switch (financingType) {
            case "b" -> financingType = Financing.BUDGET.toString();
            case "c" -> financingType = Financing.CONTRACT.toString();
        }
        ;
        studentDTO.getStudyDTO().setFinancing(financingType);
    }

    private void readDateAndOrderBegin(Cell cell, StudentDTO studentDTO) {
        LocalDate dateBegin;
        String orderNumber;
        LocalDate orderDate;
        if (cell.getCellType() == CellType.NUMERIC) {
            dateBegin = cell.getLocalDateTimeCellValue().toLocalDate();
            studentDTO.getStudyDTO().setBeginStudies(dateBegin);
            return;
        }
        List<String> dateAndOrderBegin = Arrays.stream(cell.getStringCellValue().split("(, )|(,\n)")).toList();
        dateBegin = DateTemplate.toLocalDate(dateAndOrderBegin.get(0));
        if (dateAndOrderBegin.size() == 1) {
            studentDTO.getStudyDTO().setBeginStudies(dateBegin);
            return;
        }
        if (DateTemplate.isDate(dateAndOrderBegin.get(1))) {
            orderDate = DateTemplate.toLocalDate(dateAndOrderBegin.get(1));
            studentDTO.getStudyDTO().setBeginStudies(dateBegin);
            studentDTO.getStudyDTO().getOrderDTO().setOrderDate(orderDate);
            return;
        }
        orderNumber = dateAndOrderBegin.get(1);
        if (orderNumber.matches(ORDER_REGEX)) {
            throw new IllegalArgumentException("order number invalid");
        }
        orderDate = DateTemplate.toLocalDate(dateAndOrderBegin.get(2));
        studentDTO.getStudyDTO().setBeginStudies(dateBegin);
        studentDTO.getStudyDTO().getOrderDTO().setOrderNumber(orderNumber);
        studentDTO.getStudyDTO().getOrderDTO().setOrderDate(orderDate);
    }

    private void readDateEnd(Cell cell, StudentDTO studentDTO) {
        LocalDate dateEnd = null;
        switch (cell.getCellType()) {
            case NUMERIC -> dateEnd = cell.getLocalDateTimeCellValue().toLocalDate();
            case STRING -> dateEnd = DateTemplate.toLocalDate(cell.getStringCellValue());
        }
        studentDTO.getStudyDTO().setEndStudies(dateEnd);
    }

    private void readStudyType(Cell cell, StudentDTO studentDTO) {
        String studyType = cell.getStringCellValue();
        switch (studyType) {
            case "fr" -> studyType = StudyType.FREQUENCY.toString();
            case "zi" -> studyType = StudyType.LOW_FREQUENCY.toString();
        }
        ;
        studentDTO.getStudyDTO().setStudyType(studyType);
    }

    private void readSciencesDomain(Cell cell, StudentDTO studentDTO) {
        cell.getStringCellValue();
    }

    private void readSciencesBranch(Cell cell, StudentDTO studentDTO) {
        SciencesBranch sciencesBranch = new SciencesBranch();
        String[] components = cell.getStringCellValue().split("\\.");
        sciencesBranch.setId(Float.valueOf(components[0]));
        sciencesBranch.setName(components[1].strip());
        studentDTO.setSciencesBranch(sciencesBranch);
    }

    private void readSciencesProfile(Cell cell, StudentDTO studentDTO) {
        cell.getStringCellValue();
    }

    private void readIdSpeciality(Cell cell, StudentDTO studentDTO) {
        Float idSpeciality = null;
        switch (cell.getCellType()) {
            case STRING -> idSpeciality = Float.parseFloat(
                    substring(cell.getStringCellValue(), "[0-9]{3}\\.[0-9]{2}"));
            case NUMERIC -> idSpeciality = Float.parseFloat(cell.getStringCellValue());
        }
        studentDTO.getStudyDTO().setSpeciality(idSpeciality);
    }

    private void readSpecialty(Cell cell, StudentDTO studentDTO) {
        cell.getStringCellValue();
    }

    // TODO: add doctoral school
    private void readDoctoralSchoolNew(Cell cell, StudentDTO studentDTO) {
        ScienceSchool scienceSchool = new ScienceSchool();
        scienceSchool.setName(cell.getStringCellValue());
        studentDTO.setScienceSchool(scienceSchool);
    }

    private void readDoctoralSchoolOld(Cell cell, StudentDTO studentDTO) {
        cell.getStringCellValue();
    }

    // TODO: add faculty
    private void readFaculty(Cell cell, StudentDTO studentDTO) {
        cell.getStringCellValue();
    }

    // TODO: parse to scientific adviser
    private void readScientificAdviser(Cell cell, StudentDTO studentDTO) {
        cell.getStringCellValue();
    }

    // TODO: parse to steering committee
    private void readSteeringCommittee(Cell cell, StudentDTO studentDTO) {
        cell.getStringCellValue();
    }

    // TODO: parse to admission information
    private void readAdmissionInformation(Cell cell, StudentDTO studentDTO) {
        cell.getStringCellValue();
    }

    private void readPersonalContactData(Cell cell, StudentDTO studentDTO) {
        cell.getStringCellValue();
    }

    // TODO: parse to remark (V)
    private void readRemark(Cell cell, StudentDTO studentDTO) {
        cell.getStringCellValue();
    }

    private void readCitizenship(Cell cell, StudentDTO studentDTO) {
        String country = cell.getStringCellValue();
        Integer idCountry = null;

        switch (country) {
            case "RM" -> idCountry = 1;
            case "RO" -> idCountry = 2;
            case "Georgia" -> idCountry = 3;
            case "GR" -> idCountry = 4;
            case "Rusia" -> idCountry = 5;
            case "Israel" -> idCountry = 6;
            case "Ucr.", "Ucraina" -> idCountry = 7;
            case "Polonia" -> idCountry = 8;
        }

        studentDTO.setCitizenship(idCountry);
    }

    // TODO: resolve value: "CA"
    private void readStatus(Cell cell, StudentDTO studentDTO) {
        String status = cell.getStringCellValue();

        switch (status) {
            case "Activ" -> status = "Active";
            case "CA" -> status = "";
        }
        studentDTO.setStatus(status);
    }
}
