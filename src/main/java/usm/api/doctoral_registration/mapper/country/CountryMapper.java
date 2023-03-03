package usm.api.doctoral_registration.mapper.country;

import org.mapstruct.Mapper;
import usm.api.doctoral_registration.dto.country.CountryDto;
import usm.api.doctoral_registration.mapper.EntityMapper;
import usm.api.doctoral_registration.model.country.Country;

@Mapper
public interface CountryMapper extends EntityMapper<Country, CountryDto> {

}
