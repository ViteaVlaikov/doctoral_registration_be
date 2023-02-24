package usm.api.doctoral_registration.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usm.api.doctoral_registration.dto.country.CountryDto;
import usm.api.doctoral_registration.service.country.CountryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/countries")
@CrossOrigin(origins = {"http://localhost:3000"})
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    public ResponseEntity<List<CountryDto>> findAll() {
        return ResponseEntity.ok(countryService.findAll());
    }
}
