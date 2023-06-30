package usm.api.doctoral_registration.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usm.api.doctoral_registration.dto.science.ScienceProfileDto;
import usm.api.doctoral_registration.service.science.ScienceProfileService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/sciences/profiles")
@CrossOrigin(origins = {"http://localhost:3000"})
public class ScienceProfileController {

    private final ScienceProfileService profileService;

    @GetMapping
    public ResponseEntity<List<ScienceProfileDto>> getAll() {
        return ResponseEntity.ok(profileService.findAll());
    }
}
