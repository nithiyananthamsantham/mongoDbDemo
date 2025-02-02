package com.chirohi.mongodemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
//                .allowedHeaders("Content-Type", "accept", "Origin", "Access-Control-Request-Method",
//                        "Access-Control-Request-Headers")
                .exposedHeaders("Access-Control-Allow-Origin", "*");
    }
}