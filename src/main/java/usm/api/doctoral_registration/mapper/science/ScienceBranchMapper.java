package usm.api.doctoral_registration.mapper.science;

import org.mapstruct.AfterMapping;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import usm.api.doctoral_registration.mapper.EntityMapper;
import usm.api.doctoral_registration.model.science.ScienceBranch;
import usm.api.doctoral_registration.dto.science.ScienceBranchDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {ScienceDomainMapper.class, ScienceProfileMapper.class})
public interface ScienceBranchMapper extends EntityMapper<ScienceBranch, ScienceBranchDto> {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ScienceBranch partialUpdate(ScienceBranchDto scienceBranchDto, @MappingTarget ScienceBranch scienceBranch);

    @Override
//    @Mapping(target = "science_branch", source = "science_branch.id", defaultExpression = "java(0F)")
    ScienceBranchDto toDto(ScienceBranch entity);

    @Override
//    @Mapping(target = "science_branch", expression = "java(new ScienceBranch())")
    ScienceBranch toEntity(ScienceBranchDto dto);

    @AfterMapping
    default void linkScienceProfiles(@MappingTarget ScienceBranch scienceBranch) {
        scienceBranch.getScienceProfiles().forEach(scienceProfile -> scienceProfile.setScienceBranch(scienceBranch));
    }
}