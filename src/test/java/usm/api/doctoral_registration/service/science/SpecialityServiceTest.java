package usm.api.doctoral_registration.service.science;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import usm.api.doctoral_registration.dto.science.SpecialityDto;
import usm.api.doctoral_registration.mapper.science.SpecialityMapper;
import usm.api.doctoral_registration.model.science.ScienceProfile;
import usm.api.doctoral_registration.model.science.Speciality;
import usm.api.doctoral_registration.model.student.properties.YearStudy;
import usm.api.doctoral_registration.repository.science.ScienceProfileRepository;
import usm.api.doctoral_registration.repository.science.SpecialityRepository;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class SpecialityServiceTest {
    private SpecialityServiceImpl specialityService;

    @Mock
    private SpecialityRepository specialityRepository;

    @Mock
    private SpecialityMapper specialityMapper;

    @Mock
    private ScienceProfileRepository scienceProfileRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        specialityService = new SpecialityServiceImpl(specialityRepository, specialityMapper, scienceProfileRepository);
    }

    @Test
    void testFindAll() {
        // Arrange
        List<Speciality> specialities = new ArrayList<>();
        specialities.add(new Speciality());
        specialities.add(new Speciality());

        List<SpecialityDto> specialityDtos = new ArrayList<>();
        specialityDtos.add(new SpecialityDto());
        specialityDtos.add(new SpecialityDto());

        when(specialityRepository.findAll()).thenReturn(specialities);
        when(specialityMapper.toDto(any())).thenReturn(specialityDtos.get(0), specialityDtos.get(1));

        // Act
        List<SpecialityDto> result = specialityService.findAll();

        // Assert
        Assertions.assertEquals(2, result.size());
        verify(specialityRepository, times(1)).findAll();
        verify(specialityMapper, times(2)).toDto(any());
    }

    @Test
    void testFindAllByScienceProfileIdAndGrade() {
        // Arrange
        Integer profileId = 1;
        YearStudy grade = YearStudy.I;

        List<Speciality> specialities = new ArrayList<>();
        specialities.add(new Speciality());
        specialities.add(new Speciality());

        List<SpecialityDto> specialityDtos = new ArrayList<>();
        specialityDtos.add(new SpecialityDto());
        specialityDtos.add(new SpecialityDto());

        when(specialityRepository.findAllByScienceProfileIdAndGrade(profileId, grade)).thenReturn(specialities);
        when(specialityMapper.toDto(any())).thenReturn(specialityDtos.get(0), specialityDtos.get(1));

        // Act
        List<SpecialityDto> result = specialityService.findAllByScienceProfileIdAndGrade(profileId, grade);

        // Assert
        Assertions.assertEquals(2, result.size());
        verify(specialityRepository, times(1)).findAllByScienceProfileIdAndGrade(profileId, grade);
        verify(specialityMapper, times(2)).toDto(any());
    }

    @Test
    void testFindAllByScienceSchool() {
        // Arrange
        Integer schoolId = 1;

        List<Speciality> specialities = new ArrayList<>();
        specialities.add(new Speciality());
        specialities.add(new Speciality());

        List<SpecialityDto> specialityDtos = new ArrayList<>();
        specialityDtos.add(new SpecialityDto());
        specialityDtos.add(new SpecialityDto());

        when(specialityRepository.findAllByScienceSchool(schoolId)).thenReturn(specialities);
        when(specialityMapper.toDto(any())).thenReturn(specialityDtos.get(0), specialityDtos.get(1));

        // Act
        List<SpecialityDto> result = specialityService.findAllByScienceSchool(schoolId);

        // Assert
        Assertions.assertEquals(2, result.size());
        verify(specialityRepository, times(1)).findAllByScienceSchool(schoolId);
        verify(specialityMapper, times(2)).toDto(any());
    }

    @Test
    void testSave() {
        // Arrange
        Speciality speciality = new Speciality();
        ScienceProfile scienceProfile = new ScienceProfile();
        speciality.setScienceProfile(scienceProfile);

        // Act
        specialityService.save(speciality);

        // Assert
        verify(scienceProfileRepository, times(1)).save(scienceProfile);
        verify(specialityRepository, times(1)).save(speciality);
    }
}
