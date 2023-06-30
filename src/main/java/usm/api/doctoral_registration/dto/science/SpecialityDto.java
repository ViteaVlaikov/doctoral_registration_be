package usm.api.doctoral_registration.dto.science;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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

    public SpecialityDto(Float i) {
        this.id = i;
    }
}