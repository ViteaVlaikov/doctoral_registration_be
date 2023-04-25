package usm.api.doctoral_registration.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usm.api.doctoral_registration.dto.science.ScienceDomainDto;
import usm.api.doctoral_registration.service.science.ScienceDomainService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/sciences/domains")
@CrossOrigin(origins = {"http://localhost:3000"})
public class ScienceDomainController {

    private final ScienceDomainService domainService;

    @GetMapping
    public ResponseEntity<List<ScienceDomainDto>> findAll() {
        return ResponseEntity.ok(domainService.findAll());
    }

    @GetMapping("/schools/{id}/{year}")
    public List<ScienceDomainDto> findAllByScienceSchoolIdAndYear(
            @PathVariable Integer id, @PathVariable Integer year) {
        return domainService.findAllByScienceSchoolIdAndYear(id, year);
    }
}
