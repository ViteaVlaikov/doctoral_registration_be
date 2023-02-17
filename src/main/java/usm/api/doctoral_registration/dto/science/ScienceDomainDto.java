package usm.api.doctoral_registration.dto.science;

import lombok.Data;
import usm.api.doctoral_registration.dto.science.ScienceBranchDto;
import usm.api.doctoral_registration.model.science.ScienceSchool;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link usm.api.doctoral_registration.model.science.ScienceDomain} entity
 */
@Data
public class ScienceDomainDto implements Serializable {
    private final Integer id;
    private final Integer number;
    private final String name;
    private final ScienceSchool scienceSchool;
    private final Set<ScienceBranchDto> scienceBranches;
}