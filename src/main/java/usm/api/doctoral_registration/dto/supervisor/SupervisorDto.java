package usm.api.doctoral_registration.dto.supervisor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import usm.api.doctoral_registration.dto.science.ScienceSchoolDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupervisorDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String post;

    private String speciality;

    private String academician;

    private ScienceSchoolDto scienceSchool;
}
