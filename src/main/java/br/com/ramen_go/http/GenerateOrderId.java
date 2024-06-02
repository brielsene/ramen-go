package br.com.ramen_go.http;


import br.com.ramen_go.configuration.FeignConfig;
import br.com.ramen_go.dtos.OrderIdGenerateDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "ramen-go-generate-id", url = "https://api.tech.redventures.com.br", configuration = FeignConfig.class)
public interface GenerateOrderId {




    @PostMapping("/orders/generate-id")
    OrderIdGenerateDto orderIdGenerateDto();
}
