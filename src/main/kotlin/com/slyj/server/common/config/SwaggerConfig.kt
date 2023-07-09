package com.slyj.server.common.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
@Configuration
@OpenAPIDefinition
class SwaggerConfig {

    @Bean
    fun swagger(): OpenAPI {
        /*return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.ant("/v1/**"))
            .build()
            .apiInfo(apiInfo())
            */
         */
        return OpenAPI()
            .info(
                Info()
                    .title("Seungliyojeong API")
                    .version("v1")
            )
    }

}