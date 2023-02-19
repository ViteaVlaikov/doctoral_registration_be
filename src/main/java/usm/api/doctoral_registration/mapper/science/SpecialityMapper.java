package usm.api.doctoral_registration.mapper.science;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import usm.api.doctoral_registration.dto.science.SpecialityDto;
import usm.api.doctoral_registration.model.science.Speciality;

@Mapper(componentModel = "spring")
public interface SpecialityMapper {
    @Mapping(target = "scienceProfile.id", source = "scienceProfileId")
    Speciality mapToEntity(SpecialityDto specialityDto);
    @Mapping(source = "scienceProfile.id", target = "scienceProfileId")
    SpecialityDto mapToDto(Speciality speciality);
}