package usm.api.doctoral_registration.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import usm.api.doctoral_registration.DTO.student.StudentDTO;

import java.io.FileInputStream;
import java.io.IOException;

public class StudentExcelTools {

    public void read(String fileLocation) {
        try (FileInputStream file = new FileInputStream(fileLocation)) {
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.println(cell);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private StudentDTO convertToStudentDTO() {
        return new StudentDTO();
    }
}
