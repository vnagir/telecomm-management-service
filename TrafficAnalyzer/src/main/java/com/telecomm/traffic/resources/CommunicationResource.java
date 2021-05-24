package com.telecomm.traffic.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.telecomm.traffic.domain.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class CommunicationResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommunicationResource.class);
    private static final ObjectMapper mapper = new ObjectMapper();
    @Value("${allow.device.ios:2}")
    private String allowIos;

    @Value("${block.device.android:2}")
    private String blockAndroid;

    @Value("${allow.device.android}")
    private String allowAndroid;

    @Value("${block.device.ios}")
    private String blockIos;

    @Value("${spring.client.name}")
    private String appName;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;


    @GetMapping(value = "/towers", produces ={"application/json"})
    public Response getAllActiveTowers() {
        System.out.println("Whitelist/Allow ios device traffic on these towers:  " + allowIos);
        System.out.println("Blocking ios device traffic on these towers:  "+blockIos);
        System.out.println("Whitelist/Allow android device traffic on these towers:"+allowAndroid);
        System.out.println("Blocking android device traffic on these towers:  "+blockAndroid);
        Application inventoryApp  =  eurekaClient.getApplication(appName);
        System.out.println(inventoryApp.getName());
        InstanceInfo instanceInfo = inventoryApp.getInstances().get(0);
        System.out.println(instanceInfo.getIPAddr() + instanceInfo.getPort());
        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "manager/tower/get-all";
        RestTemplate template = new RestTemplate();
        LOGGER.info("Fetching all active towers to start filtering.");
        Response response = template.getForObject(url, Response.class);
        LOGGER.info(""+ response.getTowers());
        return response;
    }


}
