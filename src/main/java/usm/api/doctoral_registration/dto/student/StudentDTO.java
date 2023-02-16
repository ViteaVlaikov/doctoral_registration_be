package usm.api.doctoral_registration.dto.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import usm.api.doctoral_registration.model.science.ScienceSchool;
import usm.api.doctoral_registration.model.science.ScienceBranch;

import java.time.LocalDate;
import java.util.List;

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

    private Integer citizenship;    // id

    private String diplomaSeries;

    private LocalDate diplomaNumber;

    private String personalEmail;

    private String phoneNumber;

    private StudyDTO studyDTO;

    private String status;

    // TODO : scienceBranch & scienceSchool -> to remove

    private ScienceBranch scienceBranch;

    private ScienceSchool scienceSchool;

    //

    private String remark;
    private String supervisor;

    private List<String> steeringCommittee;

}
