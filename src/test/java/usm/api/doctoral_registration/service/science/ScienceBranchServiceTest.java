package usm.api.doctoral_registration.service.science;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import usm.api.doctoral_registration.dto.science.ScienceBranchDto;
import usm.api.doctoral_registration.mapper.science.ScienceBranchMapper;
import usm.api.doctoral_registration.model.science.ScienceBranch;
import usm.api.doctoral_registration.model.student.properties.YearStudy;
import usm.api.doctoral_registration.repository.science.ScienceBranchRepository;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static usm.api.doctoral_registration.util.test.TestUtils.SCIENCE_BRANCH_DTO_FULL;

@SpringBootTest
@ActiveProfiles("test")
class ScienceBranchServiceTest {
    @Autowired
    private ScienceBranchServiceImpl scienceBranchService;

    @MockBean
    private ScienceBranchRepository branchRepository;

    @MockBean
    private ScienceBranchMapper branchMapper;

    ScienceBranchDto branchDto = SCIENCE_BRANCH_DTO_FULL;

    @Test
    void testFindAllByScienceDomainIdAndYear() {
        Integer domainId = 1;
        YearStudy grade = YearStudy.I;

        List<ScienceBranchDto> expectedBranches = List.of(branchDto);

        when(branchRepository.findAllByScienceDomainIdAndYear(domainId, grade))
                .thenReturn(List.of(new ScienceBranch()));
        when(branchMapper.toDto(Mockito.any())).thenReturn(branchDto);

        List<ScienceBranchDto> actualBranches = scienceBranchService.findAllByScienceDomainIdAndYear(domainId, grade);

        assertEquals(expectedBranches, actualBranches);
    }

    @Test
    void testGetAll() {
        List<ScienceBranchDto> expectedBranches = Collections.singletonList(branchDto);

        when(branchRepository.findAll())
                .thenReturn(List.of(new ScienceBranch()));
        when(branchMapper.toDto(Mockito.any())).thenReturn(branchDto);

        List<ScienceBranchDto> actualBranches = scienceBranchService.getAll();

        assertEquals(expectedBranches, actualBranches);
    }
}
