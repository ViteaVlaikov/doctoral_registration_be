package usm.api.doctoral_registration.service.science;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import usm.api.doctoral_registration.dto.science.ScienceDomainDto;
import usm.api.doctoral_registration.mapper.YearStudyMapper;
import usm.api.doctoral_registration.mapper.science.ScienceDomainMapper;
import usm.api.doctoral_registration.model.science.ScienceDomain;
import usm.api.doctoral_registration.repository.science.ScienceDomainRepository;
import usm.api.doctoral_registration.service.student.StudentService;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static usm.api.doctoral_registration.util.test.TestUtils.SCIENCE_DOMAIN_DTO_FULL;

@SpringBootTest
class ScienceDomainServiceTest {
    @Mock
    private ScienceDomainRepository domainRepository;

    @Mock
    private ScienceDomainMapper domainMapper;

    @Mock
    private ScienceBranchService branchService;

    @Mock
    private ScienceProfileService profileService;

    @Mock
    private SpecialityService specialityService;

    @Mock
    private StudentService studentService;

    @Mock
    private YearStudyMapper yearStudyMapper;

    @InjectMocks
    private ScienceDomainServiceImpl domainService;

    ScienceDomainDto domainDto = SCIENCE_DOMAIN_DTO_FULL;

    @Test
    void testFindAll() {
        List<ScienceDomainDto> expectedDomains = Collections.singletonList(domainDto);

        when(domainRepository.findAll()).thenReturn(List.of(new ScienceDomain()));
        when(domainMapper.toDto(Mockito.any())).thenReturn(domainDto);

        List<ScienceDomainDto> actualDomains = domainService.findAll();

        assertEquals(expectedDomains, actualDomains);
    }

    @Test
    void testFindAllByScienceSchoolId() {
        Integer schoolId = 1;
        List<ScienceDomainDto> expectedDomains = Collections.singletonList(domainDto);

        when(domainRepository.findAllByScienceSchoolId(schoolId)).thenReturn(List.of(new ScienceDomain()));
        when(domainMapper.toDto(Mockito.any())).thenReturn(domainDto);

        List<ScienceDomainDto> actualDomains = domainService.findAllByScienceSchoolId(schoolId);

        assertEquals(expectedDomains, actualDomains);
    }
}
