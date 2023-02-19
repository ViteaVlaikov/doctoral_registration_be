package usm.api.doctoral_registration.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import usm.api.doctoral_registration.dto.student.StudentDto;
import usm.api.doctoral_registration.dto.student.StudyDto;
import usm.api.doctoral_registration.model.country.Country;
import usm.api.doctoral_registration.model.science.Speciality;
import usm.api.doctoral_registration.model.student.Student;
import usm.api.doctoral_registration.model.student.Study;
import usm.api.doctoral_registration.model.student.properties.Gender;
import usm.api.doctoral_registration.model.student.properties.Registration;
import usm.api.doctoral_registration.model.student.properties.Status;

@SpringJUnitConfig(classes = {StudentMapperImpl.class, CountryMapperImpl.class, SupervisorMapperImpl.class, StudyMapperImpl.class})
class StudentMapperTest {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    StudyMapper studyMapper;

    Student student;

    StudentDto studentDTO;

    Study study;

    @BeforeEach
    void startUp() {
        student = new Student();
        student.setId(1L);
        student.setCorporateEmail("student.student@usm.md");
        student.setFirstName("Ion");
        student.setLastName("Botilia");
        student.setPatronymicName("Artiomov");
        student.setYearBirth(2002);
        student.setIdentNumber("123456789012");
        student.setGender(Gender.MASCULINE);

        Country country = new Country();
        country.setId(1);
        country.setCountry("Republica Moldova");
        //country.setStudent(List.of(student));
        student.setCitizenship(country);
        student.setDiplomaSeries("diploma");
        student.setDiplomaNumber(12345);
        student.setPersonalEmail("student@gmail.com");
        student.setStatus(Status.ACTIVE);
        study = new Study();
        study.setRegistration(Registration.ENROLLED);
        study.setSpeciality(new Speciality());
//        study.setOrders();

        student.setStudy(study);

    }

    @Test
    void test() {
        StudentDto studentDto1 = studentMapper.toDto(student);
        System.out.println(student);
        System.out.println(studentDto1);
    }

    @Test
    void testStudy() {
        StudyDto studyDto1 = studyMapper.toDto(study);

        System.out.println(studyDto1);
    }
}