package usm.api.doctoral_registration.dto.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

/**
 * A DTO for the {@link usm.api.doctoral_registration.model.order.Order} entity
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Integer id;

    private String number;

    private LocalDate date;

    private Integer orderSubtypeId;

    private String orderSubtype;

    private Integer orderTypeId;

    private String orderType;
}
