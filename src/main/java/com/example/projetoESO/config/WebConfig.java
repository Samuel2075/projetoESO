package com.example.projetoESO.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                //.allowedOrigins("https://pokedexprojetoeso.netlify.app")
                .allowedOrigins("http://localhost:3000") // Permite a origem do seu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                .allowedHeaders("Authorization", "Content-Type") // Cabeçalhos permitidos
                .allowCredentials(true);

    }
}
