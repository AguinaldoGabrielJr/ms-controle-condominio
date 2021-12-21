package br.com.controlecondominio.ccapigatewayzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class CcApiGatewayZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(CcApiGatewayZuulApplication.class, args);
	}

}
