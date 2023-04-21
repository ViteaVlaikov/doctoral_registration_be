package usm.api.doctoral_registration.service.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.dto.student.StudentDto;
import usm.api.doctoral_registration.excel.StudentExcelReader;
import usm.api.doctoral_registration.mapper.YearStudyMapper;
import usm.api.doctoral_registration.mapper.student.StudentMapper;
import usm.api.doctoral_registration.model.student.Student;
import usm.api.doctoral_registration.model.student.properties.YearStudy;
import usm.api.doctoral_registration.repository.science.ScienceBranchRepository;
import usm.api.doctoral_registration.repository.science.SpecialityRepository;
import usm.api.doctoral_registration.repository.student.StudentRepository;
import usm.api.doctoral_registration.repository.supervisor.SupervisorRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.springframework.data.jpa.domain.Specification.where;
import static usm.api.doctoral_registration.repository.student.StudentRepository.bySchoolsId;
import static usm.api.doctoral_registration.repository.student.StudentRepository.bySpecialitiesId;
import static usm.api.doctoral_registration.repository.student.StudentRepository.specialityId;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentExcelReader studentExcelTools;
    private final SupervisorRepository supervisorRepository;
    private final SpecialityRepository specialityRepository;
    private final static String PATH = "./src/test/java/usm/api/doctoral_registration/excel/";
    private final ScienceBranchRepository scienceBranchRepository;
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    private final YearStudyMapper yearStudyMapper;

    @Override
    public List<StudentDto> findAll() {
//        return studentExcelTools.read(PATH + "students.xlsx", 2);
        return studentRepository.findAll().stream().map(studentMapper::toDto).toList();
    }

    @Override
    public void saveAll(List<Student> students) {
        for (Student student : students) {
//            supervisorRepository.save(student.getSupervisor());
//            specialityRepository.save(student.getSpeciality());
            studentRepository.save(student);
        }
    }

    @Override
    public List<StudentDto> findAllBySpecialityIdAndYear(Float speciality_id, YearStudy grade) {
        return studentRepository.findAllBySpecialityIdAndGrade(speciality_id, grade).stream()
                .map(studentMapper::toDto)
                .toList();
    }

    @Override
    public StudentDto findById(Long id) {
        return studentMapper.toDto(
                studentRepository.findById(id).orElseThrow());
    }

    @Override
    public List<StudentDto> findByParams(Map<String, String> params) {
        System.out.println(params);

        List<Student> studentsFilter = new ArrayList<>();
//        if(params.containsKey("year")) {
//            filterByYear(params.get("year"), studentsFilter);
//        }
////        if(params.containsKey("speciality")) {
////            filterBySpecialityId(params.get("speciality"), studentsFilter);
////        }
//        if(params.containsKey("profile")) {
//
//        }
        params.forEach(System.out::printf);
        if (params.containsKey("speciality")) {

            List<Integer> schools = Arrays.stream(params.get("school")
                    .split(",")).map(Integer::parseInt).toList();

            List<Float> specialities = Arrays.stream(params.get("speciality")
                    .split(",")).map(Float::parseFloat).toList();
            studentsFilter.addAll(studentRepository
                    .findAll(where(bySpecialitiesId(specialities)).and(bySchoolsId(schools))));

//            filterBySchoolId(params.get("school"), studentsFilter);
        }

        return studentsFilter.stream().map(studentMapper::toDto).toList();
    }

    private void filterBySchoolId(String value, List<Student> studentsFilter) {
        List<Integer> schools = Arrays.stream(value
                .split(",")).map(Integer::parseInt).toList();
        if(studentsFilter.isEmpty()) {
            studentsFilter.addAll(studentRepository.findAllBySchoolsIdContaining(schools));
        } else {
            studentsFilter.retainAll(studentRepository.findAllBySchoolsIdContaining(schools));
        }
    }

    private void filterByYear(String value, List<Student> studentsFilter) {
        List<YearStudy> years = Arrays.stream(value
                .split(",")).map(Integer::parseInt)
                        .map(yearStudyMapper::mapFromInteger)
                                .toList();
        if(studentsFilter.isEmpty()) {
            studentsFilter.addAll(studentRepository.findAllByYearStudyContaining(years));
        } else {
            studentsFilter.retainAll(studentRepository.findAllByYearStudyContaining(years));
        }
    }

    private void filterBySpecialityId(String value, List<Student> studentsFilter) {
        List<Float> specialities = Arrays.stream(value
                .split(",")).map(Float::parseFloat).toList();
        if (studentsFilter.isEmpty()) {
            studentsFilter.addAll(studentRepository.findAllBySpecialityIdConstraining(specialities));
        } else {
            studentsFilter.retainAll(studentRepository.findAllBySpecialityIdConstraining(specialities));
        }
    }
}
