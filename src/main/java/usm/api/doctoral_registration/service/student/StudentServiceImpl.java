package usm.api.doctoral_registration.service.student;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.crosstab.CrossTab;
import usm.api.doctoral_registration.dto.student.StudentDto;
import usm.api.doctoral_registration.exception.CodeException;
import usm.api.doctoral_registration.exception.model.EntityNotFoundException;
import usm.api.doctoral_registration.exception.request.UnExpectedFieldInRequestException;
import usm.api.doctoral_registration.exception.request.UnexpectedIdForUpdateRequestException;
import usm.api.doctoral_registration.mapper.student.StudentMapper;
import usm.api.doctoral_registration.model.country.Country;
import usm.api.doctoral_registration.model.science.Speciality;
import usm.api.doctoral_registration.model.student.Student;
import usm.api.doctoral_registration.model.student.properties.YearStudy;
import usm.api.doctoral_registration.model.supervisor.Supervisor;
import usm.api.doctoral_registration.repository.country.CountryRepository;
import usm.api.doctoral_registration.repository.science.ScienceDomainRepository;
import usm.api.doctoral_registration.repository.science.SpecialityRepository;
import usm.api.doctoral_registration.repository.student.StudentFilter;
import usm.api.doctoral_registration.repository.student.StudentRepository;
import usm.api.doctoral_registration.repository.supervisor.SupervisorRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final SupervisorRepository supervisorRepository;

    private final SpecialityRepository specialityRepository;

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    private final CountryRepository countryRepository;

    @Override
    public List<StudentDto> findAll() {
        return studentRepository.findAll().stream().map(studentMapper::toDto).toList();
    }

    @Override
    public List<StudentDto> findAllBySpecialityIdAndYear(Float specialityId, YearStudy grade) {
        return studentRepository.findAllBySpecialityIdAndGrade(specialityId, grade).stream()
                .map(studentMapper::toDto)
                .toList();
    }

    @Override
    public StudentDto findById(Long id) {
        return studentMapper.toDto(
                studentRepository.findById(id).orElseThrow(
                        () -> new EntityNotFoundException(Student.class.getName(), id, CodeException.SUPERVISOR_NOT_FOUND)
                ));
    }

    @Override
    public List<StudentDto> findByParams(Map<String, String> params) {
        if (params == null) {
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
        Country country = countryRepository.findById(studentDto.getCitizenship().getId())
                .orElseThrow(() -> new EntityNotFoundException(
                        Country.class.getName(),studentDto.getCitizenship().getId(),CodeException.COUNTRY_NOT_FOUND));
        Speciality speciality = specialityRepository.findById(studentDto.getSpeciality().getId())
                .orElseThrow(() -> new EntityNotFoundException(
                        Student.class.getName(), studentDto.getSpeciality().getId(), CodeException.STUDENT_NOT_FOUND));
        Supervisor supervisor = supervisorRepository.findById(studentDto.getSupervisor().getId())
                .orElseThrow(() -> new EntityNotFoundException(
                        Supervisor.class.getName(), studentDto.getSupervisor().getId(), CodeException.SUPERVISOR_NOT_FOUND));
        Set<Supervisor> supervisorSet = new HashSet<>();
        studentDto.getSteeringCommittee()
                .forEach(
                        supervisorDto -> supervisorSet.add(supervisorRepository.findById(supervisorDto.getId())
                                .orElseThrow(
                                        () -> new EntityNotFoundException(
                                                Student.class.getName(), studentDto.getSupervisor().getId(), CodeException.STUDENT_NOT_FOUND)
                                )
                        )
                );
        Student student = studentMapper.toEntity(studentDto);
        student.setSpeciality(speciality);
        student.setSupervisor(supervisor);
        student.setSteeringCommittee(supervisorSet);
        student.setCitizenship(country);
        return studentMapper.toDto(studentRepository.save(student));
    }

    @Override
    @SuppressWarnings("unused")
    public StudentDto save1(StudentDto studentDto) {
        if (studentDto.getId() != null) {
            throw new UnExpectedFieldInRequestException("Id: " + studentDto.getId());
        }
        Speciality speciality = new Speciality();
        if (studentDto.getSpeciality() != null) {
            speciality = specialityRepository.findById(studentDto.getSpeciality().getId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            Speciality.class.getName(), studentDto.getSpeciality().getId(), CodeException.SPECIALITY_NOT_FOUND));
        }
        Supervisor supervisor = null;
        if (studentDto.getSupervisor().getId() != null) {
            supervisor = supervisorRepository.findById(studentDto.getSupervisor().getId())
                    .orElseThrow(
                            () -> new EntityNotFoundException(
                                    Supervisor.class.getName(), studentDto.getSupervisor().getId(), CodeException.SUPERVISOR_NOT_FOUND));
        }
        Set<Supervisor> supervisorSet = new HashSet<>();
        if (studentDto.getSteeringCommittee() != null) {
            studentDto.getSteeringCommittee()
                    .forEach(
                            supervisorDto -> supervisorSet.add(supervisorRepository.findById(supervisorDto.getId())
                                    .orElseThrow(
                                            () -> new EntityNotFoundException(
                                                    Supervisor.class.getName(), studentDto.getSupervisor().getId(), CodeException.SUPERVISOR_NOT_FOUND)
                                    )
                            )
                    );
        }
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
        return Collections.emptyList();
    }

    @Override
    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        if (studentDto.getId() != null) {
            throw new UnexpectedIdForUpdateRequestException(id);
        }
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(Student.class.getName(), id, CodeException.STUDENT_NOT_FOUND)
        );
        return studentMapper.toDto(studentRepository.save(student));
    }
}
