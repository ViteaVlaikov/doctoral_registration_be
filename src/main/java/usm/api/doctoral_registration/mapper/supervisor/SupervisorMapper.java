package usm.api.doctoral_registration.mapper.supervisor;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;
import usm.api.doctoral_registration.dto.student.StudentDto;
import usm.api.doctoral_registration.dto.supervisor.SupervisorDto;
import usm.api.doctoral_registration.mapper.EntityMapper;
import usm.api.doctoral_registration.mapper.science.ScienceSchoolMapper;
import usm.api.doctoral_registration.model.student.Student;
import usm.api.doctoral_registration.model.supervisor.Supervisor;


@Component
@Mapper(uses = {ScienceSchoolMapper.class})
public interface SupervisorMapper extends EntityMapper<Supervisor, SupervisorDto> {

    @Mapping(target = "id", ignore = true) // Игнорировать поле "id" при обновлении
    Supervisor updateStudentFromDto(SupervisorDto supervisorDto, @MappingTarget Supervisor supervisor);


    @Override
    @Mapping(source = "scienceSchool.id", target = "scienceSchoolId")
    SupervisorDto toDto(Supervisor entity);

    @Override
    @Mapping(source = "scienceSchoolId", target = "scienceSchool.id")
    Supervisor toEntity(SupervisorDto name);
}
