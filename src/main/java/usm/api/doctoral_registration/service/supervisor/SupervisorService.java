package usm.api.doctoral_registration.service.supervisor;

import usm.api.doctoral_registration.dto.supervisor.SupervisorDto;

import java.util.List;

public interface SupervisorService {
    List<SupervisorDto> findAllByScienceSchool(Long id);

    SupervisorDto save(SupervisorDto supervisorDto);

    List<SupervisorDto> findAll();

    SupervisorDto findById(Long id);
}
