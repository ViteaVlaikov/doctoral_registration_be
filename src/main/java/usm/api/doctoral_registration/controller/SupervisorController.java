package usm.api.doctoral_registration.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usm.api.doctoral_registration.dto.supervisor.SupervisorDto;
import usm.api.doctoral_registration.service.supervisor.SupervisorService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequiredArgsConstructor
@RequestMapping("api/supervisors")
@Slf4j
public class SupervisorController {

    private final SupervisorService supervisorService;

    @GetMapping("/school/{id}")
    public ResponseEntity<List<SupervisorDto>> findAllByScienceSchoolId(@PathVariable Long id) {
        return ResponseEntity.ok(supervisorService.findAllByScienceSchool(id));
    }
}
