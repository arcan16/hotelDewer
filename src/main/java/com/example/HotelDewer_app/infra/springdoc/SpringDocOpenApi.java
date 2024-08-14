package com.example.HotelDewer_app.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SpringDocOpenApi {

    @Bean
    OpenAPI customeOpenAPI(){
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("bearer-key",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JJWT")))
                .info(new Info().title("HOTEL DEWER API").description("API REST para HOTEL DEWER")
                        .contact(new Contact().name("Backend Hotel Dewer").email("backend@email.com"))
                        .license(new License().name("apache 2.0").url("http://hotel-dewer.com/license")));
    }
}
