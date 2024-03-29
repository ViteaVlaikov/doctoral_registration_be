package usm.api.doctoral_registration.service.supervisor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.dto.supervisor.SupervisorDto;
import usm.api.doctoral_registration.exception.CodeException;
import usm.api.doctoral_registration.exception.model.EntityNotFoundException;
import usm.api.doctoral_registration.exception.request.UnExpectedFieldInRequestException;
import usm.api.doctoral_registration.mapper.supervisor.SupervisorMapper;
import usm.api.doctoral_registration.model.science.ScienceSchool;
import usm.api.doctoral_registration.model.supervisor.Supervisor;
import usm.api.doctoral_registration.repository.science.ScienceSchoolRepository;
import usm.api.doctoral_registration.repository.supervisor.SupervisorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupervisorService {

    private final SupervisorRepository supervisorRepository;

    private final ScienceSchoolRepository scienceSchoolRepository;

    private final SupervisorMapper supervisorMapper;

    public List<SupervisorDto> findAllByScienceSchool(Integer id) {
        return supervisorRepository.findAllByScienceSchoolId(id)
                .stream().map(supervisorMapper::toDto).toList();
    }

    public SupervisorDto save(SupervisorDto supervisorDto) {
        if (supervisorDto.getId() != null) {
            throw new UnExpectedFieldInRequestException("Id: " + supervisorDto.getId());
        }

        Supervisor supervisor = supervisorMapper.toEntity(supervisorDto);
        ScienceSchool scienceSchool = scienceSchoolRepository.findById(supervisorDto.getScienceSchool().getId())
                .orElseThrow(() -> new EntityNotFoundException(
                        Supervisor.class.getName(),supervisorDto.getScienceSchool().getId(), CodeException.SCIENCE_SCHOOL_NOT_FOUND));
        supervisor.setScienceSchool(scienceSchool);
        return supervisorMapper.toDto(supervisorRepository.save(supervisor));
    }

    public List<SupervisorDto> findAll() {
        return supervisorRepository.findAll().stream()
                .map(supervisorMapper::toDto)
                .toList();
    }

    public SupervisorDto findById(Long id) {
        return supervisorMapper.toDto(supervisorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Supervisor.class.getName(),id,CodeException.SUPERVISOR_NOT_FOUND)));
    }
}
