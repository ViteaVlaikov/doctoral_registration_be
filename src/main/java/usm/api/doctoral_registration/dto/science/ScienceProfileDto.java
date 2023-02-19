package usm.api.doctoral_registration.dto.science;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import usm.api.doctoral_registration.model.science.ScienceBranch;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link usm.api.doctoral_registration.model.science.ScienceProfile} entity
 */
@Data
@Builder
@AllArgsConstructor
public class ScienceProfileDto implements Serializable {
    private final Long id;
    private final String name;
    private final Long scienceBranchId;
//    private final ScienceBranchDto scienceBranch;
    @ToString.Exclude
    private final Set<SpecialityDto> specialities;
}