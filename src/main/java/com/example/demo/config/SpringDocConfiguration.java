package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI openAPI(@Value("${springdoc.version}") String springdocVersion) {

        Info info = new Info().title("Swagger Service Title")
                              .version(springdocVersion)
                              .description("Swagger Service Description...");

        return new OpenAPI()
            .info(info);

    }

}
