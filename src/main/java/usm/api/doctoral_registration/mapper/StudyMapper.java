package usm.api.doctoral_registration.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import usm.api.doctoral_registration.dto.student.StudyDto;
import usm.api.doctoral_registration.mapper.science.SpecialityMapper;
import usm.api.doctoral_registration.model.student.Study;

@Component
@Mapper(uses = {SpecialityMapper.class})
public interface StudyMapper extends EntityMapper<Study, StudyDto> {

    @Override
//    @Mapping(target = "speciality", source = "speciality.id", defaultExpression = "java(0F)")
    StudyDto toDto(Study entity);

    @Override
//    @Mapping(target = "speciality", expression = "java(new Speciality())")
    Study toEntity(StudyDto dto);
}
