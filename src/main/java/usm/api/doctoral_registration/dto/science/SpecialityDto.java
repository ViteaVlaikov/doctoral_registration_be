package usm.api.doctoral_registration.dto.science;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import usm.api.doctoral_registration.dto.student.StudentDto;
import usm.api.doctoral_registration.model.student.Student;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link usm.api.doctoral_registration.model.science.Speciality} entity
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpecialityDto implements Serializable {
    private Float id;
    private String name;
    private Integer scienceProfileId;
    @ToString.Exclude
    private Set<StudentDto> students;
}