package com.telecomm.traffic;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
@EnableDiscoveryClient
public class TrafficAnalyzerApp {
    private static final ObjectMapper mapper = new ObjectMapper();

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WebClient.Builder getWebClientBuilder() {
        return WebClient.builder();
    }

    public static void main(String[] args) {
        SpringApplication.run(TrafficAnalyzerApp.class, args);
    }


}
