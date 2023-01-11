package usm.api.doctoral_registration.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usm.api.doctoral_registration.model.sciences.Speciality;
import usm.api.doctoral_registration.model.student.Supervisor;
import usm.api.doctoral_registration.service.sciences.SpecialityService;
import usm.api.doctoral_registration.service.sciences.SupervisorService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequiredArgsConstructor
@RequestMapping("api")
@Slf4j
public class SalamController {
    private final SpecialityService specialityService;
    private final SupervisorService supervisorService;

    @GetMapping("/salam")
    public String salam() {
        return "Salam " + ", Bro!!! ";
    }

    @GetMapping("/specialities")
    public ResponseEntity<List<Speciality>> getSpecialities() {
        return ResponseEntity.ok(specialityService.findAll());
    }

    @GetMapping("/supervisors")
    private ResponseEntity<List<Supervisor>> getSupervisors(){return ResponseEntity.ok(supervisorService.findAll());}
}
