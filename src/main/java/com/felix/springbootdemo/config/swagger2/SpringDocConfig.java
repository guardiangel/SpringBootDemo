package com.felix.springbootdemo.config.swagger2;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * As to 20230907,  springfox doesn't work well in SpringBoot3.0,
 * it prompts  javax.servlet.http.HttpServletRequest not present.
 * So we don't use Swagger in this demo
 * Use springdoc-openapi-starter-webmvc-ui for replacement. Guiquan Sun 20230907
 */
@Configuration
public class SpringDocConfig {


    //springdoc default url: http://localhost:8020/v3/api-docs (the port is configured in the application-dev.yml)
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("controllers")
                .pathsToMatch("com.felix.springbootdemo.controller")
//                .pathsToMatch("/public/**")
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("SpringBootDemoApplication API")
                        .description("SpringBootDemo")
                        .version("v0.0.1")
                        .license(new License().name("Felix").url("http://www.google.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringBootDemoApplication Documentation")
                        .url("http://www.google.com"));
    }

}
