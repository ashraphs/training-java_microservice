package com.dlt.mbbtraining.mbbmasterdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MbbMasterDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(MbbMasterDataApplication.class, args);
    }

}
