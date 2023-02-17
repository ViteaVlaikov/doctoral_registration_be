package usm.api.doctoral_registration.dto.science;

import lombok.Data;
import usm.api.doctoral_registration.dto.science.ScienceDomainDto;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link usm.api.doctoral_registration.model.science.ScienceSchool} entity
 */
@Data
public class ScienceSchoolDto implements Serializable {
    private final Integer id;
    private final String name;
    private final Set<ScienceDomainDto> scienceDomains;
}