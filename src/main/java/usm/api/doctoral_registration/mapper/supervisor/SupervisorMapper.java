package usm.api.doctoral_registration.mapper.supervisor;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import usm.api.doctoral_registration.dto.supervisor.SupervisorDto;
import usm.api.doctoral_registration.mapper.EntityMapper;
import usm.api.doctoral_registration.model.supervisor.Supervisor;

@Mapper
@Component
public interface SupervisorMapper extends EntityMapper<Supervisor, SupervisorDto> {

    @Override
    @Mapping(target = "scienceSchoolId", source = "scienceSchool.id")
    SupervisorDto toDto(Supervisor supervisor);

    @Override
    @Mapping(source = "scienceSchoolId", target = "scienceSchool.id")
    Supervisor toEntity(SupervisorDto supervisorDto);
}
