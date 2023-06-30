package usm.api.doctoral_registration.repository.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import usm.api.doctoral_registration.model.student.Student;
import usm.api.doctoral_registration.model.student.properties.*;
import usm.api.doctoral_registration.model.supervisor.Supervisor;
import usm.api.doctoral_registration.repository.country.CountryRepository;
import usm.api.doctoral_registration.repository.order.OrderRepository;
import usm.api.doctoral_registration.repository.order.OrderSubtypeRepository;
import usm.api.doctoral_registration.repository.science.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static usm.api.doctoral_registration.repository.student.StudentRepository.*;
import static usm.api.doctoral_registration.util.test.TestUtils.*;

@DataJpaTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SpecialityRepository specialityRepository;

    @Autowired
    private ScienceProfileRepository scienceProfileRepository;

    @Autowired
    private ScienceBranchRepository scienceBranchRepository;

    @Autowired
    private ScienceDomainRepository scienceDomainRepository;

    @Autowired
    private ScienceSchoolRepository scienceSchoolRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderSubtypeRepository orderSubtypeRepository;

    @BeforeEach
    void setUp() {
        orderSubtypeRepository.save(ORDER_SUBTYPE_FOR_SAVING);
        orderRepository.save(ORDER_FOR_SAVING);
        countryRepository.save(MOLDOVA);
        scienceSchoolRepository.save(SCIENCE_SCHOOL_FOR_SAVING);
        scienceSchoolRepository.save(SCIENCE_SCHOOL_FOR_SAVING_1);
        scienceDomainRepository.save(SCIENCE_DOMAIN_FOR_SAVING);
        scienceDomainRepository.save(SCIENCE_DOMAIN_FOR_SAVING_1);
        scienceBranchRepository.save(SCIENCE_BRANCH_FOR_SAVING);
        scienceBranchRepository.save(SCIENCE_BRANCH_FOR_SAVING_1);
        scienceProfileRepository.save(SCIENCE_PROFILE_FOR_SAVING);
        scienceProfileRepository.save(SCIENCE_PROFILE_FOR_SAVING_1);
        specialityRepository.save(SPECIALITY_FOR_SAVING);
        specialityRepository.save(SPECIALITY_FOR_SAVING_1);
        studentRepository.saveAll(Arrays.asList(STUDENT_FOR_SAVING_1, STUDENT_FOR_SAVING_2, STUDENT_FOR_SAVING_3));
    }

    @Test
    void testByYearStudy() {
        List<Student> students = studentRepository.findAll(byYearStudy(List.of(YearStudy.I)));

        assertEquals(students.get(0).getYearStudy(), STUDENT_FOR_SAVING_1.getYearStudy());
    }

    @Test
    void testBySchoolsId() {
        Integer scienceSchoolId = SCIENCE_SCHOOL_FOR_SAVING_1.getId();

        List<Student> students = studentRepository.findAll(bySchoolsId(List.of(scienceSchoolId)));

        assertEquals(students.get(0).getSpeciality().getScienceProfile().getScienceBranch().getScienceDomain().getScienceSchool(),
                STUDENT_FOR_SAVING_1.getSpeciality().getScienceProfile().getScienceBranch().getScienceDomain().getScienceSchool());
    }

    @Test
    void testByDomainsId() {
        Integer scienceDomainId = SCIENCE_DOMAIN_FOR_SAVING_1.getId();

        List<Student> students = studentRepository.findAll(byDomainsId(Collections.singletonList(scienceDomainId)));

        assertEquals(students.get(0).getSpeciality().getScienceProfile().getScienceBranch().getScienceDomain(),
                STUDENT_FOR_SAVING_1.getSpeciality().getScienceProfile().getScienceBranch().getScienceDomain());
    }

    @Test
    void testByBranchesId() {
        Integer scienceBranchId = SCIENCE_BRANCH_FOR_SAVING_1.getId();

        List<Student> students = studentRepository.findAll(byBranchesId(Collections.singletonList(scienceBranchId)));

        assertEquals(students.get(0).getSpeciality().getScienceProfile().getScienceBranch(),
                STUDENT_FOR_SAVING_1.getSpeciality().getScienceProfile().getScienceBranch());
    }

    @Test
    void testByProfilesId() {
        Integer scienceProfileId = SCIENCE_PROFILE_FOR_SAVING_1.getId();

        List<Student> students = studentRepository.findAll(byProfilesId(Collections.singletonList(scienceProfileId)));

        assertEquals(students.get(0).getSpeciality().getScienceProfile(),
                STUDENT_FOR_SAVING_1.getSpeciality().getScienceProfile());
    }

    @Test
    void testBySpecialitiesId() {
        Float specialityId = SPECIALITY_FOR_SAVING_1.getId();

        List<Student> students = studentRepository.findAll(bySpecialitiesId(Collections.singletonList(specialityId)));

        assertEquals(students.get(0).getSpeciality(),
                STUDENT_FOR_SAVING_1.getSpeciality());
    }

    @Test
    void testByGender() {
        Gender gender = STUDENT_FOR_SAVING_1.getGender();

        List<Student> students = studentRepository.findAll(byGender(Collections.singletonList(gender)));

        assertEquals(students.get(0).getGender(), STUDENT_FOR_SAVING_1.getGender());
    }

    @Test
    void testByStatus() {
        Status status = STUDENT_FOR_SAVING_1.getStatus();

        List<Student> students = studentRepository.findAll(byStatus(Collections.singletonList(status)));

        assertEquals(students.get(0).getStatus(), STUDENT_FOR_SAVING_1.getStatus());
    }

    @Test
    void testByFinancing() {
        Financing financing = STUDENT_FOR_SAVING_1.getFinancing();

        List<Student> students = studentRepository.findAll(byFinancing(Collections.singletonList(financing)));

        assertEquals(students.get(0).getFinancing(), STUDENT_FOR_SAVING_1.getFinancing());
    }

    @Test
    void testByRegistration() {
        Registration registration = STUDENT_FOR_SAVING_1.getRegistration();

        List<Student> students = studentRepository.findAll(byRegistration(Collections.singletonList(registration)));

        assertEquals(students.get(0).getRegistration(), STUDENT_FOR_SAVING_1.getRegistration());
    }

    @Test
    void testByStudyType() {
        StudyType studyType = STUDENT_FOR_SAVING_1.getStudyType();

        List<Student> students = studentRepository.findAll(byStudyType(Collections.singletonList(studyType)));

        assertEquals(students.get(0).getStudyType(), STUDENT_FOR_SAVING_1.getStudyType());
    }

    @Test
    void testByYearsBirth() {
        Integer yearOfBirth = STUDENT_FOR_SAVING_1.getYearBirth();

        List<Student> students = studentRepository.findAll(byYearsBirth(Collections.singletonList(yearOfBirth)));

        assertEquals(students.get(0).getYearBirth(), STUDENT_FOR_SAVING_1.getYearBirth());
    }

    @Test
    void testByYearsBegin() {
        LocalDate yearBegin = STUDENT_FOR_SAVING_1.getBeginStudies();

        List<Student> students = studentRepository.findAll(byYearsBegin(Collections.singletonList(yearBegin)));

        assertEquals(students.get(0).getBeginStudies(), STUDENT_FOR_SAVING_1.getBeginStudies());
    }

    @Test
    void testByYearsEnd() {
        LocalDate yearEnd = STUDENT_FOR_SAVING_1.getEndStudies();

        List<Student> students = studentRepository.findAll(byYearsEnd(Collections.singletonList(yearEnd)));

        assertEquals(students.get(0).getEndStudies(), STUDENT_FOR_SAVING_1.getEndStudies());
    }

    @Test
    void testByFullNames() {
        String fullName = STUDENT_FOR_SAVING_1.getLastName() + " " + STUDENT_FOR_SAVING_1.getFirstName() + " " +
                STUDENT_FOR_SAVING_1.getPatronymicName();

        List<Student> students = studentRepository.findAll(byFullNames(Collections.singletonList(fullName)));

        assertEquals(students.get(0).getLastName(), STUDENT_FOR_SAVING_1.getLastName());
        assertEquals(students.get(0).getFirstName(), STUDENT_FOR_SAVING_1.getFirstName());
        assertEquals(students.get(0).getPatronymicName(), STUDENT_FOR_SAVING_1.getPatronymicName());
    }

    @Test
    void testByEmails() {
        String email = STUDENT_FOR_SAVING_1.getPersonalEmail();

        List<Student> students = studentRepository.findAll(byEmails(Collections.singletonList(email)));

        assertEquals(students.get(0).getCorporateEmail(), STUDENT_FOR_SAVING_1.getCorporateEmail());
        assertEquals(students.get(0).getPersonalEmail(), STUDENT_FOR_SAVING_1.getPersonalEmail());
    }

    @Test
    void testByIdentNumber() {
        String identNumber = STUDENT_FOR_SAVING_1.getIdentNumber();

        List<Student> students = studentRepository.findAll(byIdentNumber(Collections.singletonList(identNumber)));

        assertEquals(students.get(0).getIdentNumber(), STUDENT_FOR_SAVING_1.getIdentNumber());
    }

    @Test
    void testByCitizenship() {
        String citizenship = STUDENT_FOR_SAVING_1.getCitizenship().getName();

        List<Student> students = studentRepository.findAll(byCitizenship(Collections.singletonList(citizenship)));

        assertEquals(students.get(0).getCitizenship().getId(), STUDENT_FOR_SAVING_1.getCitizenship().getId());
    }

    @Test
    void testByDiplomas() {
        String diploma = STUDENT_FOR_SAVING_1.getDiplomaSeries() + " " + STUDENT_FOR_SAVING_1.getDiplomaNumber();

        List<Student> students = studentRepository.findAll(byDiplomas(Collections.singletonList(diploma)));

        assertEquals(students.get(0).getDiplomaNumber(), STUDENT_FOR_SAVING_1.getDiplomaNumber());
        assertEquals(students.get(0).getDiplomaSeries(), STUDENT_FOR_SAVING_1.getDiplomaSeries());
    }

    @Test
    void testByPhoneNumbers() {
        String phoneNumber = STUDENT_FOR_SAVING_1.getPhoneNumber();

        List<Student> students = studentRepository.findAll(byPhoneNumbers(Collections.singletonList(phoneNumber)));

        assertEquals(students.get(0).getPhoneNumber(), STUDENT_FOR_SAVING_1.getPhoneNumber());
    }

    @Test
    void testBySupervisors() {
        Long supervisorId = STUDENT_FOR_SAVING_1.getSupervisor().getId();

        List<Student> students = studentRepository.findAll(bySupervisors(Collections.singletonList(supervisorId)));

        assertEquals(students.get(0).getSupervisor().getId(), STUDENT_FOR_SAVING_1.getSupervisor().getId());
    }

    @Test
    void testByCommittees() {
        List<Long> committeeIds = STUDENT_FOR_SAVING_1.getSteeringCommittee().stream().map(Supervisor::getId).toList();

        List<Student> students = studentRepository.findAll(byCommittees(committeeIds));
        List<Long> idsFromBd = students.get(0).getSteeringCommittee().stream().map(Supervisor::getId).toList();

        assertTrue(idsFromBd.containsAll(committeeIds));
    }
}

