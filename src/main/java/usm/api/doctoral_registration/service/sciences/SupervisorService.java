package usm.api.doctoral_registration.service.sciences;

import usm.api.doctoral_registration.model.student.Supervisor;

import java.util.List;

public interface SupervisorService {
    List<Supervisor> findAll();
}
