package usm.api.doctoral_registration.excel;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


class StudentExcelToolsTest {

    private final StudentExcelReader studentExcelTools = new StudentExcelReader();

    private final static String PATH = "./src/test/java/usm/api/doctoral_registration/excel/";

    @Test
    void test() {
        studentExcelTools.read(PATH + "students.xlsx", 2);
    }


}