package com.example.paiementservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@OpenAPIDefinition(info =
@Info(title = "Paiement  API", version = "1.0", description = "Documentation Paiement  API v1.0")
)
public class PaiementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaiementServiceApplication.class, args);
    }

}
