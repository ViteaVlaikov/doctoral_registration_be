package usm.api.doctoral_registration.service.student;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.crosstab.CrossTab;
import usm.api.doctoral_registration.dto.student.StudentDto;
//import usm.api.doctoral_registration.excel.StudentExcelReader;
import usm.api.doctoral_registration.exception.entity.StudentNotFoundException;
import usm.api.doctoral_registration.mapper.YearStudyMapper;
import usm.api.doctoral_registration.mapper.student.StudentMapper;
import usm.api.doctoral_registration.model.science.Speciality;
import usm.api.doctoral_registration.model.student.Student;
import usm.api.doctoral_registration.model.student.properties.YearStudy;
import usm.api.doctoral_registration.model.supervisor.Supervisor;
import usm.api.doctoral_registration.repository.science.ScienceBranchRepository;
import usm.api.doctoral_registration.repository.science.SpecialityRepository;
import usm.api.doctoral_registration.repository.student.StudentFilter;
import usm.api.doctoral_registration.repository.student.StudentRepository;
import usm.api.doctoral_registration.repository.supervisor.SupervisorRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
//    private final StudentExcelReader studentExcelTools;
    private final SupervisorRepository supervisorRepository;
    private final SpecialityRepository specialityRepository;
//    private final static String PATH = "./src/test/java/usm/api/doctoral_registration/excel/";
//    private final ScienceBranchRepository scienceBranchRepository;
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

//    private final YearStudyMapper yearStudyMapper;

    @Override
    public List<StudentDto> findAll() {
//        return studentExcelTools.read(PATH + "students.xlsx", 2);
        return studentRepository.findAll().stream().map(studentMapper::toDto).toList();
    }

    @Override
    public void saveAll(List<Student> students) {
        //            supervisorRepository.save(student.getSupervisor());
        //            specialityRepository.save(student.getSpeciality());
        studentRepository.saveAll(students);
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
                studentRepository.findById(id).orElseThrow(
                        () -> new StudentNotFoundException(id)
                ));
    }

    @Override
    public List<StudentDto> findByParams(Map<String, String> params) {
        Specification<Student> specification = StudentFilter
                .convertMapToJpaSpecification(params);
        return studentRepository.findAll(specification)
                .stream().map(studentMapper::toDto).toList();
    }

    @Override
    public StudentDto save(StudentDto studentDto) {
        System.out.println(studentDto);
        Speciality speciality = specialityRepository.findById(studentDto.getSpecialityDto().getId()).orElseThrow();
        Supervisor supervisor = supervisorRepository.findById(studentDto.getSupervisor().getId()).orElseThrow();
        Set<Supervisor> supervisorSet = new HashSet<>();
        studentDto.getSteeringCommittee().forEach(supervisorDto -> supervisorSet.add(supervisorRepository.findById(supervisorDto.getId()).orElseThrow()));
        Student student = studentMapper.toEntity(studentDto);
        student.setSpeciality(speciality);
        student.setSupervisor(supervisor);
        student.setSteeringCommittee(supervisorSet);
        return studentMapper.toDto(studentRepository.save(student));
    }
}
