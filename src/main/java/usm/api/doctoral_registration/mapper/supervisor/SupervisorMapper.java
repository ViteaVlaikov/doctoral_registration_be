package usm.api.doctoral_registration.mapper.supervisor;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import usm.api.doctoral_registration.dto.supervisor.SupervisorDto;
import usm.api.doctoral_registration.mapper.EntityMapper;
import usm.api.doctoral_registration.mapper.science.ScienceSchoolMapper;
import usm.api.doctoral_registration.model.supervisor.Supervisor;


@Component
@Mapper(uses = {ScienceSchoolMapper.class})
public interface SupervisorMapper extends EntityMapper<Supervisor, SupervisorDto> {

    @Override
//    @Mapping(source = "scienceSchool", target = "scienceSchoolDto")
    SupervisorDto toDto(Supervisor entity);

    @Override
//    @Mapping(source = "scienceSchoolDto", target = "scienceSchool")
    Supervisor toEntity(SupervisorDto name);
}
