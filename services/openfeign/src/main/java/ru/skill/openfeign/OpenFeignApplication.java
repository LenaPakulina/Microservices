package ru.skill.openfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication
@EnableFeignClients(basePackages = "ru.skill.openfeign.service")
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class OpenFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenFeignApplication.class, args);
	}
}
