package usm.api.doctoral_registration.service.science;

import jakarta.persistence.criteria.CriteriaBuilder;
import usm.api.doctoral_registration.dto.science.ScienceBranchDto;
import usm.api.doctoral_registration.model.student.properties.YearStudy;

import java.util.List;

public interface ScienceBranchService {
    List<ScienceBranchDto> findAllByScienceDomainIdAndYear(Integer domain_id, YearStudy grade);

    List<ScienceBranchDto> getAll();

    List<ScienceBranchDto> findAllByScienceDomainId(Integer id);
}
