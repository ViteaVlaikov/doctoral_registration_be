package usm.api.doctoral_registration.service.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.dto.student.StudentDto;
import usm.api.doctoral_registration.excel.StudentExcelReader;
import usm.api.doctoral_registration.repository.science.ScienceBranchRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentExcelReader studentExcelTools;

    private final static String PATH = "./src/test/java/usm/api/doctoral_registration/excel/";
    private final ScienceBranchRepository scienceBranchRepository;

    @Override
    public List<StudentDto> findAll() {
        return studentExcelTools.read(PATH + "students.xlsx", 2);
    }




}
