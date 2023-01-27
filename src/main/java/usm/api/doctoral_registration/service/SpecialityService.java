package usm.api.doctoral_registration.service;

import usm.api.doctoral_registration.model.sciences.Speciality;

import java.util.List;

public interface SpecialityService {
    List<Speciality> findAll();
}
