package com.felix.springbootdemo.config.swagger2;

import io.swagger.models.auth.In;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    //default url http://127.0.0.1:port/swagger-ui.html
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // Use Swagger
                .enable(true)
                // Create base info for API
                .apiInfo(apiInfo())
                // Set which interfaces can be used for swagger
                .select()
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))//Scan all annotations
                //.apis(RequestHandlerSelectors.any())//Scan all
                .apis(RequestHandlerSelectors.basePackage("com.felix.springbootdemo.controller"))//Scan specific package
                .paths(PathSelectors.any())
                .build()
                /* Set security mode，swagger set token */
                .securitySchemes(securitySchemes());
    }

    /**
     * Pass token via headers
     *
     * @return
     */
    private List<SecurityScheme> securitySchemes() {
        List<SecurityScheme> apiKeyList = new ArrayList<SecurityScheme>();
        apiKeyList.add(new ApiKey("token", "token", In.HEADER.toValue()));
        return apiKeyList;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // Set title
                .title("Title：SprintBootDemo interface document")
                // Desc
                .description("Description: interface document")
                // Author info
                .contact(new Contact("Felix", null, "SpringBootDemoApplication@xxxx.com"))
                // Version
                .version("Version:1.0.0")
                .build();
    }
}
