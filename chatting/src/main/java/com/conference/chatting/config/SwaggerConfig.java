package com.conference.chatting.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableAutoConfiguration
public class SwaggerConfig {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.conference.chatting"))
                .paths(PathSelectors.any())
                .build();

    }

    // API Document를 생성해 주는 라이브러리입니다.
    // http://localhost:8080/swagger-ui.html#/ 페이지에 접속하여 확인 가능합니다.
    // controller에 apiResponse를 세부적으로 적용이 가능합니다.

}