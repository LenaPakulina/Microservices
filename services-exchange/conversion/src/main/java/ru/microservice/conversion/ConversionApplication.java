package ru.microservice.conversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication
@EnableFeignClients(basePackages = "ru.microservice.conversion.service")
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class ConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConversionApplication.class, args);
	}

}
