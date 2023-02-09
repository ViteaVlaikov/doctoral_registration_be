package usm.api.doctoral_registration.service.student;

import usm.api.doctoral_registration.DTO.student.StudentDTO;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDTO> findAll();
}
