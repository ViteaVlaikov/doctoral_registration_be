package usm.api.doctoral_registration.mapper.science;

import org.mapstruct.AfterMapping;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import usm.api.doctoral_registration.mapper.EntityMapper;
import usm.api.doctoral_registration.model.science.ScienceProfile;
import usm.api.doctoral_registration.dto.science.ScienceProfileDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {ScienceBranchMapper.class, SpecialityMapper.class})
public interface ScienceProfileMapper extends EntityMapper<ScienceProfile, ScienceProfileDto> {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ScienceProfile partialUpdate(ScienceProfileDto scienceProfileDto, @MappingTarget ScienceProfile scienceProfile);

    @Override
//    @Mapping(target = "science_profile", source = "science_profile.id", defaultExpression = "java(0F)")
    ScienceProfileDto toDto(ScienceProfile entity);

    @Override
//    @Mapping(target = "science_profile", expression = "java(new ScienceProfile())")
    ScienceProfile toEntity(ScienceProfileDto dto);

    @AfterMapping
    default void linkSpecialities(@MappingTarget ScienceProfile scienceProfile) {
        scienceProfile.getSpecialities().forEach(speciality -> speciality.setScienceProfile(scienceProfile));
    }
}