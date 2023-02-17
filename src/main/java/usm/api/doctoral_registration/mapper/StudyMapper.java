package usm.api.doctoral_registration.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import usm.api.doctoral_registration.dto.student.StudyDTO;
import usm.api.doctoral_registration.model.student.Study;

@Mapper
@Component
public interface StudyMapper extends EntityMapper<Study, StudyDTO> {

    @Override
    @Mapping(target = "speciality", source = "speciality.id", defaultExpression = "java(0F)")
    StudyDTO toDto(Study entity);

    @Override
    @Mapping(target = "speciality", expression = "java(new Speciality())")
    Study toEntity(StudyDTO dto);
}
