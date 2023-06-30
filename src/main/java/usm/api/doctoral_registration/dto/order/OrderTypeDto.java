package usm.api.doctoral_registration.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * A DTO for the {@link usm.api.doctoral_registration.model.order.OrderType} entity
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderTypeDto {

    private Integer id;

    private String order;

    private List<OrderSubtypeDto> orderSubtypes;
}
