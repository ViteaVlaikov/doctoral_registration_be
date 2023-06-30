package usm.api.doctoral_registration.service.excel_report;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ActiveProfiles;
import usm.api.doctoral_registration.model.student.Student;
import usm.api.doctoral_registration.repository.student.StudentFilter;
import usm.api.doctoral_registration.repository.student.StudentRepository;
import usm.api.doctoral_registration.tools.excel.ExcelGenerator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class ExcelReportServiceTest {
    @Mock
    private ExcelGenerator excelGenerator;

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private ExcelReportService excelReportService;

    @Test
    public void testGenerateStudentReport_ValidParams_ReturnsGeneratedReport() {
        Map<String, String> params = new HashMap<>();
        params.put("school_id", "1");

        List<Student> students = Arrays.asList(new Student(), new Student());


        byte[] reportBytes = new byte[]{1, 2, 3, 4}; // Mocked report bytes

        when(studentRepository.findAll((Specification<Student>) any())).thenReturn(students);
        when(excelGenerator.generateStudentReport(students)).thenReturn(reportBytes);

        byte[] result = excelReportService.generateStudentReport(params);

        assertArrayEquals(reportBytes, result);
        verify(studentRepository, times(1)).findAll((Specification<Student>) any());
        verify(excelGenerator, times(1)).generateStudentReport(students);
    }
}
