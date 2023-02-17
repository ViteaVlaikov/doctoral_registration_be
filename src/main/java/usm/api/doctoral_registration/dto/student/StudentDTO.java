package usm.api.doctoral_registration.dto.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import usm.api.doctoral_registration.dto.country.CountryDTO;
import usm.api.doctoral_registration.dto.supervisor.SupervisorDTO;
import usm.api.doctoral_registration.model.science.ScienceSchool;
import usm.api.doctoral_registration.model.science.ScienceBranch;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private String corporateEmail;

    private String firstName;

    private String lastName;

    private String patronymicName;

    private int yearBirth;

    private String identNumber;

    private String gender;

    private CountryDTO citizenship;

    private String diplomaSeries;

    private long diplomaNumber;

    private String personalEmail;

    private String phoneNumber;

    private StudyDTO study;

    private String status;

    // TODO : scienceBranch & scienceSchool -> to remove

    private ScienceBranch scienceBranch;

    private ScienceSchool scienceSchool;

    //

    private String remark;
    private SupervisorDTO supervisor;

    private Set<SupervisorDTO> steeringCommittee;

}
