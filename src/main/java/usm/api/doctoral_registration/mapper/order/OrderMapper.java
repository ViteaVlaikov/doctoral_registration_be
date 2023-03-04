package usm.api.doctoral_registration.mapper.order;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import usm.api.doctoral_registration.dto.order.OrderDto;
import usm.api.doctoral_registration.mapper.EntityMapper;
import usm.api.doctoral_registration.model.order.Order;

@Mapper
public interface OrderMapper extends EntityMapper<Order, OrderDto> {

    @Override
    @Mapping(source = "orderSubtype.id", target = "orderSubtypeId")
    @Mapping(source = "orderSubtype.order", target = "orderSubtype")
    @Mapping(source = "orderSubtype.orderType.id", target = "orderTypeId")
    @Mapping(source = "orderSubtype.orderType.order", target = "orderType")
    OrderDto toDto(Order order);

    @Override
    @Mapping(target = "orderSubtype.id", source = "orderSubtypeId")
    @Mapping(target = "orderSubtype.order", source = "orderSubtype")
    @Mapping(target = "orderSubtype.orderType.id", source = "orderTypeId")
    @Mapping(target = "orderSubtype.orderType.order", source = "orderType")
    Order toEntity(OrderDto orderDto);
}
