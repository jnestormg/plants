package com.catalog.plants.plants;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.cdimascio.dotenv.Dotenv;

@Configuration
public class DotEnvConfig {

    @Bean
    public Dotenv dotenv() {
        try {
            return Dotenv.load();
        } catch (Exception e) {
            // Maneja la excepción aquí, o utiliza valores por defecto
            return Dotenv.configure().ignoreIfMissing().load();
        }
    }

}
