package usm.api.doctoral_registration.service.supervisor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.dto.supervisor.SupervisorDto;
import usm.api.doctoral_registration.mapper.supervisor.SupervisorMapper;
import usm.api.doctoral_registration.repository.supervisor.SupervisorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupervisorService {

    private final SupervisorRepository supervisorRepository;

    private final SupervisorMapper supervisorMapper;

    public List<SupervisorDto> findAllByScienceSchool(Long id) {
        return supervisorRepository.findAllByScienceSchoolId(id)
                .stream().map(supervisorMapper::toDto).toList();
    }
}
