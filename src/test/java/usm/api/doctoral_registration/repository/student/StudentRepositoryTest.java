package usm.api.doctoral_registration.repository.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import usm.api.doctoral_registration.model.country.Country;
import usm.api.doctoral_registration.model.order.Order;
import usm.api.doctoral_registration.model.order.OrderSubtype;
import usm.api.doctoral_registration.model.science.Speciality;
import usm.api.doctoral_registration.model.student.Student;
import usm.api.doctoral_registration.model.student.properties.*;
import usm.api.doctoral_registration.model.supervisor.Supervisor;
import usm.api.doctoral_registration.repository.country.CountryRepository;
import usm.api.doctoral_registration.repository.order.OrderSubtypeRepository;
import usm.api.doctoral_registration.repository.science.SpecialityRepository;
import usm.api.doctoral_registration.repository.supervisor.SupervisorRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private SpecialityRepository specialityRepository;

    @Autowired
    private OrderSubtypeRepository orderSubtypeRepository;

    @Autowired
    private SupervisorRepository supervisorRepository;

//@Test
    void save() {
        Student student = new Student();
        student.setFirstName("Ion");
        student.setLastName("Viteazu");
        student.setPatronymicName("Vladimir");

        Country country = countryRepository.findById(1).orElseThrow();
        country.setStudent(List.of(student));
        student.setCitizenship(country);

        student.setGender(Gender.M);
        student.setDiplomaNumber(12345678);
        student.setDiplomaSeries("ALII11111111111");
        student.setCorporateEmail("ion.viteazu@usm.com");
        student.setYearBirth(2000);
        student.setIdentNumber("123456789123");
        student.setPersonalEmail("ion.vitiazu@gmail.com");
        student.setPhoneNumber("069468864");
        student.setStatus(Status.ACTIVE);
        student.setRegistration(Registration.ENROLLED);
        student.setYearStudy(YearStudy.II);
        student.setBeginStudies(LocalDate.of(2021, 9, 1));
        student.setEndStudies(LocalDate.of(2024, 5, 1));
        student.setStudyType(StudyType.FREQUENCY);
        student.setFinancing(Financing.BUDGET);
        student.setScienceTopic("topic to study");
        student.setRemark("remark");

        Speciality speciality = specialityRepository.findById(141.01F).orElseThrow();
        speciality.setStudents(Set.of(student));
        student.setSpeciality(speciality);

        List<Order> orders = new ArrayList<>();
        Order order = new Order();
        order.setStudent(student);
        order.setDate(LocalDate.now());
        order.setNumber("11-c");

        OrderSubtype orderSubtype = orderSubtypeRepository
                .findById(1).orElseThrow();
        orderSubtype.setOrders(List.of(order));
        order.setOrderSubtype(orderSubtype);

        orders.add(order);

        order = new Order();
        order.setStudent(student);
        order.setDate(LocalDate.now());
        order.setNumber("11-d");

        orders.add(order);

        orderSubtype = orderSubtypeRepository
                .findById(2).orElseThrow();
        order.setOrderSubtype(orderSubtype);

        student.setOrders(orders);

        Supervisor supervisor = supervisorRepository.findById(1L).orElseThrow();
        supervisor.setStudents(Set.of(student));

        student.setSupervisor(supervisor);

        Set<Supervisor> steeringCommittee = new HashSet<>();
        Supervisor committee = supervisorRepository.findById(2L).orElseThrow();
        steeringCommittee.add(committee);
        committee = supervisorRepository.findById(3L).orElseThrow();
        steeringCommittee.add(committee);
        committee = supervisorRepository.findById(4L).orElseThrow();
        steeringCommittee.add(committee);

        student.setSteeringCommittee(steeringCommittee);

        studentRepository.save(student);
    }


    void read() {
        Student student = studentRepository.findById(22L).orElseThrow();
    }


    void test(){
        studentRepository.deleteById(21L);
    }
}