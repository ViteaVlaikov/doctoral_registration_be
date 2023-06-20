package usm.api.doctoral_registration.tool.excel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import usm.api.doctoral_registration.dto.student.StudentDto;
import usm.api.doctoral_registration.tools.excel.StudentExcelReader;
import usm.api.doctoral_registration.mapper.science.SpecialityMapper;
import usm.api.doctoral_registration.mapper.student.StudentMapper;
import usm.api.doctoral_registration.repository.science.ScienceBranchRepository;
import usm.api.doctoral_registration.repository.science.ScienceProfileRepository;
import usm.api.doctoral_registration.repository.science.SpecialityRepository;
import usm.api.doctoral_registration.repository.student.StudentRepository;
import usm.api.doctoral_registration.repository.supervisor.SupervisorRepository;
import usm.api.doctoral_registration.service.science.SpecialityService;
import usm.api.doctoral_registration.service.student.StudentService;

import java.util.List;

//@SpringJUnitConfig(classes = {StudentMapperImpl.class, CountryMapperImpl.class,
//        SupervisorMapperImpl.class, StudyMapperImpl.class, StudentRepository.class})
@SpringBootTest
@TestPropertySource(
        locations = "classpath:application.properties")
class StudentExcelToolsTest {

    @Autowired
    private StudentExcelReader studentExcelTools;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;

    @Autowired
    private SpecialityRepository specialityRepository;

    private final static String PATH = "./src/test/java/usm/api/doctoral_registration/tool/excel/";
    @Autowired
    private SupervisorRepository supervisorRepository;
    @Autowired
    private SpecialityMapper specialityMapper;
    @Autowired
    private ScienceProfileRepository scienceProfileRepository;
    @Autowired
    private ScienceBranchRepository scienceBranchRepository;
    @Autowired
    private SpecialityService specialityService;

    @Test
    void test() {
        List<StudentDto> studentDtos = studentExcelTools.read(PATH + "students.xlsx", 2);
        for (int i = 0; i < 137; i++) {
            studentDtos.remove(studentDtos.size() - 1);
        }
        studentDtos.forEach(System.out::println);

//        List<Student> students = studentDtos.stream().map(studentMapper::toEntity).toList();

        //511.01
//        Map<Float, Speciality> specialities = specialityRepository
//                .findAll().stream().collect(Collectors.toMap(Speciality::getId, Function.identity()));
//        students.forEach(System.out::println);
//        for(int i = 0; i < students.size(); i++) {
////            System.out.println(studentDtos.get(i));
//            specialities
//                    .get(studentDtos.get(i).getSpecialityId())
//                    .getStudents().add(studentMapper.toEntity(studentDtos.get(i)));
//            students.get(i).setSpeciality(specialities
//                    .get(studentDtos.get(i).getSpecialityId()));
//        }
//        students.forEach(student -> student.getStudy().setSpeciality(specialityRepository.findById(student.)));

        //students.forEach(student -> student.getCitizenship().setStudent(students));
        //students.forEach(student -> student.getStudy().setSpeciality(specialityRepository.findById(student.)));
        studentDtos.forEach(s->studentService.save1(s));
    }


}