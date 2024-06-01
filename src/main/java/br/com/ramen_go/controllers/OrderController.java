package br.com.ramen_go.controllers;

import br.com.ramen_go.dtos.OrderRequestDto;
import br.com.ramen_go.dtos.OrderResponseDto;
import br.com.ramen_go.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/orders")
@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDto>createOrder(@RequestBody OrderRequestDto dto){
        return ResponseEntity.ok(this.orderService.createOrder(dto));
    }

}
