package usm.api.doctoral_registration.util;

import usm.api.doctoral_registration.dto.country.CountryDto;
import usm.api.doctoral_registration.dto.order.OrderSubtypeDto;
import usm.api.doctoral_registration.dto.order.OrderTypeDto;
import usm.api.doctoral_registration.dto.science.*;
import usm.api.doctoral_registration.dto.student.StudentDto;
import usm.api.doctoral_registration.dto.supervisor.SupervisorDto;
import usm.api.doctoral_registration.model.science.ScienceProfile;
import usm.api.doctoral_registration.model.science.ScienceSchool;
import usm.api.doctoral_registration.model.science.Speciality;
import usm.api.doctoral_registration.model.supervisor.Supervisor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestUtils {
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
            .name("speciality")
            .scienceBranch("scienceBranch")
            .scienceDomain("scienceDomain")
            .scienceProfile("scienceProfile")
            .scienceSchool("scienceSchool")
            .scienceSchoolId(1)
            .build();

    public static final Speciality SPECIALITY_FULL = new Speciality(1F,"speciality",new ScienceProfile(),new HashSet<>());
    public static final StudentDto STUDENT_DTO_1_EMPTY = new StudentDto();
    public static final SpecialityDto SPECIALITY_DTO_FULL = SpecialityDto.builder()
            .id(1.0F)
            .name("SpecialityDto")
            .scienceProfileId(1)
            .students(Set.of(STUDENT_DTO_1_EMPTY))
            .build();

    public static final ScienceProfileDto SCIENCE_PROFILE_DTO_FULL = ScienceProfileDto.builder()
            .id(1)
            .name("ScienceProfileDto")
            .scienceBranchId(1)
            .specialities(Set.of(SPECIALITY_DTO_FULL))
            .build();

    public static final ScienceBranchDto SCIENCE_BRANCH_DTO_FULL = ScienceBranchDto.builder()
            .id(1)
            .name("ScienceProfileDto")
            .scienceDomainId(1)
            .scienceProfiles(Set.of(SCIENCE_PROFILE_DTO_FULL))
            .build();

    public static final ScienceDomainDto SCIENCE_DOMAIN_DTO_FULL = ScienceDomainDto.builder()
            .id(1)
            .name("ScienceDomainDto")
            .scienceSchoolId(1)
            .scienceBranches(Set.of(SCIENCE_BRANCH_DTO_FULL))
            .build();

    public static final ScienceSchoolDto SCIENCE_SCHOOL_DTO_1_FULL = ScienceSchoolDto.builder()
            .id(1L)
            .name("ScienceSchoolDto")
            .build();
    public static final ScienceSchool SCIENCE_SCHOOL_FULL = new ScienceSchool(2, "ScienceSchool", new HashSet<>());

    public static final SupervisorDto SUPERVISOR_DTO_1_FULL = SupervisorDto.builder()
            .id(1L)
            .firstName("Anton")
            .lastName("Antonov")
            .academician("academician")
            .post("post")
            .speciality("speciality")
            .scienceSchool(SCIENCE_SCHOOL_DTO_1_FULL)
            .build();

    public static final SupervisorDto SUPERVISOR_DTO_2_FULL = SupervisorDto.builder()
            .id(2L)
            .firstName("Ion")
            .lastName("Ionov")
            .academician("academician")
            .post("post")
            .speciality("speciality")
            .scienceSchool(SCIENCE_SCHOOL_DTO_1_FULL)
            .build();


    public static final Supervisor SUPERVISOR_1_FULL = new Supervisor(1L,"Anton","Antonov","post",
            "speciality","academician", SCIENCE_SCHOOL_FULL,new HashSet<>(),new HashSet<>());

    public static final Supervisor SUPERVISOR_2_FULL = new Supervisor(2L,"Ion","Ionov","post",
            "speciality","academician", SCIENCE_SCHOOL_FULL,new HashSet<>(),new HashSet<>());


    public static final StudentDto STUDENT_DTO_1_FULL = StudentDto.builder()
            .id(1L)
            .firstName("Andrei")
            .lastName("Andreev")
            .speciality(STUDENT_SPECIALITY_DTO_FULL)
            .supervisor(SUPERVISOR_DTO_1_FULL)
            .steeringCommittee(new HashSet<>(Set.of(SUPERVISOR_DTO_2_FULL)))

            .build();
}
