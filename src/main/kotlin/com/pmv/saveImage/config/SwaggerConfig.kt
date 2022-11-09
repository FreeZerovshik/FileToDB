package com.pmv.saveImage.config

import io.swagger.annotations.Api
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.*
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.service.contexts.SecurityContext
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConfig {


    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.withClassAnnotation(Api::class.java))
            .build()
            .apiInfo(metaData())
    }

    protected fun metaData(): ApiInfo {
        return ApiInfo(
            "Rest parser api ",
            "API сохранение файла в БД",
            "1.0.1",
            "Terms of service",
            Contact("Me", "", "matvei.popchenko@gmail.com"),
            "License of API", "", emptyList()
        )
    }
}