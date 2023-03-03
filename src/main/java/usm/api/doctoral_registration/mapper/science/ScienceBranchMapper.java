package usm.api.doctoral_registration.mapper.science;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
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