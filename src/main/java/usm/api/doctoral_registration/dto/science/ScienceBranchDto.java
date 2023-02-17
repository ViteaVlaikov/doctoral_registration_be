package usm.api.doctoral_registration.dto.science;

import lombok.Data;
import usm.api.doctoral_registration.model.science.ScienceDomain;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link usm.api.doctoral_registration.model.science.ScienceBranch} entity
 */
@Data
public class ScienceBranchDto implements Serializable {
    private final Integer id;
    private final String name;
    private final ScienceDomain scienceDomain;
    private final Set<ScienceProfileDto> scienceProfiles;
}