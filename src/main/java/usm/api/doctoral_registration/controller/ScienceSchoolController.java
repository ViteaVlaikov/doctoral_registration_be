package usm.api.doctoral_registration.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import usm.api.doctoral_registration.model.science.ScienceSchool;
import usm.api.doctoral_registration.service.science.ScienceSchoolService;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequiredArgsConstructor
@RequestMapping("api")
@Slf4j
public class ScienceSchoolController {

    private final ScienceSchoolService scienceSchoolService;

    @GetMapping("/sciences_by_years")
    public ResponseEntity<Map<ScienceSchool, List<Integer>>> getScienceSchoolByYears() {
        return ResponseEntity.ok(scienceSchoolService.getScienceSchoolByYears());
    }
}
