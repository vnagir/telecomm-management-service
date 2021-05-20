package com.telecomm.traffic.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telecomm.traffic.domain.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class CommunicationResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommunicationResource.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    @Value("{allow.device.ios}")
    private int[] allow_ios;
    @Value("{block.device.ios}")
    private int[] block_ios;
    @Value("{allow.device.android}")
    private int[] allow_android;
    @Value("{block.device.android}")
    private int[] block_android;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/towers")
    public Response getAllActiveTowers() {
        LOGGER.info("Ios cell o=phones are allowed on-- {} \n Blocking andoind cell phones on --{}", allow_ios, block_android);
        RestTemplate template = new RestTemplate();
        LOGGER.info("Fetching all active towers to start filtering.");
        Response response = template.getForObject("http://inventory-service/manager/tower/get-all", Response.class);
        return response;
    }


}
