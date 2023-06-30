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
import usm.api.doctoral_registration.model.science.*;
import usm.api.doctoral_registration.model.student.Student;
import usm.api.doctoral_registration.model.student.properties.*;
import usm.api.doctoral_registration.model.supervisor.Supervisor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static usm.api.doctoral_registration.util.string.StringUtils.*;

public class TestUtils {

    private TestUtils(){}
    public static final CountryDto MOLDOVA = CountryDto.builder().id(1).country("Moldova").build();

    public static final CountryDto USA = CountryDto.builder().id(2).country("USA").build();

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

    public static final ScienceSchool SCIENCE_SCHOOL_FOR_REPORT = new ScienceSchool(1,SCIENCE_SCHOOL, new HashSet<>());
    public static final ScienceDomain SCIENCE_DOMAIN_FOR_REPORT = new ScienceDomain(1, 1,SCIENCE_DOMAIN, SCIENCE_SCHOOL_FOR_REPORT,new HashSet<>());
    public static final ScienceBranch SCIENCE_BRANCH_FOR_REPORT = new ScienceBranch(1,SCIENCE_BRANCH,SCIENCE_DOMAIN_FOR_REPORT,new HashSet<>());
    public static final ScienceProfile SCIENCE_PROFILE_FOR_REPORT = new ScienceProfile(1,SCIENCE_PROFILE, SCIENCE_BRANCH_FOR_REPORT, new HashSet<>());
    public static final Speciality SPECIALITY_FOR_REPORT = new Speciality(1F,SPECIALITY, SCIENCE_PROFILE_FOR_REPORT,new HashSet<>());

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
    public static final ScienceSchool SCIENCE_SCHOOL_FULL = new ScienceSchool(2, "ScienceSchool", new HashSet<>());

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
            SPECIALITY,ACADEMICIAN, SCIENCE_SCHOOL_FULL,new HashSet<>(),new HashSet<>());

    public static final Supervisor SUPERVISOR_2_FULL = new Supervisor(2L,"Ion","Ionov","post",
            SPECIALITY,ACADEMICIAN, SCIENCE_SCHOOL_FULL,new HashSet<>(),new HashSet<>());


    public static final StudentDto STUDENT_DTO_1_FULL = StudentDto.builder()
            .id(1L)
            .firstName("Andrei")
            .lastName("Andreev")
            .speciality(STUDENT_SPECIALITY_DTO_FULL)
            .supervisor(SUPERVISOR_DTO_1_FULL)
            .steeringCommittee(new HashSet<>(Set.of(SUPERVISOR_DTO_2_FULL)))
            .build();

    public static final Student STUDENT_FOR_REPORT = new Student(1L, "example@example.com", "John",
            "Doe", "Smith", 1990, "1234567890", Gender.M,
            new Country(), "AB", 12345, "john.doe@example.com",
            "123456789", Status.ACTIVE, Registration.TRANSFERRED, List.of(new Order(1,new OrderSubtype(),"", LocalDate.now(),new Student())),
            YearStudy.I, LocalDate.of(2023, 9, 1), LocalDate.of(2027, 6, 30),
            StudyType.FREQUENCY, Financing.BUDGET, SUPERVISOR_1_FULL, SPECIALITY_FOR_REPORT,
            new HashSet<>(List.of(SUPERVISOR_2_FULL)),"","");
}
