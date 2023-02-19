package usm.api.doctoral_registration.mapper.science;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import usm.api.doctoral_registration.dto.science.ScienceProfileDto;
import usm.api.doctoral_registration.model.science.ScienceProfile;

@Mapper(componentModel = "spring", uses = {SpecialityMapper.class})
public interface ScienceProfileMapper{
    @Mapping(source = "scienceBranchId", target = "scienceBranch.id")
    ScienceProfile mapToEntity(ScienceProfileDto scienceProfileDto);
    @Mapping(target = "scienceBranchId", source = "scienceBranch.id")
    ScienceProfileDto mapToDto(ScienceProfile scienceProfile);
}