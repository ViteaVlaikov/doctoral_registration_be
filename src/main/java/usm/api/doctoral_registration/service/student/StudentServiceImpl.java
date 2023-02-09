package usm.api.doctoral_registration.service.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.DTO.student.StudentDTO;
import usm.api.doctoral_registration.DTO.student.StudyDTO;
import usm.api.doctoral_registration.excel.StudentExcelReader;
import usm.api.doctoral_registration.repository.sciences.SciencesBranchRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentExcelReader studentExcelTools = new StudentExcelReader();

    private final static String PATH = "./src/test/java/usm/api/doctoral_registration/excel/";
    private final SciencesBranchRepository sciencesBranchRepository;

    @Override
    public List<StudentDTO> findAll() {
        return studentExcelTools.read(PATH + "students.xlsx", 2);
    }




}
