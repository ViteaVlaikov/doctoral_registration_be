package usm.api.doctoral_registration.service.science;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import usm.api.doctoral_registration.dto.science.ScienceProfileDto;
import usm.api.doctoral_registration.mapper.science.ScienceProfileMapper;
import usm.api.doctoral_registration.model.science.ScienceProfile;
import usm.api.doctoral_registration.model.student.properties.YearStudy;
import usm.api.doctoral_registration.repository.science.ScienceProfileRepository;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static usm.api.doctoral_registration.util.TestUtils.SCIENCE_PROFILE_DTO_FULL;

@SpringBootTest
public class ScienceProfileServiceTest {
    @Mock
    private ScienceProfileRepository profileRepository;

    @Mock
    private ScienceProfileMapper profileMapper;

    @InjectMocks
    private ScienceProfileServiceImpl profileService;

    ScienceProfileDto profileDto = SCIENCE_PROFILE_DTO_FULL;

    @Test
    public void testFindAllByScienceBranchIdAndYear() {
        Integer branchId = 1;
        YearStudy grade = YearStudy.I;

        List<ScienceProfileDto> expectedProfiles = Collections.singletonList(profileDto);

        when(profileRepository.findAllByScienceBranchIdAndYear(branchId, grade)).thenReturn(List.of(new ScienceProfile()));
        when(profileMapper.toDto(Mockito.any())).thenReturn(profileDto);

        List<ScienceProfileDto> actualProfiles = profileService.findAllByScienceBranchIdAndYear(branchId, grade);

        assertEquals(expectedProfiles, actualProfiles);
    }

    @Test
    public void testFindAll() {
        List<ScienceProfileDto> expectedProfiles = Collections.singletonList(profileDto);

        when(profileRepository.findAll()).thenReturn(List.of(new ScienceProfile()));
        when(profileMapper.toDto(Mockito.any())).thenReturn(profileDto);

        List<ScienceProfileDto> actualProfiles = profileService.findAll();

        assertEquals(expectedProfiles, actualProfiles);
    }
}
