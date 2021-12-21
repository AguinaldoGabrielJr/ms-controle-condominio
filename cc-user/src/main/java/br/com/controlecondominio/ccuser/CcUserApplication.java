package br.com.controlecondominio.ccuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CcUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CcUserApplication.class, args);
	}

}

