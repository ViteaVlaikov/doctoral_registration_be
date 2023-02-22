package usm.api.doctoral_registration.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usm.api.doctoral_registration.dto.order.OrderTypeDto;
import usm.api.doctoral_registration.service.order.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/orders")
@CrossOrigin(origins = {"http://localhost:3000"})
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/types")
    public ResponseEntity<List<OrderTypeDto>> getOrderTypes() {
        return ResponseEntity.ok(orderService.findAllOrderTypes());
    }
}
