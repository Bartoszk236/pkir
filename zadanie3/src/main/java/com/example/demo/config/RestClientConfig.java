package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient openWeatherRestClient(
            @Value("${openweather.base-url}") String baseUrl,
            @Value("${openweather.api-key}") String apiKey
    ) {
        return RestClient.builder()
                .baseUrl(baseUrl)
                .defaultUriVariables(Map.of("appid", apiKey))
                .build();
    }
}
