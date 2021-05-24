package com.telecomm.inventory;

import com.netflix.discovery.EurekaClient;
import com.telecomm.inventory.domain.Tower;
import com.telecomm.inventory.domain.TowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;


@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApp.class, args);
    }

    @Autowired
    @Lazy
    private EurekaClient eurekaClient;



    @Bean
    ApplicationRunner init(TowerRepository repository) {
        return args -> {
            repository.save(new Tower("att", "Dallas", 1231234231, true));
            repository.save(new Tower("att", "Dallas", 1231234232, true));
            repository.save(new Tower("att", "Dallas", 1231234233, true));
            repository.save(new Tower("att", "Minneapolis", 1231234234, true));
            repository.save(new Tower("att", "Minneapolis", 1231234235, true));
            repository.save(new Tower("vz", "Minneapolis", 1231234236, true));
            repository.save(new Tower("vz", "Minneapolis", 1231234237, true));
            repository.save(new Tower("vz", "Austin", 1231234238, true));
            repository.save(new Tower("vz", "Cleveland", 1231234239, true));
            repository.save(new Tower("t-mobile", "Cleveland", 12312342330d, true));
            repository.findAll().forEach(System.out::println);
        };
    }

}
