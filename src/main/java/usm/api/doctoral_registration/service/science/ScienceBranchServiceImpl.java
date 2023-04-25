package usm.api.doctoral_registration.service.science;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.dto.science.ScienceBranchDto;
import usm.api.doctoral_registration.mapper.science.ScienceBranchMapper;
import usm.api.doctoral_registration.model.student.properties.YearStudy;
import usm.api.doctoral_registration.repository.science.ScienceBranchRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScienceBranchServiceImpl implements ScienceBranchService {
    private final ScienceBranchRepository branchRepository;
    private final ScienceBranchMapper branchMapper;
    @Override
    public List<ScienceBranchDto> findAllByScienceDomainIdAndYear(Integer domain_id, YearStudy grade) {
        return branchRepository.findAllByScienceDomainIdAndYear(domain_id, grade).stream()
                .map(branchMapper::toDto)
                .toList();
    }

    @Override
    public List<ScienceBranchDto> getAll() {
        return branchRepository.findAll().stream().map(branchMapper::toDto).toList();
    }
}
