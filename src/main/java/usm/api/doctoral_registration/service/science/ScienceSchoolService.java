package usm.api.doctoral_registration.service.science;

import usm.api.doctoral_registration.model.science.ScienceSchool;
import usm.api.doctoral_registration.dto.science.ScienceSchoolDto;

import java.util.List;
import java.util.Map;

public interface ScienceSchoolService {
    List<ScienceSchoolDto> findAll();

    Map<ScienceSchoolDto, List<Long>> getScienceSchoolByYears();
}
