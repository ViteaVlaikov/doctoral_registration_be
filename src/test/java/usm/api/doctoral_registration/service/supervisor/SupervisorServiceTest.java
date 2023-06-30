package usm.api.doctoral_registration.service.supervisor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import usm.api.doctoral_registration.dto.supervisor.SupervisorDto;
import usm.api.doctoral_registration.exception.request.UnExpectedFieldInRequestException;
import usm.api.doctoral_registration.mapper.science.ScienceSchoolMapper;
import usm.api.doctoral_registration.mapper.supervisor.SupervisorMapper;
import usm.api.doctoral_registration.model.supervisor.Supervisor;
import usm.api.doctoral_registration.repository.science.ScienceSchoolRepository;
import usm.api.doctoral_registration.repository.supervisor.SupervisorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static usm.api.doctoral_registration.util.test.TestUtils.*;

@SpringBootTest
class SupervisorServiceTest {

    private SupervisorService supervisorService;


    @Mock
    private SupervisorRepository supervisorRepository;

    @Mock
    private ScienceSchoolRepository scienceSchoolRepository;

    @Mock
    private SupervisorMapper supervisorMapper;


    @Mock
    private ScienceSchoolMapper scienceSchoolMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        supervisorService = new SupervisorService(supervisorRepository, scienceSchoolRepository, supervisorMapper);
    }

    @Test
    void testFindAllByScienceSchool() {
        // Arrange
        Integer schoolId = 1;

        List<Supervisor> supervisors = new ArrayList<>();
        supervisors.add(new Supervisor());
        supervisors.add(new Supervisor());

        List<SupervisorDto> supervisorDtos = new ArrayList<>();
        supervisorDtos.add(new SupervisorDto());
        supervisorDtos.add(new SupervisorDto());

        when(supervisorRepository.findAllByScienceSchoolId(schoolId)).thenReturn(supervisors);
        when(supervisorMapper.toDto(any())).thenReturn(supervisorDtos.get(0), supervisorDtos.get(1));

        // Act
        List<SupervisorDto> result = supervisorService.findAllByScienceSchool(schoolId);

        // Assert
        Assertions.assertEquals(2, result.size());
        verify(supervisorRepository, times(1)).findAllByScienceSchoolId(schoolId);
        verify(supervisorMapper, times(2)).toDto(any());
    }

    @Test
    void testSave_NewSupervisor() {
        // Arrange
        SupervisorDto supervisorDto = SUPERVISOR_DTO_1_FULL;
        supervisorDto.setId(null);

        Supervisor supervisor = SUPERVISOR_1_FULL;
        when(supervisorMapper.toEntity(supervisorDto)).thenReturn(supervisor);
        when(supervisorMapper.toDto(supervisor)).thenReturn(supervisorDto);
        when(scienceSchoolRepository.findById(supervisorDto.getScienceSchoolId())).thenReturn(Optional.of(SCIENCE_SCHOOL_FULL));
        when(supervisorRepository.save(supervisor)).thenReturn(supervisor);

        // Act
        SupervisorDto result = supervisorService.save(supervisorDto);

        // Assert
        Assertions.assertNotNull(result);
        verify(supervisorMapper, times(1)).toEntity(supervisorDto);
        verify(supervisorMapper, times(1)).toDto(supervisor);
        verify(scienceSchoolRepository, times(1)).findById(supervisorDto.getScienceSchoolId());
        verify(supervisorRepository, times(1)).save(supervisor);
        verify(supervisorMapper, times(1)).toDto(supervisor);
    }

    @Test
    void testSave_ExistingSupervisor() {
        // Arrange
        SupervisorDto supervisorDto = new SupervisorDto();
        supervisorDto.setId(1L);

        // Act & Assert
        Assertions.assertThrows(UnExpectedFieldInRequestException.class, () -> supervisorService.save(supervisorDto));
        verifyNoInteractions(supervisorRepository);
        verifyNoInteractions(scienceSchoolRepository);
        verifyNoInteractions(supervisorMapper);
    }

    @Test
    void testFindAll() {
        // Arrange
        List<Supervisor> supervisors = new ArrayList<>();
        supervisors.add(new Supervisor());
        supervisors.add(new Supervisor());

        List<SupervisorDto> supervisorDtos = new ArrayList<>();
        supervisorDtos.add(new SupervisorDto());
        supervisorDtos.add(new SupervisorDto());

        when(supervisorRepository.findAll()).thenReturn(supervisors);
        when(supervisorMapper.toDto(any())).thenReturn(supervisorDtos.get(0), supervisorDtos.get(1));

        // Act
        List<SupervisorDto> result = supervisorService.findAll();

        // Assert
        Assertions.assertEquals(2, result.size());
        verify(supervisorRepository, times(1)).findAll();
        verify(supervisorMapper, times(2)).toDto(any());
    }

    @Test
    void testFindById() {
        // Arrange
        Long supervisorId = 1L;
        Supervisor supervisor = new Supervisor();
        SupervisorDto supervisorDto = new SupervisorDto();

        when(supervisorRepository.findById(supervisorId)).thenReturn(Optional.of(supervisor));
        when(supervisorMapper.toDto(supervisor)).thenReturn(supervisorDto);

        // Act
        SupervisorDto result = supervisorService.findById(supervisorId);

        // Assert
        Assertions.assertNotNull(result);
        verify(supervisorRepository, times(1)).findById(supervisorId);
        verify(supervisorMapper, times(1)).toDto(supervisor);
    }
}