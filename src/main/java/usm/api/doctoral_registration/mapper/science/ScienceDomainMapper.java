package usm.api.doctoral_registration.mapper.science;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import usm.api.doctoral_registration.dto.science.ScienceDomainDto;
import usm.api.doctoral_registration.mapper.EntityMapper;
import usm.api.doctoral_registration.model.science.ScienceDomain;

@Mapper(uses = {ScienceBranchMapper.class})
public interface ScienceDomainMapper extends EntityMapper<ScienceDomain, ScienceDomainDto> {

    @Override
    @Mapping(source = "scienceSchoolId", target = "scienceSchool.id")
    ScienceDomain toEntity(ScienceDomainDto scienceDomainDto);

    @Override
    @Mapping(target = "scienceSchoolId", source = "scienceSchool.id")
    ScienceDomainDto toDto(ScienceDomain scienceDomain);
}