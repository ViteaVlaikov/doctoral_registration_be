package usm.api.doctoral_registration.mapper.order;

import org.mapstruct.Mapper;
import usm.api.doctoral_registration.dto.order.OrderTypeDto;
import usm.api.doctoral_registration.mapper.EntityMapper;
import usm.api.doctoral_registration.model.order.OrderType;

@Mapper(uses = {OrderSubtypeMapper.class})
public interface OrderTypeMapper extends EntityMapper<OrderType, OrderTypeDto> {

}
