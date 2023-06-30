package usm.api.doctoral_registration.dto.science;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link usm.api.doctoral_registration.model.science.ScienceProfile} entity
 */
@Data
@Builder
@AllArgsConstructor
public class ScienceProfileDto implements Serializable {

    private Integer id;

    private String name;

    private Integer scienceBranchId;

    @ToString.Exclude
    private Set<SpecialityDto> specialities;
}