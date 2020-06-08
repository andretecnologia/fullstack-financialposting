package com.example.algamoney.api.config.property;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("algamoney")
public class AlgamoneyApiProperty {

    private String originPermitida = "http://localhost";
}
