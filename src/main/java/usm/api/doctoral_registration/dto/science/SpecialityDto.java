package usm.api.doctoral_registration.dto.science;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import usm.api.doctoral_registration.dto.student.StudentDto;
import usm.api.doctoral_registration.model.science.ScienceProfile;
import usm.api.doctoral_registration.model.student.Student;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link usm.api.doctoral_registration.model.science.Speciality} entity
 */
@Data
@Builder
@AllArgsConstructor
public class SpecialityDto implements Serializable {
    private final Float id;
    private final String name;
    private final Long scienceProfileId;
    private final Set<StudentDto> students;
//    private final ScienceProfile scienceProfile;
}