package usm.api.doctoral_registration.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usm.api.doctoral_registration.dto.science.ScienceProfileDto;
import usm.api.doctoral_registration.model.science.ScienceProfile;
import usm.api.doctoral_registration.service.science.ScienceProfileService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/sciences/profiles")
@CrossOrigin(origins = {"http://localhost:3000"})
public class ScienceProfileController {

    private final ScienceProfileService profileService;

    @GetMapping
    public ResponseEntity<List<ScienceProfileDto>> findAll() {
        return ResponseEntity.ok(profileService.findAll());
    }

    @GetMapping("/branch/{id}")
    public ResponseEntity<List<ScienceProfileDto>> findAllByScienceBranchId(@PathVariable Integer id) {
        return ResponseEntity.ok(profileService.findAllByScienceBranchId(id));
    }
}
