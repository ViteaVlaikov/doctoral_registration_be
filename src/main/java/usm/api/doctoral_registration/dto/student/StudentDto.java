package usm.api.doctoral_registration.dto.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import usm.api.doctoral_registration.dto.country.CountryDto;
import usm.api.doctoral_registration.dto.supervisor.SupervisorDto;
import usm.api.doctoral_registration.model.science.ScienceSchool;
import usm.api.doctoral_registration.model.science.ScienceBranch;

import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
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

    private StudyDto study;

    private String status;

    // TODO : scienceBranch & scienceSchool -> to remove

    private ScienceBranch scienceBranch;

    private ScienceSchool scienceSchool;

    //

    private String remark;
    private SupervisorDto supervisor;

    private Set<SupervisorDto> steeringCommittee;

    private Float specialityId;
}
