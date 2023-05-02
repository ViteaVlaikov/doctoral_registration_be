package usm.api.doctoral_registration.service.science;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.dto.science.SpecialityDto;
import usm.api.doctoral_registration.mapper.science.SpecialityMapper;
import usm.api.doctoral_registration.model.science.ScienceDomain;
import usm.api.doctoral_registration.model.science.Speciality;
import usm.api.doctoral_registration.model.student.properties.YearStudy;
import usm.api.doctoral_registration.repository.science.ScienceProfileRepository;
import usm.api.doctoral_registration.repository.science.SpecialityRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialityServiceImpl implements SpecialityService {
    private final SpecialityRepository specialityRepository;
    private final SpecialityMapper specialityMapper;

    private final ScienceProfileRepository scienceProfileRepository;

    @Override
    public List<SpecialityDto> findAll() {
        return specialityRepository.findAll().stream()
                .map(specialityMapper::toDto)
                .toList();
    }

    @Override
    public List<SpecialityDto> findAllByScienceProfileIdAndGrade(Integer profile_id, YearStudy grade) {
        return specialityRepository.findAllByScienceProfileIdAndGrade(profile_id, grade).stream()
                .map(specialityMapper::toDto)
                .toList();
    }

    @Override
    public List<SpecialityDto> findAllByScienceSchool(Integer id) {
        return specialityRepository.findAllByScienceSchool(id).stream()
                .peek(speciality -> speciality.setStudents(null))
                .map(specialityMapper::toDto).toList();
    }

    @Override
    public void save(Speciality speciality) {
        scienceProfileRepository.save(speciality.getScienceProfile());
        specialityRepository.save(speciality);
    }

    @Override
    public List<SpecialityDto> getAllByScienceProfileId(Integer id) {
        return specialityRepository
                .findAllByScienceProfileId(id).stream()
                .map(specialityMapper::toDto)
                .toList();
    }
}
