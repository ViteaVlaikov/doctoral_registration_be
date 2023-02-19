package usm.api.doctoral_registration.dto.science;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import usm.api.doctoral_registration.model.science.ScienceDomain;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link usm.api.doctoral_registration.model.science.ScienceBranch} entity
 */
@Data
@Builder
@AllArgsConstructor
public class ScienceBranchDto implements Serializable {
    private final Long id;
    private final String name;
    private final Long scienceDomainId;
//    private final ScienceDomainDto scienceDomain;
    @ToString.Exclude
    private final Set<ScienceProfileDto> scienceProfiles;
}