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

@Mapper(componentModel = "spring", uses = {ScienceProfileMapper.class})
public interface ScienceBranchMapper {
    @Mapping(source = "scienceDomainId", target = "scienceDomain.id")
    ScienceBranch mapToEntity(ScienceBranchDto scienceBranchDto);
    @Mapping(target = "scienceDomainId", source = "scienceDomain.id")
    ScienceBranchDto mapToDto(ScienceBranch scienceBranch);
}