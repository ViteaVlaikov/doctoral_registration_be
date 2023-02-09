package usm.api.doctoral_registration.service.sciences;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.DTO.student.StudentDTO;
import usm.api.doctoral_registration.DTO.student.StudyDTO;
import usm.api.doctoral_registration.model.sciences.ScienceSchool;
import usm.api.doctoral_registration.repository.sciences.ScienceSchoolRepository;
import usm.api.doctoral_registration.service.student.StudentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ScienceSchoolServiceImpl implements ScienceSchoolService {
    private final ScienceSchoolRepository scienceSchoolRepository;
    private final StudentService studentService;
    @Override
    public List<ScienceSchool> findAll() {
        return scienceSchoolRepository.findAll();
    }

    @Override
    public Map<ScienceSchool, List<Integer>> getScienceSchoolByYears() {
        List<ScienceSchool> scienceSchools = scienceSchoolRepository.findAll();
        List<StudentDTO> students = studentService.findAll();
        Map<ScienceSchool, List<Integer>> result = new HashMap<>();
        for(ScienceSchool scienceSchool : scienceSchools) {
            result.put(scienceSchool,getCountOfStudentsByYearsForScienceSchool(scienceSchool, students));
        }
        return result;
    }

    private static List<Integer> getCountOfStudentsByYearsForScienceSchool(ScienceSchool scienceSchool, List<StudentDTO> students) {
        List<Integer> studentsCount = new ArrayList<>();
        studentsCount.add(getCountOfStudentsByYear(scienceSchool, students,"I"));
        studentsCount.add(getCountOfStudentsByYear(scienceSchool, students,"II"));
        studentsCount.add(getCountOfStudentsByYear(scienceSchool, students,"III"));
        studentsCount.add(getCountOfStudentsByYear(scienceSchool, students,"IV"));
        studentsCount.add(getCountOfStudentsByYear(scienceSchool, students,"EXTRA_I"));
        studentsCount.add(getCountOfStudentsByYear(scienceSchool, students,"EXTRA_II"));
        return studentsCount;
    }

    private static Integer getCountOfStudentsByYear(ScienceSchool scienceSchool, List<StudentDTO> students, String grade) {
        return
                (int) students.stream()
                        .filter(studentDTO -> Objects.equals(studentDTO.getScienceSchool().getName(), scienceSchool.getName()))
                        .map(StudentDTO::getStudyDTO)
                        .map(StudyDTO::getYearStudy)
                        .filter(year -> Objects.equals(year, grade))
                        .count();
    }
}
