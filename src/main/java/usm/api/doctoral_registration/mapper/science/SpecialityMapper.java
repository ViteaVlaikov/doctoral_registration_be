package usm.api.doctoral_registration.mapper.science;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import usm.api.doctoral_registration.mapper.EntityMapper;
import usm.api.doctoral_registration.model.science.Speciality;
import usm.api.doctoral_registration.dto.science.SpecialityDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {ScienceProfileMapper.class})
public interface SpecialityMapper extends EntityMapper<Speciality, SpecialityDto> {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Speciality partialUpdate(SpecialityDto specialityDto, @MappingTarget Speciality speciality);

    @Override
//    @Mapping(target = "speciality", source = "id", defaultExpression = "java(0F)")
    SpecialityDto toDto(Speciality entity);

    @Override
//    @Mapping(target = "speciality", expression = "java(new Speciality())")
    Speciality toEntity(SpecialityDto dto);
}