package usm.api.doctoral_registration.service.science;

import usm.api.doctoral_registration.dto.science.ScienceDomainDto;

import java.util.List;

public interface ScienceDomainService {
    List<ScienceDomainDto> findAll();

    List<ScienceDomainDto> findAllByScienceSchoolId(Integer scienceSchoolId);
}