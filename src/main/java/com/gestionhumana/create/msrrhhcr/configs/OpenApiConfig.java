package com.gestionhumana.create.msrrhhcr.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API Productos",
                version = "1.0.0",
                description = "API crud para los productos"
        )
)
public class OpenApiConfig {
}
