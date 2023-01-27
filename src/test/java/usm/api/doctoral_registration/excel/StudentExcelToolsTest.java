package usm.api.doctoral_registration.excel;

import org.junit.jupiter.api.Test;


class StudentExcelToolsTest {

    private final StudentExcelTools studentExcelTools = new StudentExcelTools();

    private final static String PATH = "./src/test/java/usm/api/doctoral_registration/excel/";

    @Test
    void test() {
        studentExcelTools.read(PATH + "students.xlsx");
    }
}