package usm.api.doctoral_registration.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usm.api.doctoral_registration.dto.student.StudentDto;
import usm.api.doctoral_registration.mapper.YearStudyMapper;
import usm.api.doctoral_registration.service.student.StudentService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequiredArgsConstructor
@RequestMapping("api")
@Slf4j
public class StudentController {
    private final StudentService studentService;
    private final YearStudyMapper yearStudyMapper;

    @GetMapping("/students/{speciality_id}/{year}")
    public ResponseEntity<List<StudentDto>> getStudents(@PathVariable Float speciality_id, @PathVariable Integer year) {
        return ResponseEntity.ok(studentService.findAllBySpecialityIdAndYear(speciality_id,yearStudyMapper.mapFromInteger(year)));
    }

}
