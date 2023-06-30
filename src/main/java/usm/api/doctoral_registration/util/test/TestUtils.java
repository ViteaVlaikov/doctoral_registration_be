package usm.api.doctoral_registration.util.test;

import usm.api.doctoral_registration.dto.country.CountryDto;
import usm.api.doctoral_registration.dto.order.OrderSubtypeDto;
import usm.api.doctoral_registration.dto.order.OrderTypeDto;
import usm.api.doctoral_registration.dto.science.*;
import usm.api.doctoral_registration.dto.student.StudentDto;
import usm.api.doctoral_registration.dto.supervisor.SupervisorDto;
import usm.api.doctoral_registration.model.country.Country;
import usm.api.doctoral_registration.model.order.Order;
import usm.api.doctoral_registration.model.order.OrderSubtype;
import usm.api.doctoral_registration.model.order.OrderType;
import usm.api.doctoral_registration.model.science.*;
import usm.api.doctoral_registration.model.student.Student;
import usm.api.doctoral_registration.model.student.properties.*;
import usm.api.doctoral_registration.model.supervisor.Supervisor;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static usm.api.doctoral_registration.util.string.StringUtils.*;

public class TestUtils {

    private TestUtils(){}
    public static final CountryDto MOLDOVA_DTO = CountryDto.builder().id(1).country("Moldova").build();

    public static final Country MOLDOVA = new Country(1,"Moldova", Collections.emptyList());

    public static final CountryDto USA_DTO = CountryDto.builder().id(2).country("USA").build();

    public static final Country USA = new Country(2,"USA", Collections.emptyList());

    public static final OrderSubtypeDto ORDER_SUBTYPE_DTO_FULL = OrderSubtypeDto.builder()
            .id(1)
            .order("OrderSubtypeDto")
            .orderTypeId(1)
            .build();

    public static final OrderTypeDto ORDER_TYPE_DTO_FULL = OrderTypeDto.builder()
            .id(1)
            .order("OrderTypeDto")
            .orderSubtypes(List.of(ORDER_SUBTYPE_DTO_FULL))
            .build();

    public static final StudentDto.SpecialityDto STUDENT_SPECIALITY_DTO_FULL = StudentDto.SpecialityDto.builder()
            .id(1F)
            .name(SPECIALITY)
            .scienceBranch(SCIENCE_BRANCH)
            .scienceDomain(SCIENCE_DOMAIN)
            .scienceProfile(SCIENCE_PROFILE)
            .scienceSchool(SCIENCE_SCHOOL)
            .scienceSchoolId(1)
            .build();

    public static final ScienceSchool SCIENCE_SCHOOL_1_FOR_REPORT = new ScienceSchool(1,SCIENCE_SCHOOL, new HashSet<>());
    public static final ScienceDomain SCIENCE_DOMAIN_1_FOR_REPORT = new ScienceDomain(1, 1,SCIENCE_DOMAIN, SCIENCE_SCHOOL_1_FOR_REPORT,new HashSet<>());
    public static final ScienceBranch SCIENCE_BRANCH_1_FOR_REPORT = new ScienceBranch(1,SCIENCE_BRANCH, SCIENCE_DOMAIN_1_FOR_REPORT,new HashSet<>());
    public static final ScienceProfile SCIENCE_PROFILE_1_FOR_REPORT = new ScienceProfile(1,SCIENCE_PROFILE, SCIENCE_BRANCH_1_FOR_REPORT, new HashSet<>());
    public static final Speciality SPECIALITY_1_FOR_REPORT = new Speciality(1F,SPECIALITY, SCIENCE_PROFILE_1_FOR_REPORT,new HashSet<>());

    public static final ScienceSchool SCIENCE_SCHOOL_2 = new ScienceSchool(1,SCIENCE_SCHOOL, new HashSet<>());
    public static final ScienceDomain SCIENCE_DOMAIN_2 = new ScienceDomain(1, 1,SCIENCE_DOMAIN, SCIENCE_SCHOOL_2,new HashSet<>());
    public static final ScienceBranch SCIENCE_BRANCH_2 = new ScienceBranch(1,SCIENCE_BRANCH, SCIENCE_DOMAIN_2,new HashSet<>());
    public static final ScienceProfile SCIENCE_PROFILE_2 = new ScienceProfile(1,SCIENCE_PROFILE, SCIENCE_BRANCH_2, new HashSet<>());
    public static final Speciality SPECIALITY_2 = new Speciality(1F,SPECIALITY, SCIENCE_PROFILE_2,new HashSet<>());

    public static final StudentDto STUDENT_DTO_1_EMPTY = new StudentDto();
    public static final SpecialityDto SPECIALITY_DTO_FULL = SpecialityDto.builder()
            .id(1.0F)
            .name(SPECIALITY_DTO)
            .scienceProfileId(1)
            .build();

    public static final ScienceProfileDto SCIENCE_PROFILE_DTO_FULL = ScienceProfileDto.builder()
            .id(1)
            .name(SCIENCE_PROFILE_DTO)
            .scienceBranchId(1)
            .specialities(Set.of(SPECIALITY_DTO_FULL))
            .build();

    public static final ScienceBranchDto SCIENCE_BRANCH_DTO_FULL = ScienceBranchDto.builder()
            .id(1)
            .name(SCIENCE_BRANCH_DTO)
            .scienceDomainId(1)
            .scienceProfiles(Set.of(SCIENCE_PROFILE_DTO_FULL))
            .build();

    public static final ScienceDomainDto SCIENCE_DOMAIN_DTO_FULL = ScienceDomainDto.builder()
            .id(1)
            .name(SCIENCE_DOMAIN_DTO)
            .scienceSchoolId(1)
            .scienceBranches(Set.of(SCIENCE_BRANCH_DTO_FULL))
            .build();

    public static final ScienceSchoolDto SCIENCE_SCHOOL_DTO_1_FULL = ScienceSchoolDto.builder()
            .id(1L)
            .name(SCIENCE_SCHOOL_DTO)
            .build();
    public static final ScienceSchool SCIENCE_SCHOOL_1_FULL = new ScienceSchool(2, SCIENCE_SCHOOL, new HashSet<>());

    public static final SupervisorDto SUPERVISOR_DTO_1_FULL = SupervisorDto.builder()
            .id(1L)
            .firstName("Anton")
            .lastName("Antonov")
            .academician(ACADEMICIAN)
            .post("post")
            .speciality(SPECIALITY)
            .scienceSchoolId(1L)
            .build();

    public static final SupervisorDto SUPERVISOR_DTO_2_FULL = SupervisorDto.builder()
            .id(2L)
            .firstName("Ion")
            .lastName("Ionov")
            .academician(ACADEMICIAN)
            .post("post")
            .speciality(SPECIALITY)
            .scienceSchoolId(1L)
            .build();


    public static final Supervisor SUPERVISOR_1_FULL = new Supervisor(1L,"Anton","Antonov","post",
            SPECIALITY,ACADEMICIAN, SCIENCE_SCHOOL_1_FULL,new HashSet<>(),new HashSet<>());

    public static final Supervisor SUPERVISOR_2_FULL = new Supervisor(2L,"Ion","Ionov","post",
            SPECIALITY,ACADEMICIAN, SCIENCE_SCHOOL_1_FULL,new HashSet<>(),new HashSet<>());


    public static final Set<SupervisorDto> STEERING_COMMITTEE_DTO = new HashSet<>(Set.of(SUPERVISOR_DTO_2_FULL));

    public static final Set<Supervisor> STEERING_COMMITTEE = new HashSet<>(List.of(SUPERVISOR_2_FULL));

    public static final StudentDto STUDENT_DTO_1_FULL = StudentDto.builder()
            .id(1L)
            .firstName("Andrei")
            .lastName("Andreev")
            .speciality(STUDENT_SPECIALITY_DTO_FULL)
            .supervisor(SUPERVISOR_DTO_1_FULL)
            .steeringCommittee(STEERING_COMMITTEE_DTO)
            .citizenship(MOLDOVA_DTO)
            .build();

    public static final StudentDto STUDENT_DTO_2_FULL = StudentDto.builder()
            .id(2L)
            .firstName("Alexei")
            .lastName("Alexeev")
            .speciality(STUDENT_SPECIALITY_DTO_FULL)
            .supervisor(SUPERVISOR_DTO_1_FULL)
            .steeringCommittee(STEERING_COMMITTEE_DTO)
            .citizenship(MOLDOVA_DTO)
            .build();

    public static final StudentDto STUDENT_DTO_3_FULL = StudentDto.builder()
            .id(3L)
            .firstName("Ivan")
            .lastName("Ivanov")
            .speciality(STUDENT_SPECIALITY_DTO_FULL)
            .supervisor(SUPERVISOR_DTO_1_FULL)
            .steeringCommittee(STEERING_COMMITTEE_DTO)
            .citizenship(MOLDOVA_DTO)
            .build();

    public static final Student STUDENT_1_FULL = new Student(1L, "example@example.com", "Andrei",
            "Andreev", "Andreev", 1990, "1234567890", Gender.M,
            new Country(), "AB", 12345, "john.doe@example.com",
            "123456789", Status.ACTIVE, Registration.TRANSFERRED,
            List.of(new Order(1,new OrderSubtype(),"", LocalDate.now(),new Student())),
            YearStudy.I, LocalDate.of(2023, 9, 1), LocalDate.of(2027, 6, 30),
            StudyType.FREQUENCY, Financing.BUDGET, SUPERVISOR_1_FULL, SPECIALITY_1_FOR_REPORT, STEERING_COMMITTEE
            ,"","" );

    public static final Student STUDENT_FOR_REPORT = new Student(100L, "example@example.com", "John",
            "Doe", "Smith", 1990, "1234567890", Gender.M,
            new Country(), "AB", 12345, "john.doe@example.com",
            "123456789", Status.ACTIVE, Registration.TRANSFERRED,
            List.of(new Order(1,new OrderSubtype(),"", LocalDate.now(),new Student())),
            YearStudy.I, LocalDate.of(2023, 9, 1), LocalDate.of(2027, 6, 30),
            StudyType.FREQUENCY, Financing.BUDGET, SUPERVISOR_1_FULL, SPECIALITY_1_FOR_REPORT, STEERING_COMMITTEE
            ,"","");

    public static final ScienceSchool SCIENCE_SCHOOL_FOR_SAVING = new ScienceSchool(1,SCIENCE_SCHOOL, new HashSet<>());

    public static final ScienceSchool SCIENCE_SCHOOL_FOR_SAVING_1 = new ScienceSchool(2,SCIENCE_SCHOOL, new HashSet<>());

    public static final ScienceDomain SCIENCE_DOMAIN_FOR_SAVING = new ScienceDomain(1, 1,SCIENCE_DOMAIN, SCIENCE_SCHOOL_FOR_SAVING,new HashSet<>());

    public static final ScienceDomain SCIENCE_DOMAIN_FOR_SAVING_1 = new ScienceDomain(2, 1,SCIENCE_DOMAIN, SCIENCE_SCHOOL_FOR_SAVING_1,new HashSet<>());

    public static final ScienceBranch SCIENCE_BRANCH_FOR_SAVING = new ScienceBranch(1,SCIENCE_BRANCH, SCIENCE_DOMAIN_FOR_SAVING,new HashSet<>());

    public static final ScienceBranch SCIENCE_BRANCH_FOR_SAVING_1 = new ScienceBranch(2,SCIENCE_BRANCH, SCIENCE_DOMAIN_FOR_SAVING_1,new HashSet<>());

    public static final ScienceProfile SCIENCE_PROFILE_FOR_SAVING = new ScienceProfile(1,SCIENCE_PROFILE, SCIENCE_BRANCH_FOR_SAVING, new HashSet<>());

    public static final ScienceProfile SCIENCE_PROFILE_FOR_SAVING_1 = new ScienceProfile(2,SCIENCE_PROFILE, SCIENCE_BRANCH_FOR_SAVING_1, new HashSet<>());

    public static final Speciality SPECIALITY_FOR_SAVING = new Speciality(1F,SPECIALITY, SCIENCE_PROFILE_FOR_SAVING,new HashSet<>());

    public static final Speciality SPECIALITY_FOR_SAVING_1 = new Speciality(2F,SPECIALITY, SCIENCE_PROFILE_FOR_SAVING_1,new HashSet<>());

    public static final OrderType ORDER_TYPE_FOR_SAVING = new OrderType(1,"orderType",Collections.emptyList());

    public static final OrderSubtype ORDER_SUBTYPE_FOR_SAVING = new OrderSubtype(1,"orderSubtype",ORDER_TYPE_FOR_SAVING,Collections.emptyList());

    public static final Order ORDER_FOR_SAVING = new Order(1,ORDER_SUBTYPE_FOR_SAVING,"", LocalDate.now(),null);

    public static final Student STUDENT_FOR_SAVING_1 = new Student(100L, "example@example.com", "Ivan",
            "Ivanov", "Ivan", 1990, "1234567890", Gender.M,
            MOLDOVA, "AB", 12345, "ivan.ivanov@example.com",
            "123456789", Status.ACTIVE, Registration.TRANSFERRED,
            List.of(ORDER_FOR_SAVING),
            YearStudy.I, LocalDate.of(2020, 9, 1), LocalDate.of(2025, 6, 30),
            StudyType.FREQUENCY, Financing.BUDGET, SUPERVISOR_1_FULL, SPECIALITY_FOR_SAVING_1, STEERING_COMMITTEE
            ,"","");

    public static final Student STUDENT_FOR_SAVING_2 = new Student(100L, "example@example.com", "John",
            "Doe", "Smith", 1991, "1234567890", Gender.M,
            MOLDOVA, "ABC", 123456, "john.doe@example.com",
            "123456789", Status.ACTIVE, Registration.TRANSFERRED,
            List.of(ORDER_FOR_SAVING),
            YearStudy.II, LocalDate.of(2022, 9, 1), LocalDate.of(2026, 6, 30),
            StudyType.FREQUENCY, Financing.BUDGET, SUPERVISOR_1_FULL, SPECIALITY_FOR_SAVING, STEERING_COMMITTEE
            ,"","");

    public static final Student STUDENT_FOR_SAVING_3 = new Student(100L, "example@example.com", "John",
            "Doe", "Smith", 1992, "1234567890", Gender.M,
            MOLDOVA, "ABD", 123454, "john.doe@example.com",
            "123456789", Status.ACTIVE, Registration.TRANSFERRED,
            List.of(ORDER_FOR_SAVING),
            YearStudy.III, LocalDate.of(2021, 9, 1), LocalDate.of(2027, 6, 30),
            StudyType.FREQUENCY, Financing.BUDGET, SUPERVISOR_1_FULL, SPECIALITY_FOR_SAVING, STEERING_COMMITTEE
            ,"","");
}
