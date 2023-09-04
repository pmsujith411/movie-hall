package com.example.demo.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpeAPI configuration
 */
@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI myOpenAPI() {
        Info info = new Info()
                .title("Movie Hall Application APIs")
                .version("1.0")
                .description("This API exposes endpoints to manage Movie Hall Application.");

        return new OpenAPI().info(info);
    }
}
