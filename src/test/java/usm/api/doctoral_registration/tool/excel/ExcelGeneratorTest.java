package usm.api.doctoral_registration.tool.excel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import usm.api.doctoral_registration.model.student.Student;
import usm.api.doctoral_registration.tools.excel.ExcelGenerator;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static usm.api.doctoral_registration.util.test.TestUtils.STUDENT_FOR_REPORT;

@SpringBootTest
@ActiveProfiles("test")
class ExcelGeneratorTest {
    @Mock
    private Workbook mockWorkbook;

    private ExcelGenerator excelGenerator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        excelGenerator = new ExcelGenerator();
    }

    @Test
    void testGenerateStudentReport() throws IOException {
        // Arrange
        List<Student> students = Collections.singletonList(STUDENT_FOR_REPORT);

        Sheet mockSheet = mock(Sheet.class);
        when(mockWorkbook.createSheet("Report")).thenReturn(mockSheet);
        // Act
        byte[] reportBytes = excelGenerator.generateStudentReport(students);

        // Assert
        Assertions.assertNotNull(reportBytes);

        // Verify interactions
//        verify(mockWorkbook).write(any());
//        verify(mockWorkbook).close();
//        verify(mockSheet, times(students.size())).createRow(anyInt());
    }
}
