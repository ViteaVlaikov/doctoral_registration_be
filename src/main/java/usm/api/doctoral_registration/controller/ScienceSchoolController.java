package usm.api.doctoral_registration.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usm.api.doctoral_registration.dto.science.ScienceSchoolDto;
import usm.api.doctoral_registration.service.science.ScienceSchoolService;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/sciences/schools")
@CrossOrigin(origins = {"http://localhost:3000"})
public class ScienceSchoolController {

    private final ScienceSchoolService scienceSchoolService;

    @GetMapping
    public ResponseEntity<List<ScienceSchoolDto>> getScienceSchools() {
        return ResponseEntity.ok(scienceSchoolService.findAllWithoutDependencies());
    }

    @GetMapping("/domains")
    public ResponseEntity<List<ScienceSchoolDto>> getSciencesSchoolsAndDomains() {
        return ResponseEntity.ok(scienceSchoolService.findAll());
    }

    @GetMapping("/years")
    public ResponseEntity<Map<ScienceSchoolDto, List<Long>>> getScienceSchoolByYears() {
        return ResponseEntity.ok(scienceSchoolService.getScienceSchoolByYears());
    }
}
