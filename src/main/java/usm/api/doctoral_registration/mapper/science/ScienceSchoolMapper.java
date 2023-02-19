package usm.api.doctoral_registration.mapper.science;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import usm.api.doctoral_registration.dto.science.ScienceSchoolDto;
import usm.api.doctoral_registration.mapper.EntityMapper;
import usm.api.doctoral_registration.model.science.ScienceSchool;

@Mapper(componentModel = "spring",uses = {ScienceDomainMapper.class})
public interface ScienceSchoolMapper {
    ScienceSchool mapToEntity(ScienceSchoolDto scienceSchoolDto);
    ScienceSchoolDto mapToDto(ScienceSchool scienceSchool);
}