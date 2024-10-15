package com.example.socialmedia.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;


@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(
                DocumentationType.SWAGGER_2
        ).apiInfo(getInfo())
                .securitySchemes(Collections.emptyList())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tutorial"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getInfo() {
        Contact contact = new Contact(
                "Atharva",
                "https://www.linkedin.com/in/atharva-gawande-8a8a4427b/",
                "atharvagawande19@gmail.com"
        );
        return new ApiInfo(
                "Social Media",
                "This is Tutorial project",
                "1.0",
                "Terms of Service",
                contact,
                "License",
                "License URL",
                Collections.emptyList()
        );
    }
}