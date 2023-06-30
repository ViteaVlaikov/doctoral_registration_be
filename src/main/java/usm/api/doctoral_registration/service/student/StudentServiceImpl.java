package usm.api.doctoral_registration.service.student;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.crosstab.CrossTab;
import usm.api.doctoral_registration.crosstab.StudentCrossTab;
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
                        Country.class.getName(), studentDto.getCitizenship().getId(), CodeException.COUNTRY_NOT_FOUND));
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
    public List<CrossTab.Item> createCrossTab(Map<String, String> params) {
               Map<String,List<String>> parameters = new HashMap<>();
        params.forEach((key,value) -> {
            List<String> split = List.of(value.split(","));
            parameters.put(key,split);
        });
//        CrossTab crossTab = new StudentCrossTab(students, parameters);
        List<Map<String, String>> maps = divideMap(new HashMap<>(parameters));
        System.out.println(maps);
//        System.out.println(combinations);
        return Collections.emptyList();
    }

    public static List<Map<String, String>> divideMap(Map<String, List<String>> inputMap) {
        List<Map<String, String>> dividedMaps = new ArrayList<>();
        divideMapHelper(inputMap, new HashMap<>(), dividedMaps);
        return dividedMaps;
    }

    private static void divideMapHelper(Map<String, List<String>> inputMap, Map<String, String> currentMap, List<Map<String, String>> dividedMaps) {
        if (inputMap.isEmpty()) {
            dividedMaps.add(currentMap);
            return;
        }

        String firstKey = inputMap.keySet().iterator().next();
        List<String> firstValues = inputMap.get(firstKey);

        if (firstValues.size() > 1) {
            for (String value : firstValues) {
                Map<String, String> newMap = new HashMap<>(currentMap);
                newMap.put(firstKey, value);

                Map<String, List<String>> newInputMap = new HashMap<>(inputMap);
                newInputMap.put(firstKey, Collections.singletonList(value));

                divideMapHelper(newInputMap, newMap, dividedMaps);
            }
        } else {
            currentMap.put(firstKey, firstValues.get(0));
            Map<String, List<String>> newInputMap = new HashMap<>(inputMap);
            newInputMap.remove(firstKey);
            divideMapHelper(newInputMap, currentMap, dividedMaps);
        }
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
