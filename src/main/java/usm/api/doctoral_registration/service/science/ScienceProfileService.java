package usm.api.doctoral_registration.service.science;

import usm.api.doctoral_registration.dto.science.ScienceDomainDto;
import usm.api.doctoral_registration.dto.science.ScienceProfileDto;
import usm.api.doctoral_registration.model.student.properties.YearStudy;

import java.util.List;

public interface ScienceProfileService {

    List<ScienceProfileDto> findAllByScienceBranchIdAndYear(Integer branch_id, YearStudy year);

    List<ScienceProfileDto> findAll();

    List<ScienceProfileDto> findAllByScienceBranchId(Integer id);
}
