package usm.api.doctoral_registration.service.science;

import usm.api.doctoral_registration.dto.science.ScienceDomainDto;
import usm.api.doctoral_registration.model.science.ScienceDomain;
import usm.api.doctoral_registration.model.science.ScienceSchool;

import java.util.List;

public interface ScienceDomainService {
    List<ScienceDomainDto> findAll();
    List<ScienceDomainDto> findAllByScienceSchoolId(Integer scienceSchoolId);

    List<ScienceDomainDto> findAllByScienceSchoolIdAndYear(Integer school_id, Integer year);
}
