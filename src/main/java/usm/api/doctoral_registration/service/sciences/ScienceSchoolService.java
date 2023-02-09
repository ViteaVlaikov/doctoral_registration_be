package usm.api.doctoral_registration.service.sciences;

import org.springframework.http.ResponseEntity;
import usm.api.doctoral_registration.model.sciences.ScienceSchool;

import java.util.List;
import java.util.Map;

public interface ScienceSchoolService {
    List<ScienceSchool> findAll();

    Map<ScienceSchool, List<Integer>> getScienceSchoolByYears();
}
