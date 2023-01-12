package usm.api.doctoral_registration.DTO.Student;

import lombok.Data;
import lombok.NoArgsConstructor;
import usm.api.doctoral_registration.model.student.Registration;

import java.util.Date;

@Data
@NoArgsConstructor
public class StudentDTO {
    private String corporateEmail;

    private String firstName;

    private String lastName;

    private String patronymicName;

    private String identNumber;

    private String gender;

    private String citizenship;

    private String diplomaSeries;

    private Long diplomaNumber;

    private String personalEmail;

    private String phoneNumber;

    private String registration;

    private Long orderNumber;

    private Date orderDate;

    private Integer yearStudy;

    private Date beginStudies;

    private Date endStudies;

    private String ScienceDomain;

    private String ScienceBranch;

    private String ScienceProfile;

    private String NumberSpeciality;

    private String Speciality;
}
