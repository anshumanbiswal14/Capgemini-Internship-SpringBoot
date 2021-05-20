package com.capg.zerodhastockbrokerage.zerodhastockapp;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@Configuration
@SpringBootApplication
public class ZerodhastockappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZerodhastockappApplication.class, args);
		System.out.println(" ----->> WORKING (OK!)");
	}
	
	@Bean
	public Docket docket() {
		
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().build();
		
	}
	
	private ApiInfo apiInfo() {
		
		return new ApiInfoBuilder().title("Zerodha Stock Brokerage App")
				.description("Contains APIs for Stock Transactions")
				.version("Zerodha version 1.0").build(); 
	}

}