package com.ataha.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.ataha.department.model.Department;
import com.ataha.department.repository.DepartmentRepository;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient
@EnableSwagger2
@EnableFeignClients
@SpringBootApplication
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

	@Bean
	public Docket personApi() {

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.ataha.department.controller"))
					.paths(PathSelectors.any())
				.build();
	}

	@Bean
	public DepartmentRepository repository() {

		DepartmentRepository repository = new DepartmentRepository();

		repository.add(new Department(1L, 1L, "Development", null));
		repository.add(new Department(2L, 1L, "Operations", null));
		repository.add(new Department(3L, 2L, "Development", null));
		repository.add(new Department(4L, 2L, "Operations", null));

		return repository;
	}
}
