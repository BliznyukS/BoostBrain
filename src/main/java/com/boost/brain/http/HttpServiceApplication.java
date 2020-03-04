package com.boost.brain.http;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@SpringBootApplication
public class HttpServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttpServiceApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                //.useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.boost.brain.http"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("BoostBrain tools service")
                .description("BoostBrain tools service")
                .version("0.1")
                .build();
    }
}
