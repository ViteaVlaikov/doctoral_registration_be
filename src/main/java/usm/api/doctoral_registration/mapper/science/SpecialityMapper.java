package usm.api.doctoral_registration.mapper.science;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import usm.api.doctoral_registration.dto.science.SpecialityDto;
import usm.api.doctoral_registration.mapper.EntityMapper;
import usm.api.doctoral_registration.mapper.student.StudentMapper;
import usm.api.doctoral_registration.model.science.Speciality;

@Mapper
public interface SpecialityMapper extends EntityMapper<Speciality, SpecialityDto> {

    @Override
    @Mapping(target = "scienceProfile.id", source = "scienceProfileId")
    Speciality toEntity(SpecialityDto specialityDto);

    @Override
    @Mapping(source = "scienceProfile.id", target = "scienceProfileId")
    SpecialityDto toDto(Speciality speciality);
}