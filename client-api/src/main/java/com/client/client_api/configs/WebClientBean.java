package com.client.client_api.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientBean {
    @Value("${getendpoint}")
    private String getEndPoint;

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl(getEndPoint).build();
    }
}
