package usm.api.doctoral_registration.dto.science;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import usm.api.doctoral_registration.dto.science.ScienceBranchDto;
import usm.api.doctoral_registration.model.science.ScienceSchool;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link usm.api.doctoral_registration.model.science.ScienceDomain} entity
 */
@Data
@Builder
@AllArgsConstructor
public class ScienceDomainDto implements Serializable {
    private final Long id;
    private final Integer number;
    private final String name;
    private final Long scienceSchoolId;
//    private final ScienceSchoolDto scienceSchool;
    @ToString.Exclude
    private final Set<ScienceBranchDto> scienceBranches;
}