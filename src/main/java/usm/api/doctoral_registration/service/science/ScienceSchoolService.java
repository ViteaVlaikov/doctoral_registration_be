package usm.api.doctoral_registration.service.science;

import usm.api.doctoral_registration.model.science.ScienceSchool;

import java.util.List;
import java.util.Map;

public interface ScienceSchoolService {
    List<ScienceSchool> findAll();

    Map<ScienceSchool, List<Integer>> getScienceSchoolByYears();
}
