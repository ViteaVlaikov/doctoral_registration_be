package usm.api.doctoral_registration.service.science;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.dto.science.ScienceProfileDto;
import usm.api.doctoral_registration.mapper.science.ScienceProfileMapper;
import usm.api.doctoral_registration.model.student.properties.YearStudy;
import usm.api.doctoral_registration.repository.science.ScienceProfileRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScienceProfileServiceImpl implements ScienceProfileService {

    private final ScienceProfileRepository scienceProfileRepository;

    private final ScienceProfileMapper scienceProfileMapper;

    @Override
    public List<ScienceProfileDto> findAllByScienceBranchIdAndYear(Integer branchId, YearStudy grade) {
        return scienceProfileRepository.findAllByScienceBranchIdAndYear(branchId, grade).stream()
                .map(scienceProfileMapper::toDto)
                .toList();
    }

    @Override
    public List<ScienceProfileDto> findAll() {
        return scienceProfileRepository.findAll().stream().map(scienceProfileMapper::toDto).toList();
    }
}
