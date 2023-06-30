package usm.api.doctoral_registration.dto.science;

import lombok.*;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link usm.api.doctoral_registration.model.science.ScienceDomain} entity
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScienceDomainDto implements Serializable {

    private Integer id;

    private Integer number;

    private String name;

    private Integer scienceSchoolId;

    @ToString.Exclude
    private Set<ScienceBranchDto> scienceBranches;
}