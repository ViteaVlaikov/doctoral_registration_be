package usm.api.doctoral_registration.mapper.science;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import usm.api.doctoral_registration.dto.science.ScienceBranchDto;
import usm.api.doctoral_registration.mapper.EntityMapper;
import usm.api.doctoral_registration.model.science.ScienceBranch;

@Mapper(uses = {ScienceProfileMapper.class})
public interface ScienceBranchMapper extends EntityMapper<ScienceBranch, ScienceBranchDto> {

    @Override
    @Mapping(target = "scienceDomainId", source = "scienceDomain.id")
    ScienceBranchDto toDto(ScienceBranch scienceBranch);

    @Override
    @Mapping(source = "scienceDomainId", target = "scienceDomain.id")
    ScienceBranch toEntity(ScienceBranchDto scienceBranchDto);
}