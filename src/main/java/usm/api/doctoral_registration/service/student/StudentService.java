package usm.api.doctoral_registration.service.student;

import usm.api.doctoral_registration.dto.student.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> findAll();
}
