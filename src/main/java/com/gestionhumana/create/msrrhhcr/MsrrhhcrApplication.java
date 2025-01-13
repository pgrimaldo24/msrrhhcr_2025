package com.gestionhumana.create.msrrhhcr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsrrhhcrApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsrrhhcrApplication.class, args);
	}

}
