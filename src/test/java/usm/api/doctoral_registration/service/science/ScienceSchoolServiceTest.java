package usm.api.doctoral_registration.service.science;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import usm.api.doctoral_registration.dto.science.ScienceSchoolDto;
import usm.api.doctoral_registration.mapper.science.ScienceSchoolMapper;
import usm.api.doctoral_registration.model.science.ScienceSchool;
import usm.api.doctoral_registration.repository.science.ScienceSchoolRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static usm.api.doctoral_registration.util.test.TestUtils.*;

@SpringBootTest
class ScienceSchoolServiceTest {

    @Mock
    private ScienceSchoolRepository schoolRepository;

    @Mock
    private ScienceSchoolMapper schoolMapper;

    @InjectMocks
    private ScienceSchoolServiceImpl schoolService;

    ScienceSchoolDto schoolDto1 = SCIENCE_SCHOOL_DTO_1_FULL;

    @Test
    void testFindAll() {
        List<ScienceSchoolDto> expectedSchools = Collections.singletonList(schoolDto1);

        when(schoolRepository.findAll()).thenReturn(List.of(new ScienceSchool()));
        when(schoolMapper.toDto(Mockito.any())).thenReturn(schoolDto1);

        List<ScienceSchoolDto> actualSchools = schoolService.findAll();

        assertEquals(expectedSchools, actualSchools);
    }

    @Test
    void testFindAllWithoutDependencies() {
        List<ScienceSchoolDto> expectedSchools = Collections.singletonList(schoolDto1);

        when(schoolRepository.findAll()).thenReturn(List.of(new ScienceSchool()));
        when(schoolMapper.toDto(Mockito.any())).thenReturn(schoolDto1);

        List<ScienceSchoolDto> actualSchools = schoolService.findAllWithoutDependencies();

        assertEquals(expectedSchools, actualSchools);
    }
}