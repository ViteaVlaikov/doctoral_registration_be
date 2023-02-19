package usm.api.doctoral_registration.mapper.science;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import usm.api.doctoral_registration.dto.science.ScienceDomainDto;
import usm.api.doctoral_registration.model.science.ScienceDomain;

@Mapper(componentModel = "spring", uses = {ScienceBranchMapper.class})
public interface ScienceDomainMapper {
    @Mapping(source = "scienceSchoolId", target = "scienceSchool.id")
    ScienceDomain mapToEntity(ScienceDomainDto scienceDomainDto);
    @Mapping(target = "scienceSchoolId", source = "scienceSchool.id")
    ScienceDomainDto mapToDto(ScienceDomain scienceDomain);
}