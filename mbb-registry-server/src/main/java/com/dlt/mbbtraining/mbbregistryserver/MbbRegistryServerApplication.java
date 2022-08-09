package com.dlt.mbbtraining.mbbregistryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MbbRegistryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbbRegistryServerApplication.class, args);
	}

}
