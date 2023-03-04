package usm.api.doctoral_registration.service.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.dto.student.StudentDto;
import usm.api.doctoral_registration.excel.StudentExcelReader;
import usm.api.doctoral_registration.mapper.student.StudentMapper;
import usm.api.doctoral_registration.model.student.Student;
import usm.api.doctoral_registration.model.student.properties.YearStudy;
import usm.api.doctoral_registration.repository.science.ScienceBranchRepository;
import usm.api.doctoral_registration.repository.science.SpecialityRepository;
import usm.api.doctoral_registration.repository.student.StudentRepository;
import usm.api.doctoral_registration.repository.supervisor.SupervisorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentExcelReader studentExcelTools;
    private final SupervisorRepository supervisorRepository;
    private final SpecialityRepository specialityRepository;
    private final static String PATH = "./src/test/java/usm/api/doctoral_registration/excel/";
    private final ScienceBranchRepository scienceBranchRepository;
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public List<StudentDto> findAll() {
        return studentExcelTools.read(PATH + "students.xlsx", 2);
    }

    @Override
    public void saveAll(List<Student> students) {
        for (Student student : students) {
//            supervisorRepository.save(student.getSupervisor());
//            specialityRepository.save(student.getSpeciality());
            studentRepository.save(student);
        }
    }

    @Override
    public List<StudentDto> findAllBySpecialityIdAndYear(Float speciality_id, YearStudy grade) {
        return studentRepository.findAllBySpecialityIdAndGrade(speciality_id, grade).stream()
                .map(studentMapper::toDto)
                .toList();
    }

    @Override
    public StudentDto findById(Long id) {
        return studentMapper.toDto(
                studentRepository.findById(id).orElseThrow());
    }


}
