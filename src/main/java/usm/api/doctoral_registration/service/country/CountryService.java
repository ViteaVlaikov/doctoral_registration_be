package usm.api.doctoral_registration.service.country;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.dto.country.CountryDto;
import usm.api.doctoral_registration.mapper.country.CountryMapper;
import usm.api.doctoral_registration.model.country.Country;
import usm.api.doctoral_registration.repository.country.CountryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    private final CountryMapper countryMapper;

    public List<CountryDto> findAll() {
        return countryRepository.findAll().stream()
                .map(countryMapper::toDto)
                .toList();
    }

}
