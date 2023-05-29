package usm.api.doctoral_registration.service.student;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.crosstab.CrossTab;
import usm.api.doctoral_registration.dto.student.StudentDto;
import usm.api.doctoral_registration.exception.entity.SpecialityNotFoundException;
import usm.api.doctoral_registration.exception.entity.StudentNotFoundException;
import usm.api.doctoral_registration.exception.entity.SupervisorNotFoundException;
import usm.api.doctoral_registration.exception.request.UnExpectedFieldInRequestException;
import usm.api.doctoral_registration.exception.request.UnexpectedIdForUpdateRequestException;
import usm.api.doctoral_registration.mapper.student.StudentMapper;
import usm.api.doctoral_registration.model.science.Speciality;
import usm.api.doctoral_registration.model.student.Student;
import usm.api.doctoral_registration.model.student.properties.YearStudy;
import usm.api.doctoral_registration.model.supervisor.Supervisor;
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

    private final SupervisorRepository supervisorRepository;

    private final SpecialityRepository specialityRepository;

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    @Override
    public List<StudentDto> findAll() {
        return studentRepository.findAll().stream().map(studentMapper::toDto).toList();
    }

    @Override
    public void saveAll(List<Student> students) {
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
        if(params==null){
            return studentRepository.findAll().stream()
                    .map(studentMapper::toDto).toList();
        }
        Specification<Student> specification = StudentFilter
                .convertMapToJpaSpecification(params);
        return studentRepository.findAll(specification)
                .stream().map(studentMapper::toDto).toList();
    }

    @Override
    public StudentDto save(StudentDto studentDto) {
        if (studentDto.getId() != null) {
            throw new UnExpectedFieldInRequestException("Id: " + studentDto.getId());
        }
        Speciality speciality = specialityRepository.findById(studentDto.getSpecialityDto().getId())
                .orElseThrow(() -> new SpecialityNotFoundException(studentDto.getSpecialityDto().getId()));
        Supervisor supervisor = supervisorRepository.findById(studentDto.getSupervisor().getId())
                .orElseThrow(() -> new SupervisorNotFoundException(studentDto.getSupervisor().getId()));
        //TODO: add saving steering committee for supervisors
        Set<Supervisor> supervisorSet = new HashSet<>();
        studentDto.getSteeringCommittee()
                .forEach(
                        supervisorDto -> supervisorSet.add(supervisorRepository.findById(supervisorDto.getId())
                                .orElseThrow(
                                        () -> new SupervisorNotFoundException(studentDto.getSupervisor().getId())
                                )
                        )
                );
        Student student = studentMapper.toEntity(studentDto);
        student.setSpeciality(speciality);
        student.setSupervisor(supervisor);
        student.setSteeringCommittee(supervisorSet);
        return studentMapper.toDto(studentRepository.save(student));
    }

    @Override
    public List<CrossTab.Item> createCrossTab(Map<String, String> params) {
//        CrossTab crossTab = new StudentCrossTab(params);
//        List<Student> all = studentRepository.findAll(StudentRepository.group("yearStudy", null,"gender", "speciality"));
//        all.forEach(System.out::println);
        return null;
    }

    @Override
    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        if (studentDto.getId() != null) {
            throw new UnexpectedIdForUpdateRequestException(id);
        }
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new StudentNotFoundException(id)
        );
        updateStudentFields(student, studentMapper.toEntity(studentDto));
        return studentMapper.toDto(studentRepository.save(student));
    }

    private void updateStudentFields(Student studentForUpdate, Student studentSource) {
        if (studentSource.getCorporateEmail() != null) {
            studentForUpdate.setFirstName(studentSource.getFirstName());
        }
        if (studentSource.getFirstName() != null) {
            studentForUpdate.setFirstName(studentSource.getFirstName());
        }
        if (studentSource.getLastName() != null) {
            studentForUpdate.setLastName(studentSource.getLastName());
        }
        if (studentSource.getPatronymicName() != null) {
            studentForUpdate.setPatronymicName(studentSource.getPatronymicName());
        }
        if (studentSource.getYearBirth() != 0) {
            studentForUpdate.setYearBirth(studentSource.getYearBirth());
        }
        if (studentSource.getIdentNumber() != null) {
            studentForUpdate.setIdentNumber(studentSource.getIdentNumber());
        }
        if (studentSource.getGender() != null) {
            studentForUpdate.setGender(studentSource.getGender());
        }
        if (studentSource.getCitizenship() != null) {
            studentForUpdate.setCitizenship(studentSource.getCitizenship());
        }
        if (studentSource.getDiplomaSeries() != null) {
            studentForUpdate.setDiplomaSeries(studentSource.getDiplomaSeries());
        }
        if (studentSource.getDiplomaNumber() != 0) {
            studentForUpdate.setDiplomaNumber(studentSource.getDiplomaNumber());
        }
        if (studentSource.getPersonalEmail() != null) {
            studentForUpdate.setPersonalEmail(studentSource.getPersonalEmail());
        }
        if (studentSource.getPhoneNumber() != null) {
            studentForUpdate.setPhoneNumber(studentSource.getPhoneNumber());
        }
        if (studentSource.getStatus() != null) {
            studentForUpdate.setStatus(studentSource.getStatus());
        }
        if (studentSource.getRegistration() != null) {
            studentForUpdate.setRegistration(studentSource.getRegistration());
        }
        if (studentSource.getOrders() != null) {
            studentForUpdate.setOrders(studentSource.getOrders());
        }
        if (studentSource.getYearStudy() != null) {
            studentForUpdate.setYearStudy(studentSource.getYearStudy());
        }
        if (studentSource.getBeginStudies() != null) {
            studentForUpdate.setBeginStudies(studentSource.getBeginStudies());
        }
        if (studentSource.getEndStudies() != null) {
            studentForUpdate.setEndStudies(studentSource.getEndStudies());
        }
        if (studentSource.getStudyType() != null) {
            studentForUpdate.setStudyType(studentSource.getStudyType());
        }
        if (studentSource.getFinancing() != null) {
            studentForUpdate.setFinancing(studentSource.getFinancing());
        }
        if (studentSource.getSupervisor() != null) {
            studentForUpdate.setSupervisor(studentSource.getSupervisor());
        }
        if (studentSource.getSpeciality() != null) {
            studentForUpdate.setSpeciality(studentSource.getSpeciality());
        }
        if (studentSource.getSteeringCommittee() != null) {
            studentForUpdate.setSteeringCommittee(studentSource.getSteeringCommittee());
        }
        if (studentSource.getScienceTopic() != null) {
            studentForUpdate.setScienceTopic(studentSource.getScienceTopic());
        }
        if (studentSource.getRemark() != null) {
            studentForUpdate.setRemark(studentSource.getRemark());
        }
    }

}
