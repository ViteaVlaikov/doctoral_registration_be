package usm.api.doctoral_registration.service.supervisor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.dto.supervisor.SupervisorDto;
import usm.api.doctoral_registration.exception.entity.SupervisorNotFoundException;
import usm.api.doctoral_registration.mapper.supervisor.SupervisorMapper;
import usm.api.doctoral_registration.model.supervisor.Supervisor;
import usm.api.doctoral_registration.repository.supervisor.SupervisorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupervisorServiceImpl implements SupervisorService {

    private final SupervisorRepository supervisorRepository;

    private final SupervisorMapper supervisorMapper;

    @Override
    public List<SupervisorDto> findAllByScienceSchool(Long id) {
        return supervisorRepository.findAllByScienceSchoolId(id)
                .stream().map(supervisorMapper::toDto).toList();
    }

    @Override
    public SupervisorDto save(SupervisorDto supervisorDto) {
        Supervisor supervisor = supervisorMapper.toEntity(supervisorDto);
        return supervisorMapper.toDto(supervisorRepository.save(supervisor));
    }

    @Override
    public List<SupervisorDto> findAll() {
        return supervisorRepository.findAll().stream()
                .map(supervisorMapper::toDto).toList();
    }

    @Override
    public SupervisorDto findById(Long id) {
        return supervisorMapper.toDto(
                supervisorRepository.findById(id).orElseThrow(
                        () -> new SupervisorNotFoundException(id)
                )
        );
    }
}
