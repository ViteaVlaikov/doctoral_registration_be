package usm.api.doctoral_registration.dto.science;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link usm.api.doctoral_registration.model.science.ScienceSchool} entity
 */
@Data
@Builder
@AllArgsConstructor
public class ScienceSchoolDto implements Serializable {

    private final Long id;

    private final String name;
}