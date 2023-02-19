package usm.api.doctoral_registration.mapper;

import org.mapstruct.Mapper;
import usm.api.doctoral_registration.dto.country.CountryDto;
import usm.api.doctoral_registration.model.country.Country;

@Mapper
public interface CountryMapper extends EntityMapper<Country, CountryDto> {
//
//    @Override
//    public CountryDTO toDto(Country entity);
//
//    @Override
//    public Country toEntity(CountryDTO dto);
}
