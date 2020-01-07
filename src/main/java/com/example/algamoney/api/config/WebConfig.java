package com.example.algamoney.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings( CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200","http://todospodemprogramar.com.br:82",
                        "http://todospodemprogramar.com.br:82/**")
                .allowedMethods("POST", "PUT", "OPTIONS", "PUT", "DELETE","GET" )
                .allowCredentials(false).maxAge(3600);
    }
}