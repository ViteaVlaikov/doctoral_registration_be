package usm.api.doctoral_registration.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link usm.api.doctoral_registration.model.order.OrderSubtype} entity
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderSubtypeDto {

    private Integer id;

    private String order;

    private Integer orderTypeId;
}
