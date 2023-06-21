package usm.api.doctoral_registration.service.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import usm.api.doctoral_registration.dto.student.StudentDto;
import usm.api.doctoral_registration.exception.model.EntityNotFoundException;
import usm.api.doctoral_registration.exception.request.UnExpectedFieldInRequestException;
import usm.api.doctoral_registration.mapper.student.StudentMapper;
import usm.api.doctoral_registration.model.science.Speciality;
import usm.api.doctoral_registration.model.student.Student;
import usm.api.doctoral_registration.model.student.properties.YearStudy;
import usm.api.doctoral_registration.repository.science.SpecialityRepository;
import usm.api.doctoral_registration.repository.student.StudentRepository;
import usm.api.doctoral_registration.repository.supervisor.SupervisorRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static usm.api.doctoral_registration.util.test.TestUtils.*;

@SpringBootTest
class StudentServiceTest {


    private StudentService studentService;

    @Mock
    private SupervisorRepository supervisorRepository;

    @Mock
    private SpecialityRepository specialityRepository;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private StudentMapper studentMapper;

    @Mock
    private Specification<Student> specification;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        studentService = new StudentServiceImpl(supervisorRepository, specialityRepository, studentRepository, studentMapper);
    }

    @Test
    void testFindAll() {
        // Arrange
        List<Student> students = new ArrayList<>();
        students.add(new Student());
        students.add(new Student());

        List<StudentDto> studentDtos = new ArrayList<>();
        studentDtos.add(new StudentDto());
        studentDtos.add(new StudentDto());

        when(studentRepository.findAll()).thenReturn(students);
        when(studentMapper.toDto(any())).thenReturn(studentDtos.get(0), studentDtos.get(1));

        // Act
        List<StudentDto> result = studentService.findAll();

        // Assert
        assertEquals(2, result.size());
        verify(studentRepository, times(1)).findAll();
        verify(studentMapper, times(2)).toDto(any());
    }

    @Test
    void testFindAllBySpecialityIdAndYear() {
        // Arrange
        Float specialityId = 1f;
        YearStudy grade = YearStudy.I;

        List<Student> students = new ArrayList<>();
        students.add(new Student());
        students.add(new Student());

        List<StudentDto> studentDtos = new ArrayList<>();
        studentDtos.add(new StudentDto());
        studentDtos.add(new StudentDto());

        when(studentRepository.findAllBySpecialityIdAndGrade(specialityId, grade)).thenReturn(students);
        when(studentMapper.toDto(any())).thenReturn(studentDtos.get(0), studentDtos.get(1));

        // Act
        List<StudentDto> result = studentService.findAllBySpecialityIdAndYear(specialityId, grade);

        // Assert
        assertEquals(2, result.size());
        verify(studentRepository, times(1)).findAllBySpecialityIdAndGrade(specialityId, grade);
        verify(studentMapper, times(2)).toDto(any());
    }

    @Test
    void testFindById_ExistingId() {
        // Arrange
        Long studentId = 1L;
        Student student = new Student();
        StudentDto studentDto = new StudentDto();

        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));
        when(studentMapper.toDto(student)).thenReturn(studentDto);

        // Act
        StudentDto result = studentService.findById(studentId);

        // Assert
        Assertions.assertNotNull(result);
        verify(studentRepository, times(1)).findById(studentId);
        verify(studentMapper, times(1)).toDto(student);
    }

    @Test
    void testFindById_NonExistingId() {
        // Arrange
        Long studentId = 1L;

        when(studentRepository.findById(studentId)).thenReturn(Optional.empty());

        // Act & Assert
        Assertions.assertThrows(EntityNotFoundException.class, () -> studentService.findById(studentId));
        verify(studentRepository, times(1)).findById(studentId);
        verifyNoInteractions(studentMapper);
    }

    @Test
    void testFindByParams_NullParams() {
        // Arrange
        Map<String, String> params = null;
        List<Student> students = new ArrayList<>();
        students.add(new Student());
        students.add(new Student());

        List<StudentDto> studentDtos = new ArrayList<>();
        studentDtos.add(new StudentDto());
        studentDtos.add(new StudentDto());

        when(studentRepository.findAll()).thenReturn(students);
        when(studentMapper.toDto(any())).thenReturn(studentDtos.get(0), studentDtos.get(1));

        // Act
        List<StudentDto> result = studentService.findByParams(params);

        // Assert
        assertEquals(2, result.size());
        verify(studentRepository, times(1)).findAll();
        verify(studentMapper, times(2)).toDto(any());
    }

    @Test
    void testFindByParams_NonNullParams() {
        // Arrange
        Map<String, String> params = new HashMap<>();
        params.put("gender", "M");
        params.put("school_id", "1");

        List<Student> students = new ArrayList<>();
        students.add(new Student());
        students.add(new Student());

        List<StudentDto> studentDtos = new ArrayList<>();
        studentDtos.add(new StudentDto());
        studentDtos.add(new StudentDto());

        when(studentRepository.findAll((Specification<Student>) any())).thenReturn(students);
        when(studentMapper.toDto(students.get(0))).thenReturn(studentDtos.get(0));
        when(studentMapper.toDto(students.get(1))).thenReturn(studentDtos.get(1));

        // Act
        List<StudentDto> result = studentService.findByParams(params);

        // Assert
        assertEquals(2, result.size());
        assertEquals(studentDtos.get(0), result.get(0));
        assertEquals(studentDtos.get(1), result.get(1));
    }

    @Test
    void testSave_ExistingId() {
        // Arrange
        StudentDto studentDto = new StudentDto();
        studentDto.setId(1L);

        // Act & Assert
        Assertions.assertThrows(UnExpectedFieldInRequestException.class, () -> studentService.save(studentDto));
        verifyNoInteractions(specialityRepository);
        verifyNoInteractions(supervisorRepository);
        verifyNoInteractions(studentMapper);
        verifyNoInteractions(studentRepository);
    }

    @Test
    void testSave_NonExistingSupervisor() {
        // Arrange
        StudentDto studentDto = STUDENT_DTO_1_FULL;
        studentDto.setId(null);

        when(specialityRepository.findById(studentDto.getSpeciality().getId())).thenReturn(Optional.of(new Speciality()));
        when(supervisorRepository.findById(studentDto.getSupervisor().getId())).thenReturn(Optional.empty());

        // Act & Assert
        Assertions.assertThrows(EntityNotFoundException.class, () -> studentService.save(studentDto));
        verify(specialityRepository, times(1)).findById(studentDto.getSpeciality().getId());
        verify(supervisorRepository, times(1)).findById(studentDto.getSupervisor().getId());
        verifyNoInteractions(studentMapper);
        verifyNoInteractions(studentRepository);
    }

    @Test
    void testSave_NonExistingSpeciality() {
        // Arrange
        StudentDto studentDto = STUDENT_DTO_1_FULL;
        studentDto.setId(null);

        when(specialityRepository.findById(studentDto.getSpeciality().getId())).thenReturn(Optional.empty());

        // Act & Assert
        Assertions.assertThrows(EntityNotFoundException.class, () -> studentService.save(studentDto));
        verify(specialityRepository, times(1)).findById(studentDto.getSpeciality().getId());
        verifyNoInteractions(supervisorRepository);
        verifyNoInteractions(studentMapper);
        verifyNoInteractions(studentRepository);
    }

    @Test
    void testSave_ValidInput() {
        // Arrange
        StudentDto studentDto = STUDENT_DTO_1_FULL;
        studentDto.setId(null);
        when(specialityRepository.findById(studentDto.getSpeciality().getId())).thenReturn(Optional.of(SPECIALITY_FOR_REPORT));
        when(supervisorRepository.findById(studentDto.getSupervisor().getId())).thenReturn(Optional.of(SUPERVISOR_1_FULL));
        when(supervisorRepository.findById(SUPERVISOR_DTO_2_FULL.getId())).thenReturn(Optional.of(SUPERVISOR_2_FULL));
        when(studentMapper.toEntity(studentDto)).thenReturn(new Student());
        when(studentRepository.save(any())).thenReturn(new Student());
        when(studentMapper.toDto(any())).thenReturn(new StudentDto());

        // Act
        StudentDto result = studentService.save(studentDto);

        // Assert
        Assertions.assertNotNull(result);
        verify(specialityRepository, times(1)).findById(studentDto.getSpeciality().getId());
        verify(supervisorRepository, times(1)).findById(studentDto.getSupervisor().getId());
        verify(supervisorRepository, times(1)).findById(SUPERVISOR_DTO_2_FULL.getId());
        verify(studentMapper, times(1)).toEntity(studentDto);
        verify(studentRepository, times(1)).save(any());
        verify(studentMapper, times(1)).toDto(any());
    }

    @Test
    void testUpdateStudent_InvalidId() {
        // Arrange
        Long id = 1L;
        StudentDto studentDto = new StudentDto();

        when(studentRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        Assertions.assertThrows(EntityNotFoundException.class, () -> studentService.updateStudent(id, studentDto));
        verify(studentRepository, times(1)).findById(id);
        verifyNoInteractions(studentMapper);
    }

    @Test
    void testUpdateStudent_ValidInput() {
        // Arrange
        Long id = 1L;
        StudentDto studentDto = new StudentDto();
        Student student = new Student();

        when(studentRepository.findById(id)).thenReturn(Optional.of(student));
        when(studentRepository.save(student)).thenReturn(student);
        when(studentMapper.toDto(student)).thenReturn(new StudentDto());

        // Act
        StudentDto result = studentService.updateStudent(id, studentDto);

        // Assert
        Assertions.assertNotNull(result);
        verify(studentRepository, times(1)).findById(id);
        verify(studentRepository, times(1)).save(student);
        verify(studentMapper, times(1)).toDto(student);
    }
}