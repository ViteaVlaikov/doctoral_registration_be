package usm.api.doctoral_registration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.model.sciences.Speciality;
import usm.api.doctoral_registration.repository.SpecialityRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialityServiceImpl implements SpecialityService {
    private final SpecialityRepository specialityRepository;
    @Override
    public List<Speciality> findAll() {
        return specialityRepository.findAll();
    }
}
