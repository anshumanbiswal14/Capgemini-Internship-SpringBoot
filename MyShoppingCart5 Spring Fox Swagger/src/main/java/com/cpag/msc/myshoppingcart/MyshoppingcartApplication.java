package com.cpag.msc.myshoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Configuration
public class MyshoppingcartApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyshoppingcartApplication.class, args);
	}

	
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().build();
		
	}
	
	private ApiInfo apiInfo() {
		
		return new ApiInfoBuilder().title("My Laptop Inventory").description("All types of Laptop can be stored at one place")
				.version("myshoppingcartApp Version1.0").build();
	}
}