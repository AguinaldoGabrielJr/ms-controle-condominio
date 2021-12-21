package br.com.controlecondominio.cceurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CcEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CcEurekaServerApplication.class, args);
	}

}
