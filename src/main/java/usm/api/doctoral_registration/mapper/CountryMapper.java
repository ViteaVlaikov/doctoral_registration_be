package usm.api.doctoral_registration.mapper;

import org.mapstruct.Mapper;
import usm.api.doctoral_registration.dto.country.CountryDTO;
import usm.api.doctoral_registration.model.country.Country;

@Mapper
public interface CountryMapper extends EntityMapper<Country, CountryDTO> {
//
//    @Override
//    public CountryDTO toDto(Country entity);
//
//    @Override
//    public Country toEntity(CountryDTO dto);
}
