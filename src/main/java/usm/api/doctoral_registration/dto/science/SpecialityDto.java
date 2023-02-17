package usm.api.doctoral_registration.dto.science;

import lombok.Data;
import usm.api.doctoral_registration.model.science.ScienceProfile;

import java.io.Serializable;

/**
 * A DTO for the {@link usm.api.doctoral_registration.model.science.Speciality} entity
 */
@Data
public class SpecialityDto implements Serializable {
    private final Float id;
    private final String name;
    private final ScienceProfile scienceProfile;
}