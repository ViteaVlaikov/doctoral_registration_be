package usm.api.doctoral_registration.service.country;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.dto.country.CountryDto;
import usm.api.doctoral_registration.mapper.country.CountryMapper;
import usm.api.doctoral_registration.repository.country.CountryRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    private final CountryMapper countryMapper;

    public List<CountryDto> findAll() {
        return countryRepository.findAll().stream()
                .peek(country -> country.setStudent(null))
                .map(countryMapper::toDto)
                .toList();
    }
}
