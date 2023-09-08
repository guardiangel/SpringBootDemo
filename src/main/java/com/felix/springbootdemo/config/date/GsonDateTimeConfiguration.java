package com.felix.springbootdemo.config.date;

import com.felix.springbootdemo.config.date.adapter.GsonLocalDateTime;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.autoconfigure.gson.GsonBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration(value = "gsonDateTimeConfiguration")
public class GsonDateTimeConfiguration {
    @Bean(value = "typeAdapterRegistration")
    public Gson typeAdapterRegistration() {
       return  new GsonBuilder().setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class, new GsonLocalDateTime())
                .create();
       /* return builder -> {
            builder.setPrettyPrinting()
                    .registerTypeAdapter(LocalDateTime.class, new GsonLocalDateTime())
                    .create();
        };*/
    }
}
