package com.telecomm.traffic.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telecomm.traffic.domain.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


@RestController
public class CommunicationResource {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping("/towers")
    public Response getAllActiveTowers() {
        RestTemplate template = new RestTemplate();
        Response response = template.getForObject("http://inventory-service/manager/tower/get-all", Response.class);
        return response;
    }


}
