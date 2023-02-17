package usm.api.doctoral_registration.mapper.science;

import org.mapstruct.AfterMapping;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import usm.api.doctoral_registration.mapper.EntityMapper;
import usm.api.doctoral_registration.model.science.ScienceSchool;
import usm.api.doctoral_registration.dto.science.ScienceSchoolDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {ScienceDomainMapper.class})
public interface ScienceSchoolMapper extends EntityMapper<ScienceSchool, ScienceSchoolDto> {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ScienceSchool partialUpdate(ScienceSchoolDto scienceSchoolDto, @MappingTarget ScienceSchool scienceSchool);

    @Override
//    @Mapping(target = "science_school", source = "scienceDomains", defaultExpression = "java(0F)")
    ScienceSchoolDto toDto(ScienceSchool entity);

    @Override
//    @Mapping(target = "science_school", expression = "java(new ScienceSchool())")
    ScienceSchool toEntity(ScienceSchoolDto dto);

    @AfterMapping
    default void linkScienceDomains(@MappingTarget ScienceSchool scienceSchool) {
        scienceSchool.getScienceDomains().forEach(scienceDomain -> scienceDomain.setScienceSchool(scienceSchool));
    }
}