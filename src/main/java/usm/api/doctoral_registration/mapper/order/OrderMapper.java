package usm.api.doctoral_registration.mapper.order;

import org.mapstruct.Mapper;
import usm.api.doctoral_registration.dto.order.OrderDto;
import usm.api.doctoral_registration.mapper.EntityMapper;
import usm.api.doctoral_registration.model.order.Order;

@Mapper
public interface OrderMapper extends EntityMapper<Order, OrderDto> {

}
