package com.example.fiscal.infra.configs

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.SpecVersion
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import org.springframework.beans.factory.annotation.Configurable
import org.springframework.context.annotation.Bean


@Configurable
class Swagger {

    @Bean
    fun openApi(): OpenAPI {
        return OpenAPI(SpecVersion.V31)
            .components(
                Components()
            )
            .info(Info().title("Fiscal API").version("v1.0").contact(Contact().name("Desenvolvimento")))
    }
}