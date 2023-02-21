package usm.api.doctoral_registration.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usm.api.doctoral_registration.dto.order.OrderTypeDto;
import usm.api.doctoral_registration.model.order.OrderType;
import usm.api.doctoral_registration.repository.order.OrderTypeRepository;
import usm.api.doctoral_registration.service.order.OrderService;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequiredArgsConstructor
@RequestMapping("api/order")
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/types")
    public ResponseEntity<List<OrderTypeDto>> getOrderTypes() {
        return ResponseEntity.ok(orderService.findAllOrderTypes());
    }
}
