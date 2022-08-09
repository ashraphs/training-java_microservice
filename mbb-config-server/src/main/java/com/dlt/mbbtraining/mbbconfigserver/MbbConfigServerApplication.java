package com.dlt.mbbtraining.mbbconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigServer
@SpringBootApplication
public class MbbConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbbConfigServerApplication.class, args);
	}

}
