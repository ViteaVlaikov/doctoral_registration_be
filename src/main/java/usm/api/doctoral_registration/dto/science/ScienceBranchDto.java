package usm.api.doctoral_registration.dto.science;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link usm.api.doctoral_registration.model.science.ScienceBranch} entity
 */
@Data
@Builder
@AllArgsConstructor
public class ScienceBranchDto implements Serializable {

    private Integer id;

    private String name;

    private Integer scienceDomainId;

    @ToString.Exclude
    private Set<ScienceProfileDto> scienceProfiles;
}