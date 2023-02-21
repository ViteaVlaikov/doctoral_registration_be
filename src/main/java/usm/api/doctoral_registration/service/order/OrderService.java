package usm.api.doctoral_registration.service.order;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.dto.order.OrderTypeDto;
import usm.api.doctoral_registration.mapper.order.OrderTypeMapper;
import usm.api.doctoral_registration.repository.order.OrderTypeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderTypeRepository orderTypeRepository;

    private final OrderTypeMapper orderTypeMapper;

    public List<OrderTypeDto> findAllOrderTypes() {
        return orderTypeRepository.findAll().stream()
                .map(orderTypeMapper::toDto).toList();
    }
}
