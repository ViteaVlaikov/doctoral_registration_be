package usm.api.doctoral_registration.excel_tools;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import usm.api.doctoral_registration.model.order.Order;
import usm.api.doctoral_registration.model.student.Student;
import usm.api.doctoral_registration.model.supervisor.Supervisor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;


@Component
public class ExcelGenerator {
    public byte[] generateStudentReport(List<Student> students) {
        // Создание экземпляра Workbook
        Workbook workbook = new XSSFWorkbook();

        // Создание нового листа
        Sheet sheet = workbook.createSheet("Report");

        // Создание заголовка
        createHeader(sheet);


        //Создание кнотентной части
        generateContent(sheet, students);


        // Преобразование Workbook в массив байтов
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Получение отчета в виде массива байтов
        byte[] reportBytes = outputStream.toByteArray();

        // Закрытие Workbook и потока вывода
        try {
            workbook.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return reportBytes;
    }

    private void generateContent(Sheet sheet, List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(students.get(i).getId());
            row.createCell(1).setCellValue(students.get(i).getCorporateEmail());
            row.createCell(2).setCellValue(students.get(i).getFirstName());
            row.createCell(3).setCellValue(students.get(i).getLastName());
            row.createCell(4).setCellValue(students.get(i).getPatronymicName());
            row.createCell(5).setCellValue(students.get(i).getYearBirth());
            row.createCell(6).setCellValue(students.get(i).getIdentNumber());
            row.createCell(7).setCellValue(students.get(i).getGender().toString());
            row.createCell(8).setCellValue(students.get(i).getCitizenship().getCountry());
            row.createCell(9).setCellValue(students.get(i).getDiplomaSeries());
            row.createCell(10).setCellValue(students.get(i).getDiplomaNumber());
            row.createCell(11).setCellValue(students.get(i).getPersonalEmail());
            row.createCell(12).setCellValue(students.get(i).getPhoneNumber());
            writeStatus(students.get(i),row);
            writeRegistration(students.get(i), row);
            row.createCell(15).setCellValue(writeOrdersToCell(students.get(i).getOrders()));
            row.createCell(16).setCellValue(students.get(i).getYearStudy().toString());
            row.createCell(17).setCellValue(students.get(i).getBeginStudies());
            row.createCell(18).setCellValue(students.get(i).getEndStudies());
            row.createCell(19).setCellValue(students.get(i).getStudyType().toString());
            row.createCell(20).setCellValue(students.get(i).getFinancing().toString());
            row.createCell(21).setCellValue(students.get(i).getSupervisor().getFirstName() +
                    " " + students.get(i).getSupervisor().getLastName());
            row.createCell(22).setCellValue(students.get(i).getSpeciality().getId() +
                    " " + students.get(i).getSpeciality().getName());
            row.createCell(23).setCellValue(students.get(i).getSpeciality().getScienceProfile().getId() +
                    " " + students.get(i).getSpeciality().getScienceProfile().getName());
            row.createCell(24).setCellValue(students.get(i).getSpeciality().getScienceProfile().getScienceBranch().getId() +
                    " " + students.get(i).getSpeciality().getScienceProfile().getScienceBranch().getName());
            row.createCell(25).setCellValue(students.get(i).getSpeciality().getScienceProfile().getScienceBranch().getScienceDomain().getId() +
                    " " + students.get(i).getSpeciality().getScienceProfile().getScienceBranch().getScienceDomain().getName());
            row.createCell(26).setCellValue(students.get(i).getSpeciality().getScienceProfile().getScienceBranch().getScienceDomain().getScienceSchool().getId() +
                    " " + students.get(i).getSpeciality().getScienceProfile().getScienceBranch().getScienceDomain().getScienceSchool().getName());
            row.createCell(27).setCellValue(writeSteeringCommitteeToCell(students.get(i).getSteeringCommittee()));
            row.createCell(28).setCellValue(students.get(i).getScienceTopic());
            row.createCell(29).setCellValue(students.get(i).getRemark());

        }
        for (int i =0; i <= 29; i++){
            sheet.autoSizeColumn(i);
        }
    }

    private static void writeRegistration(Student student, Row row) {
        row.createCell(14);
        if(student.getRegistration()!=null)
            row.getCell(14).setCellValue(student.getRegistration().toString());
        else
            row.getCell(14).setCellValue("");
    }

    private static void writeStatus(Student student, Row row) {
        row.createCell(13);
        if(student.getStatus()!=null)
            row.getCell(13).setCellValue(student.getStatus().toString());
        else
            row.getCell(13).setCellValue("");
    }


    private static void createHeader(Sheet sheet) {
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Id");
        headerRow.createCell(1).setCellValue("corporateEmail");
        headerRow.createCell(2).setCellValue("firstName");
        headerRow.createCell(3).setCellValue("lastName");
        headerRow.createCell(4).setCellValue("patronymicName");
        headerRow.createCell(5).setCellValue("yearBirth");
        headerRow.createCell(6).setCellValue("identNumber");
        headerRow.createCell(7).setCellValue("gender");//name
        headerRow.createCell(8).setCellValue("citizenship");//name
        headerRow.createCell(9).setCellValue("diplomaSeries");
        headerRow.createCell(10).setCellValue("diplomaNumber");
        headerRow.createCell(11).setCellValue("personalEmail");
        headerRow.createCell(12).setCellValue("phoneNumber");
        headerRow.createCell(13).setCellValue("status");//name
        headerRow.createCell(14).setCellValue("registration");//name
        headerRow.createCell(15).setCellValue("orders");//StringBuilder
        headerRow.createCell(16).setCellValue("yearStudy");//name
        headerRow.createCell(17).setCellValue("beginStudies");
        headerRow.createCell(18).setCellValue("endStudies");
        headerRow.createCell(19).setCellValue("studyType");//name
        headerRow.createCell(20).setCellValue("financing");//name
        headerRow.createCell(21).setCellValue("supervisor");//name
        headerRow.createCell(22).setCellValue("speciality");//name
        headerRow.createCell(23).setCellValue("profile");//name
        headerRow.createCell(24).setCellValue("branch");//name
        headerRow.createCell(25).setCellValue("domain");
        headerRow.createCell(26).setCellValue("school");
        headerRow.createCell(27).setCellValue("steeringCommittee");
        headerRow.createCell(28).setCellValue("scienceTopic");
        headerRow.createCell(29).setCellValue("remark");

    }

    private String writeOrdersToCell(List<Order> orders) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Order order : orders) {
            stringBuilder.append(order.getOrderSubtype().getOrder()).append(" ").append(order.getNumber()).append(" ")
                    .append(order.getDate()).append("\n");
        }
        return stringBuilder.toString();
    }

    private String writeSteeringCommitteeToCell(Set<Supervisor> steeringCommittee) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Supervisor supervisor : steeringCommittee) {
            stringBuilder.append(supervisor.getFirstName()).append(" ").append(supervisor.getLastName()).append("\n");
        }
        return stringBuilder.toString();
    }

}
