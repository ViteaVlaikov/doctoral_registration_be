package usm.api.doctoral_registration.controller;

import lombok.RequiredArgsConstructor;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("api/students")
@CrossOrigin(origins = {"http://localhost:3000"})
public class StudentController {

    private final StudentService studentService;

    private final YearStudyMapper yearStudyMapper;

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @GetMapping("specialities/{id}/{year}")
    public ResponseEntity<List<StudentDto>> getStudents(@PathVariable Float id, @PathVariable Integer year) {
        return ResponseEntity.ok(studentService.findAllBySpecialityIdAndYear(id, yearStudyMapper.mapFromInteger(year)));
    }

}
