package usm.api.doctoral_registration.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usm.api.doctoral_registration.dto.science.SpecialityDto;
import usm.api.doctoral_registration.dto.student.StudentDto;
import usm.api.doctoral_registration.model.science.ScienceSchool;
import usm.api.doctoral_registration.model.science.Speciality;
import usm.api.doctoral_registration.model.supervisor.Supervisor;
import usm.api.doctoral_registration.service.science.ScienceSchoolService;
import usm.api.doctoral_registration.service.science.SpecialityService;
import usm.api.doctoral_registration.service.science.SupervisorService;
import usm.api.doctoral_registration.service.student.StudentService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequiredArgsConstructor
@RequestMapping("api")
@Slf4j
public class SalamController {

    private final SupervisorService supervisorService;
    private final ScienceSchoolService scienceSchoolService;

    private final StudentService studentService;

    @GetMapping("/salam")
    public String salam() {
        return "Salam " + ", Bro!!! ";
    }


    @GetMapping("/supervisors")
    public ResponseEntity<List<Supervisor>> getSupervisors(){return ResponseEntity.ok(supervisorService.findAll());}




}
