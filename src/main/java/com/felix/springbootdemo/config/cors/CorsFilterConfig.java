package com.felix.springbootdemo.config.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * cross domain
 */
@Configuration
public class CorsFilterConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //Allow send cookie, get same session when used in cross domain request.
        corsConfiguration.setAllowCredentials(true);
        //Allow all domains
        //When setAllowCredentials is true, we can't use addAllowedOrigin("*")
        //corsConfiguration.addAllowedOrigin("*");
        corsConfiguration
                .setAllowedHeaders(Arrays
                        .asList("Origin", "Content-Type", "Accept", "responseType", "Authorization"));
        //Allowed request methods
        corsConfiguration.addAllowedMethod("OPTIONS");
        corsConfiguration.addAllowedMethod("HEAD");
        corsConfiguration.addAllowedMethod("GET");
        corsConfiguration.addAllowedMethod("PUT");
        corsConfiguration.addAllowedMethod("POST");
        corsConfiguration.addAllowedMethod("DELETE");
        corsConfiguration.addAllowedMethod("PATCH");
        //Allow request header
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.setAllowedOriginPatterns(Arrays.asList("*"));

        //Configure allowed urls, * means all
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsFilter(configSource);
    }
}
