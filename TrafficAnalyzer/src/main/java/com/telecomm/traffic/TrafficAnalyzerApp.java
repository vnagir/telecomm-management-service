package com.telecomm.traffic;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class TrafficAnalyzerApp {
    private static final ObjectMapper mapper = new ObjectMapper();

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }



    public static void main(String[] args) {
        SpringApplication.run(TrafficAnalyzerApp.class, args);
    }


}
