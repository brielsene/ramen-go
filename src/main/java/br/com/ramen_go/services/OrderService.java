package br.com.ramen_go.services;

import br.com.ramen_go.dtos.OrderIdGenerateDto;
import br.com.ramen_go.dtos.OrderRequestDto;
import br.com.ramen_go.dtos.OrderResponseDto;
import br.com.ramen_go.http.GenerateOrderId;
import br.com.ramen_go.model.Broth;
import br.com.ramen_go.model.Order;
import br.com.ramen_go.model.Protein;
import br.com.ramen_go.repositories.BrothRepository;
import br.com.ramen_go.repositories.OrderRepository;
import br.com.ramen_go.repositories.ProteinRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class OrderService {
    @Value("${api.key}")
    private String apiKey;
    private final OrderRepository repository;
    private final BrothRepository brothRepository;
    private final ProteinRepository proteinRepository;

    private final GenerateOrderId generateOrderId;

    public OrderService(OrderRepository repository, BrothRepository brothRepository, ProteinRepository proteinRepository, GenerateOrderId generateOrderId) {
        this.repository = repository;
        this.brothRepository = brothRepository;
        this.proteinRepository = proteinRepository;
        this.generateOrderId = generateOrderId;
    }

    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto){
        Broth broth = brothRepository.findById(orderRequestDto.brothId()).orElseThrow(
                () -> new NoSuchElementException("")
        );
        Protein protein = proteinRepository.findById(orderRequestDto.proteinId()).orElseThrow(
                () -> new NoSuchElementException()
        );

        Order order = new Order(Long.parseLong(this.generateOrderId.orderIdGenerateDto().orderId()), protein.getName()+" and "+broth.getName(), "https://tech.redventures.com.br/icons/ramen/ramenChasu.png");
        repository.save(order);
        OrderResponseDto orderResponseDto = new OrderResponseDto(order.getId(), order.getDescrption(), order.getImage());
        return orderResponseDto;
    }


}
