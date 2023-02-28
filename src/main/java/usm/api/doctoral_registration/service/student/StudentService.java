package usm.api.doctoral_registration.service.student;

import usm.api.doctoral_registration.dto.science.ScienceDomainDto;
import usm.api.doctoral_registration.dto.student.StudentDto;
import usm.api.doctoral_registration.model.student.Student;
import usm.api.doctoral_registration.model.student.properties.YearStudy;

import java.util.List;

public interface StudentService {
    List<StudentDto> findAll();

    void saveAll(List<Student> students);

    List<StudentDto> findAllBySpecialityIdAndYear(Float speciality_id, YearStudy grade);

    StudentDto findById(Long id);
}
