package usm.api.doctoral_registration.mapper.science;

import org.mapstruct.Mapper;
import usm.api.doctoral_registration.dto.science.ScienceSchoolDto;
import usm.api.doctoral_registration.mapper.EntityMapper;
import usm.api.doctoral_registration.model.science.ScienceSchool;

@Mapper(uses = {ScienceDomainMapper.class})
public interface ScienceSchoolMapper extends EntityMapper<ScienceSchool, ScienceSchoolDto> {
}