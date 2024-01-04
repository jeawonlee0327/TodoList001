package com.teamsparta.todolist.infra.swagger

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    class SwaggerConfig {

        @Bean
        fun openAPI(): OpenAPI = OpenAPI()
            .components(Components())
            .info(
                Info()
                    .title("Todo-List API")
                    .description("Course API schema")
                    .version("1.0.0")
            )
    }
}

// SwaggerConfig.kt