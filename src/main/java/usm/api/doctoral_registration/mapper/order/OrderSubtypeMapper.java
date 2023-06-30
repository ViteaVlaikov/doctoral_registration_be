package usm.api.doctoral_registration.mapper.order;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import usm.api.doctoral_registration.dto.order.OrderSubtypeDto;
import usm.api.doctoral_registration.mapper.EntityMapper;
import usm.api.doctoral_registration.model.order.OrderSubtype;

@Mapper
public interface OrderSubtypeMapper extends EntityMapper<OrderSubtype, OrderSubtypeDto> {

    @Override
    @Mapping(target = "orderType.id", source = "orderTypeId")
    OrderSubtype toEntity(OrderSubtypeDto orderSubtypeDto);

    @Override
    @Mapping(source = "orderType.id", target = "orderTypeId")
    OrderSubtypeDto toDto(OrderSubtype orderType);
}
