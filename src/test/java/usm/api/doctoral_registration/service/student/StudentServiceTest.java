package usm.api.doctoral_registration.service.student;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ActiveProfiles;
import usm.api.doctoral_registration.crosstab.CrossTab;
import usm.api.doctoral_registration.dto.student.StudentDto;
import usm.api.doctoral_registration.dto.supervisor.SupervisorDto;
import usm.api.doctoral_registration.exception.request.UnExpectedFieldInRequestException;
import usm.api.doctoral_registration.exception.request.UnexpectedIdForUpdateRequestException;
import usm.api.doctoral_registration.mapper.student.StudentMapper;
import usm.api.doctoral_registration.model.country.Country;
import usm.api.doctoral_registration.model.science.Speciality;
import usm.api.doctoral_registration.model.student.Student;
import usm.api.doctoral_registration.model.student.properties.Financing;
import usm.api.doctoral_registration.model.student.properties.Gender;
import usm.api.doctoral_registration.model.student.properties.Status;
import usm.api.doctoral_registration.model.student.properties.YearStudy;
import usm.api.doctoral_registration.model.supervisor.Supervisor;
import usm.api.doctoral_registration.repository.country.CountryRepository;
import usm.api.doctoral_registration.repository.science.SpecialityRepository;
import usm.api.doctoral_registration.repository.student.StudentRepository;
import usm.api.doctoral_registration.repository.supervisor.SupervisorRepository;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static usm.api.doctoral_registration.util.test.TestUtils.*;
import static usm.api.doctoral_registration.util.string.StringUtils.ClassField;
@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private SupervisorRepository supervisorRepository;

    @Mock
    private SpecialityRepository specialityRepository;

    @Mock
    private CountryRepository countryRepository;

    @Mock
    private StudentMapper studentMapper;

    @InjectMocks
    private StudentServiceImpl studentService;

    private final List<Student> students = Arrays.asList(STUDENT_FOR_SAVING_1, STUDENT_FOR_SAVING_2, STUDENT_FOR_SAVING_3);

    private final Student student = STUDENT_FOR_SAVING_1;
    private final StudentDto studentDto = STUDENT_DTO_1_FULL;

    private final List<StudentDto> studentDtoList = Arrays.asList(STUDENT_DTO_1_FULL, STUDENT_DTO_2_FULL, STUDENT_DTO_3_FULL);

    @Test
    public void testGenerateCrossTab() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put(ClassField.STATUS, Status.ACTIVE.name());
        parameters.put(ClassField.FINANCING, Financing.BUDGET.name());
        parameters.put(ClassField.GENDER, Gender.M + "," + Gender.F);

        List<StudentDto> expected = Collections.singletonList(studentDto);

        when(studentRepository.findAll(any(Specification.class))).thenReturn(students);
        when(studentMapper.toDto(students.get(0))).thenReturn(studentDtoList.get(0));
        when(studentMapper.toDto(students.get(1))).thenReturn(studentDtoList.get(1));
        when(studentMapper.toDto(students.get(2))).thenReturn(studentDtoList.get(2));

        List<CrossTab.Item> crossTab = studentService.createCrossTab(parameters);
    }

    @Test
    public void testFindAll() {
        List<StudentDto> expected = Collections.singletonList(studentDto);

        when(studentRepository.findAll()).thenReturn(List.of(new Student()));
        when(studentMapper.toDto(any(Student.class))).thenReturn(studentDto);

        List<StudentDto> result = studentService.findAll();

        assertEquals(expected, result);
    }

    @Test
    public void testFindById() {

        when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));
        when(studentMapper.toDto(any(Student.class))).thenReturn(studentDto);

        StudentDto result = studentService.findById(student.getId());

        assertEquals(studentDto, result);
    }

    @Test
    public void testFindAllBySpecialityIdAndYear() {
        List<StudentDto> expected = Collections.singletonList(studentDto);

        Float specialityId = 1.0f;
        YearStudy grade = YearStudy.I;

        when(studentRepository.findAllBySpecialityIdAndGrade(specialityId, grade)).thenReturn(List.of(new Student()));
        when(studentMapper.toDto(any(Student.class))).thenReturn(studentDto);

        List<StudentDto> result = studentService.findAllBySpecialityIdAndYear(specialityId, grade);

        assertEquals(expected, result);
    }


    @Test
    public void testFindByParams() {
        Map<String, String> params = new HashMap<>();
        params.put("school_id", "1");

        List<Student> students = new ArrayList<>();
        students.add(new Student());

        when(studentRepository.findAll((Specification<Student>) any())).thenReturn(students);
        when(studentMapper.toDto(any())).thenReturn(new StudentDto());

        List<StudentDto> expected = students.stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());

        List<StudentDto> result = studentService.findByParams(params);

        assertEquals(expected, result);
    }

    @Test
    public void testSave_NewStudent() {
        StudentDto studentDto = STUDENT_DTO_1_FULL;
        studentDto.setId(null);

        Country country = MOLDOVA;

        Speciality speciality = SPECIALITY_1_FOR_REPORT;

        Supervisor supervisor = SUPERVISOR_1_FULL;

        Set<SupervisorDto> steeringCommittee = STEERING_COMMITTEE_DTO;
        SupervisorDto steeringCommitteeMember1 = SUPERVISOR_DTO_2_FULL;

        Student studentForSaving = STUDENT_1_FULL;

        when(countryRepository.findById(country.getId())).thenReturn(Optional.of(country));
        when(specialityRepository.findById(speciality.getId())).thenReturn(Optional.of(speciality));
        when(supervisorRepository.findById(supervisor.getId())).thenReturn(Optional.of(supervisor));
        when(supervisorRepository.findById(steeringCommitteeMember1.getId())).thenReturn(Optional.of(new Supervisor()));
        when(studentMapper.toEntity(studentDto)).thenReturn(studentForSaving);
        when(studentRepository.save(studentForSaving)).thenReturn(studentForSaving);
        when(studentMapper.toDto(studentForSaving)).thenReturn(studentDto);

        StudentDto result = studentService.save(studentDto);

        assertEquals(studentForSaving.getFirstName(), result.getFirstName());
        assertEquals(studentForSaving.getLastName(), result.getLastName());
    }

    @Test(expected = UnExpectedFieldInRequestException.class)
    public void testSave_ExistingStudent_ThrowsException() {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(1L);

        studentService.save(studentDto);
    }

    @Test
    public void testUpdateStudent_ExistingStudent() {
        Long studentId = 1L;
        StudentDto studentDto = new StudentDto();

        Student existingStudent = new Student();
        existingStudent.setId(studentId);

        Student updatedStudent = new Student();
        updatedStudent.setId(studentId);

        when(studentRepository.findById(studentId)).thenReturn(Optional.of(existingStudent));
        when(studentRepository.save(existingStudent)).thenReturn(updatedStudent);
        when(studentMapper.toDto(updatedStudent)).thenReturn(studentDto);

        StudentDto result = studentService.updateStudent(studentId, studentDto);

        assertEquals(studentDto.getId(), result.getId());
    }


    @Test(expected = UnexpectedIdForUpdateRequestException.class)
    public void testUpdateStudent_NewStudent_ThrowsException() {
        Long studentId = 1L;
        StudentDto studentDto = new StudentDto();
        studentDto.setId(studentId);

        studentService.updateStudent(studentId, studentDto);
    }
}
