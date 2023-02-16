package usm.api.doctoral_registration.service.student;

import usm.api.doctoral_registration.dto.student.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> findAll();
}
