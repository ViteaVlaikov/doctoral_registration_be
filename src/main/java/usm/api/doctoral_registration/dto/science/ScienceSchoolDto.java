package usm.api.doctoral_registration.dto.science;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import usm.api.doctoral_registration.dto.science.ScienceDomainDto;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link usm.api.doctoral_registration.model.science.ScienceSchool} entity
 */
@Data
@Builder
@AllArgsConstructor
public class ScienceSchoolDto implements Serializable {
    private final Integer id;
    private final String name;
    private final Set<ScienceDomainDto> scienceDomains;

    @Override
    public String toString() {
        return "id='" + id + "'" +
                ", name='" + name + "'";
    }
}