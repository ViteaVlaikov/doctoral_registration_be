package usm.api.doctoral_registration.excel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import usm.api.doctoral_registration.dto.student.StudentDto;
import usm.api.doctoral_registration.mapper.StudentMapper;
import usm.api.doctoral_registration.model.science.Speciality;
import usm.api.doctoral_registration.model.student.Student;
import usm.api.doctoral_registration.repository.science.SpecialityRepository;
import usm.api.doctoral_registration.repository.student.StudentRepository;
import usm.api.doctoral_registration.repository.supervisor.SupervisorRepository;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringJUnitConfig(classes = {StudentMapperImpl.class, CountryMapperImpl.class,
//        SupervisorMapperImpl.class, StudyMapperImpl.class, StudentRepository.class})
@SpringBootTest
@TestPropertySource(
        locations = "classpath:application.properties")
class StudentExcelToolsTest {

    private final StudentExcelReader studentExcelTools = new StudentExcelReader();

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SpecialityRepository specialityRepository;

    private final static String PATH = "./src/test/java/usm/api/doctoral_registration/excel/";
    @Autowired
    private SupervisorRepository supervisorRepository;

    @Test
    void test() {
        List<StudentDto> studentDtos = studentExcelTools.read(PATH + "students.xlsx", 2);


        List<Student> students = studentDtos.stream().map(studentMapper::toEntity).toList();
        //511.01
        Map<Float, Speciality> specialities = specialityRepository
                .findAll().stream().collect(Collectors.toMap(Speciality::getId, Function.identity()));

        for(int i = 0; i < students.size(); i++) {
            System.out.println(studentDtos.get(i));
            students.get(i).getStudy().setSpeciality(specialities
                    .get(studentDtos.get(i).getStudy().getSpeciality().getId()));
        }

//        students.forEach(student -> student.getStudy().setSpeciality(specialityRepository.findById(student.)));

        //students.forEach(student -> student.getCitizenship().setStudent(students));
        //students.forEach(student -> student.getStudy().setSpeciality(specialityRepository.findById(student.)));
        studentRepository.saveAll(students);
    }


}