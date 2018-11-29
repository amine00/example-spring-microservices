package com.ataha.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class ApiGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayServiceApplication.class, args);
	}
	
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		
		//@formatter:off
		return builder.routes()
				
					.route("employee-service", r -> r.path("/employee/**")
							.filters(f -> f.rewritePath("/employee/(?<path>.*)",
									"/$\\{path}"))
							.uri("lb://employee-service")
					)
					
					.route("department-service", r -> r.path("/department/**")
							.filters(f -> f.rewritePath("/department/(?<path>.*)",
									"/$\\{path}"))
							.uri("lb://department-service")
					)
					
					.route("organization-service", r -> r.path("/organization/**")
							.filters(f -> f.rewritePath("/organization/(?<path>.*)",
									"/$\\{path}"))
							.uri("lb://organization-service")
					)
					
					.build();
		//@formatter:on
	}
}
