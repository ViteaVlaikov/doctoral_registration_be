package usm.api.doctoral_registration.service.student;

import usm.api.doctoral_registration.crosstab.CrossTab;
import usm.api.doctoral_registration.dto.student.StudentDto;
import usm.api.doctoral_registration.model.student.properties.YearStudy;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDto> findAll();

    List<StudentDto> findAllBySpecialityIdAndYear(Float speciality_id, YearStudy grade);

    StudentDto findById(Long id);

    List<StudentDto> findByParams(Map<String, String> params);

    StudentDto save(StudentDto studentDto);

    StudentDto save1(StudentDto studentDto);

    List<CrossTab.Item> createCrossTab(Map<String, String> params);

    StudentDto updateStudent(Long id, StudentDto studentDto);
}
