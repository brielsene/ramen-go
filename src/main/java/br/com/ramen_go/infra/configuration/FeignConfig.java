package br.com.ramen_go.infra.configuration;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Value("${api.key}")
    private String apiKey;
    @Bean
    public RequestInterceptor requestInterceptor(){
        return requestTemplate -> {
            System.out.println("Adicionando x-api-key:"+apiKey);
          requestTemplate.header("x-api-key", apiKey);
        };
    }
}
