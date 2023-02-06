package usm.api.doctoral_registration.service.sciences;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.model.sciences.ScienceSchool;
import usm.api.doctoral_registration.repository.sciences.ScienceSchoolRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScienceSchoolServiceImpl implements ScienceSchoolService {
    private final ScienceSchoolRepository scienceSchoolRepository;
    @Override
    public List<ScienceSchool> findAll() {
        return scienceSchoolRepository.findAll();
    }
}
