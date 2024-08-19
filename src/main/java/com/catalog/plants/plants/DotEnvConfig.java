package com.catalog.plants.plants;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.cdimascio.dotenv.Dotenv;

@Configuration
public class DotEnvConfig {

    @Bean
    public Dotenv dotenv(){
        return Dotenv.configure().load();
    }

}
