package com.unicorn.rental.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Car rental API",
                version = "1.0",
                description = "This is an API for car rental app. It enables to do CRUD operations on car entity, which are avaiable on /api/car, as well as create and list users on /api/user endpoint and create car rentals on /api/carRental endpoint.",
                contact = @Contact(
                    name = "Ludvík Jakub Roubíček",
                    email = "ludvikjakub.roubicek@unicorn.com"
                )
        )
)
public class OpenApiConfig {
}
