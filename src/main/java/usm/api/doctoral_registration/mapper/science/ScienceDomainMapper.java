package usm.api.doctoral_registration.mapper.science;

import org.mapstruct.AfterMapping;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import usm.api.doctoral_registration.mapper.EntityMapper;
import usm.api.doctoral_registration.model.science.ScienceDomain;
import usm.api.doctoral_registration.dto.science.ScienceDomainDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {ScienceSchoolMapper.class, ScienceBranchMapper.class})
public interface ScienceDomainMapper extends EntityMapper<ScienceDomain, ScienceDomainDto> {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ScienceDomain partialUpdate(ScienceDomainDto scienceDomainDto, @MappingTarget ScienceDomain scienceDomain);

    @Override
//    @Mapping(target = "science_domain", source = "science.id", defaultExpression = "java(0F)")
    ScienceDomainDto toDto(ScienceDomain entity);

    @Override
//    @Mapping(target = "science_domain", expression = "java(new ScienceDomain())")
    ScienceDomain toEntity(ScienceDomainDto dto);

    @AfterMapping
    default void linkScienceBranches(@MappingTarget ScienceDomain scienceDomain) {
        scienceDomain.getScienceBranches().forEach(scienceBranch -> scienceBranch.setScienceDomain(scienceDomain));
    }
}