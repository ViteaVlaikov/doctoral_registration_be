package usm.api.doctoral_registration.service.science;

import usm.api.doctoral_registration.dto.science.SpecialityDto;
import usm.api.doctoral_registration.model.science.ScienceDomain;
import usm.api.doctoral_registration.model.science.Speciality;
import usm.api.doctoral_registration.model.student.properties.YearStudy;

import java.util.List;

public interface SpecialityService {
    List<SpecialityDto> findAll();
    List<SpecialityDto> findAllByScienceProfileIdAndGrade(Integer profile_id, YearStudy grade);

    List<SpecialityDto> findAllByScienceSchool(Integer id);

    void save(Speciality speciality);
}
