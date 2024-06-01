package br.com.ramen_go;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RamenGoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RamenGoApplication.class, args);
	}

}
