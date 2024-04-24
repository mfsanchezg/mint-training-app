package com.mintsoftwaresystems;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="MINT Software Training App"))
public class TrainingOrganizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingOrganizationApplication.class, args);
	}

}
