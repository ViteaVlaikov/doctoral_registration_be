package usm.api.doctoral_registration.dto.science;

import lombok.Data;
import usm.api.doctoral_registration.model.science.ScienceBranch;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link usm.api.doctoral_registration.model.science.ScienceProfile} entity
 */
@Data
public class ScienceProfileDto implements Serializable {
    private final Integer id;
    private final String name;
    private final ScienceBranch scienceBranch;
    private final Set<SpecialityDto> specialities;
}