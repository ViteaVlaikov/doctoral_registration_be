package usm.api.doctoral_registration.service.country;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import usm.api.doctoral_registration.dto.country.CountryDto;
import usm.api.doctoral_registration.mapper.country.CountryMapper;
import usm.api.doctoral_registration.model.country.Country;
import usm.api.doctoral_registration.repository.country.CountryRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static usm.api.doctoral_registration.util.TestUtils.MOLDOVA;
import static usm.api.doctoral_registration.util.TestUtils.USA;

@SpringBootTest
public class CountryServiceTest {

    @Autowired
    private CountryService countryService;

    @MockBean
    private CountryRepository countryRepository;

    @MockBean
    private CountryMapper countryMapper;

    @Test
    public void testFindAll() {

        CountryDto countryDto1 = MOLDOVA;
        CountryDto countryDto2 = USA;
        List<CountryDto> expectedCountries = Arrays.asList(countryDto1, countryDto2);

        when(countryRepository.findAll()).thenReturn(Arrays.asList(new Country(), new Country()));
        when(countryMapper.toDto(Mockito.any())).thenReturn(countryDto1, countryDto2);

        List<CountryDto> actualCountries = countryService.findAll();

        assertEquals(expectedCountries, actualCountries);
    }
}
