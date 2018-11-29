package com.ataha.organization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.ataha.organization.model.Organization;
import com.ataha.organization.repository.OrganizationRepository;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient
@EnableSwagger2
@EnableFeignClients
@SpringBootApplication
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

	@Bean
	public Docket personApi() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ataha.organization.controller"))
				.paths(PathSelectors.any()).build();
	}

	@Bean
	public OrganizationRepository repository() {
		
		OrganizationRepository repository = new OrganizationRepository();
		
		repository.add(new Organization(1L, "Microsoft", "Redmond, Washington, USA", null, null));
		repository.add(new Organization(2L, "Oracle", "Redwood City, California, USA", null, null));
		
		return repository;
	}
}
