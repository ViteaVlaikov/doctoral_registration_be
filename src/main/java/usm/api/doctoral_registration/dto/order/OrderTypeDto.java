package usm.api.doctoral_registration.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import usm.api.doctoral_registration.model.order.OrderSubtype;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderTypeDto {

    private Integer id;

    private String order;

    private List<OrderSubtypeDto> orderSubtypes;
}
