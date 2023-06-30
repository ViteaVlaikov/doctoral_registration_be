package usm.api.doctoral_registration.service.order;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import usm.api.doctoral_registration.dto.order.OrderTypeDto;
import usm.api.doctoral_registration.mapper.order.OrderTypeMapper;
import usm.api.doctoral_registration.model.order.OrderType;
import usm.api.doctoral_registration.repository.order.OrderTypeRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static usm.api.doctoral_registration.util.test.TestUtils.ORDER_TYPE_DTO_FULL;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @MockBean
    private OrderTypeRepository orderTypeRepository;

    @MockBean
    private OrderTypeMapper orderTypeMapper;

    @Test
    void testFindAllOrderTypes() {
        OrderTypeDto orderTypeDto1 = ORDER_TYPE_DTO_FULL;
        List<OrderTypeDto> expectedOrderTypes = List.of(orderTypeDto1);

        when(orderTypeRepository.findAll()).thenReturn(List.of(new OrderType()));
        when(orderTypeMapper.toDto(Mockito.any())).thenReturn(orderTypeDto1);

        List<OrderTypeDto> actualOrderTypes = orderService.findAllOrderTypes();

        assertEquals(expectedOrderTypes, actualOrderTypes);
    }
}
