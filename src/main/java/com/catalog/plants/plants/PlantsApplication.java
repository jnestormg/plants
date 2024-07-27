package com.catalog.plants.plants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PlantsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlantsApplication.class, args);
	}

	@Configuration
	public static class MyConfiguration{

		@Bean
		public WebMvcConfigurer configurer(){
			return new WebMvcConfigurer() {

				public void addCorsMapping(CorsRegistry registry){
					registry.addMapping("/**")
					.allowedMethods("HEAD", "GET", "PUT", "DELETE", "POST", "PATCH");
				}
			};
		}

	}

}
