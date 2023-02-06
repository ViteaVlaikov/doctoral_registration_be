package usm.api.doctoral_registration.service.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.DTO.student.StudentDTO;
import usm.api.doctoral_registration.excel.StudentExcelReader;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentExcelReader studentExcelTools = new StudentExcelReader();

    private final static String PATH = "./src/test/java/usm/api/doctoral_registration/excel/";
    @Override
    public List<StudentDTO> findAll() {
        return studentExcelTools.read(PATH + "students.xlsx", 2);
    }
}
