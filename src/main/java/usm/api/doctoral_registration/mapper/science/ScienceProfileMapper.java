package usm.api.doctoral_registration.mapper.science;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import usm.api.doctoral_registration.dto.science.ScienceProfileDto;
import usm.api.doctoral_registration.mapper.EntityMapper;
import usm.api.doctoral_registration.model.science.ScienceProfile;

@Mapper(uses = {SpecialityMapper.class, ScienceBranchMapper.class})
public interface ScienceProfileMapper extends EntityMapper<ScienceProfile, ScienceProfileDto> {

    @Override
    @Mapping(source = "scienceBranchId", target = "scienceBranch.id")
    ScienceProfile toEntity(ScienceProfileDto scienceProfileDto);

    @Override
    @Mapping(target = "scienceBranchId", source = "scienceBranch.id")
    ScienceProfileDto toDto(ScienceProfile scienceProfile);
}