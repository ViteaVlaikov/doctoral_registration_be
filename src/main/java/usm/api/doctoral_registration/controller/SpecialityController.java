package usm.api.doctoral_registration.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usm.api.doctoral_registration.dto.science.SpecialityDto;
import usm.api.doctoral_registration.mapper.YearStudyMapper;
import usm.api.doctoral_registration.service.science.SpecialityService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequiredArgsConstructor
@RequestMapping("api")
@Slf4j
public class SpecialityController {
    private final SpecialityService specialityService;
    private final YearStudyMapper yearStudyMapper;
    @GetMapping("/specialities/{profile_id}/{year}")
    public ResponseEntity<List<SpecialityDto>> getSpecialitiesByProfileIdAndYear(@PathVariable Integer profile_id, @PathVariable Integer year) {
        return ResponseEntity.ok(specialityService.findAllByScienceProfileIdAndGrade(profile_id,yearStudyMapper.mapFromInteger(year)));
    }
}
