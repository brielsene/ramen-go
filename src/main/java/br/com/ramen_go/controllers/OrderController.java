package br.com.ramen_go.controllers;

import br.com.ramen_go.dtos.OrderRequestDto;
import br.com.ramen_go.dtos.OrderRequestMapperDto;
import br.com.ramen_go.dtos.OrderResponseDto;
import br.com.ramen_go.services.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/order")
@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<OrderResponseDto>createOrder(@RequestBody String body) throws JsonProcessingException {
        OrderRequestMapperDto dto;

        if (body.startsWith("{")) {
            // Assume JSON
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                dto = objectMapper.readValue(body, OrderRequestMapperDto.class);
            } catch (JsonProcessingException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        } else {
            // Handle text/plain, you can add more complex logic here if needed
            return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(null);
        }

        return ResponseEntity.ok(this.orderService.createOrder(dto));
    }

}
