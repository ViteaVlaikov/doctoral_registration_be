package usm.api.doctoral_registration.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usm.api.doctoral_registration.model.sciences.ScienceSchool;
import usm.api.doctoral_registration.model.sciences.Speciality;
import usm.api.doctoral_registration.model.student.Supervisor;
import usm.api.doctoral_registration.service.sciences.ScienceSchoolService;
import usm.api.doctoral_registration.service.sciences.SpecialityService;
import usm.api.doctoral_registration.service.sciences.SupervisorService;
import usm.api.doctoral_registration.DTO.student.StudentDTO;
import usm.api.doctoral_registration.service.student.StudentService;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequiredArgsConstructor
@RequestMapping("api")
@Slf4j
public class SalamController {
    private final SpecialityService specialityService;
    private final SupervisorService supervisorService;
    private final ScienceSchoolService scienceSchoolService;

    private final StudentService studentService;

    @GetMapping("/salam")
    public String salam() {
        return "Salam " + ", Bro!!! ";
    }

    @GetMapping("/specialities")
    public ResponseEntity<List<Speciality>> getSpecialities() {
        return ResponseEntity.ok(specialityService.findAll());
    }

    @GetMapping("/supervisors")
    public ResponseEntity<List<Supervisor>> getSupervisors(){return ResponseEntity.ok(supervisorService.findAll());}

    @GetMapping("/science")
    public ResponseEntity<List<ScienceSchool>> getSciences(){return ResponseEntity.ok(scienceSchoolService.findAll());}

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getStudents(){return ResponseEntity.ok(studentService.findAll());}

    @GetMapping("/sciences_by_years")
    public ResponseEntity<Map<ScienceSchool,List<Integer>>> getScienceSchoolByYears(){
        return ResponseEntity.ok(scienceSchoolService.getScienceSchoolByYears());
    }
}
