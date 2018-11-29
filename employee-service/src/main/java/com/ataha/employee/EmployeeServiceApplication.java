package com.ataha.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.ataha.employee.model.Employee;
import com.ataha.employee.repository.EmployeeRepository;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient
@EnableSwagger2
@SpringBootApplication
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

	@Bean
	public Docket personApi() {

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.ataha.employee.controller"))
					.paths(PathSelectors.any())
				.build();
	}
	
	@Bean
	public EmployeeRepository getEmployeeRepository() {
		EmployeeRepository repository = new EmployeeRepository();
		
		repository.add(new Employee(1L, 1L, 1L, "Slavomir Shaima", 34, "Analyst"));
		repository.add(new Employee(2L, 1L, 1L, "Gunnar Mohammed", 37, "Manager"));
		repository.add(new Employee(3L, 1L, 1L, "Shyamala Charlotte", 26, "Developer"));
		repository.add(new Employee(4L, 1L, 2L, "Ambrosios Asa", 39, "Analyst"));		
		repository.add(new Employee(5L, 1L, 2L, "Anara Angie", 27, "Developer"));
		repository.add(new Employee(6L, 2L, 3L, "Kevin Price", 38, "Developer"));		
		repository.add(new Employee(7L, 2L, 3L, "Ian Scott", 34, "Developer"));
		repository.add(new Employee(8L, 2L, 3L, "Andrew Campton", 30, "Manager"));
		repository.add(new Employee(9L, 2L, 4L, "Steve Franklin", 25, "Developer"));
		repository.add(new Employee(10L, 2L, 4L, "Elisabeth Smith", 30, "Developer"));
		
		return repository;
	}
}
