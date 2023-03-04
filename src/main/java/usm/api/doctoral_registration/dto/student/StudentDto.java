package usm.api.doctoral_registration.dto.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import usm.api.doctoral_registration.dto.country.CountryDto;
import usm.api.doctoral_registration.dto.supervisor.SupervisorDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * A DTO for the {@link usm.api.doctoral_registration.model.student.Student} entity
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class OrderDto {

        private Integer id;

        private String number;

        private LocalDate date;

        private Integer orderSubtypeId;

        private Integer orderTypeId;

        private String orderSubtype;

        private String orderType;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class SpecialityDto {
        private Float id;

        private String name;

        private String scienceProfile;

        private String scienceBranch;

        private String scienceDomain;

        private Integer scienceSchoolId;

        private String scienceSchool;
    }

    private Long id;

    private String corporateEmail;

    private String firstName;

    private String lastName;

    private String patronymicName;

    private int yearBirth;

    private String identNumber;

    private String gender;

    private CountryDto citizenship;

    private String diplomaSeries;

    private long diplomaNumber;

    private String personalEmail;

    private String phoneNumber;

    private String status;

    private String registration;

    private List<OrderDto> orders;

    private String yearStudy;

    private LocalDate beginStudies;

    private LocalDate endStudies;

    private String studyType;

    private String financing;

    private String remark;

    private String scienceTopic;

    private SupervisorDto supervisor;

    private SpecialityDto speciality;

    private Set<SupervisorDto> steeringCommittee;
}
