package usm.api.doctoral_registration.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usm.api.doctoral_registration.dto.supervisor.SupervisorDto;
import usm.api.doctoral_registration.service.supervisor.SupervisorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/supervisors")
@CrossOrigin(origins = {"http://localhost:3000"})
public class SupervisorController {

    private final SupervisorService supervisorService;

    @GetMapping
    public ResponseEntity<List<SupervisorDto>> findAll() {
        return ResponseEntity.ok(supervisorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupervisorDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(supervisorService.findById(id));
    }

    @GetMapping("/schools/{id}")
    public ResponseEntity<List<SupervisorDto>> findAllByScienceSchoolId(@PathVariable Long id) {
        return ResponseEntity.ok(supervisorService.findAllByScienceSchool(id));
    }

    @PostMapping
    public ResponseEntity<SupervisorDto> save(@RequestBody SupervisorDto supervisorDto){
        return ResponseEntity.ok(supervisorService.save(supervisorDto));
    }
}
