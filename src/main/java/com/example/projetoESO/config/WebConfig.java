package com.example.projetoESO.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://damp-waters-81236-5574034b183b.herokuapp.com")
                .allowedMethods("GET", "POST")
                .allowedHeaders("*");
    }
}
