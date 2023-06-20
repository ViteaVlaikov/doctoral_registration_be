package usm.api.doctoral_registration.service.excel_report;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.tools.excel.ExcelGenerator;
import usm.api.doctoral_registration.model.student.Student;
import usm.api.doctoral_registration.repository.student.StudentFilter;
import usm.api.doctoral_registration.repository.student.StudentRepository;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ExcelReportService {
    private final ExcelGenerator excelGenerator;
    private final StudentRepository studentRepository;

    public byte[] generateStudentReport(Map<String, String> params) {
        Specification<Student> specification = StudentFilter
                .convertMapToJpaSpecification(params);
        List<Student> students = studentRepository.findAll(specification);
        return excelGenerator.generateStudentReport(students);
    }
}
