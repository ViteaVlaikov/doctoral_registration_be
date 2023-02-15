package usm.api.doctoral_registration.service.science;

import usm.api.doctoral_registration.model.supervisor.Supervisor;

import java.util.List;

public interface SupervisorService {
    List<Supervisor> findAll();
}
