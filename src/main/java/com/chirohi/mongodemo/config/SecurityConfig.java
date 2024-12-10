package com.chirohi.mongodemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/signup").permitAll() // Permit all access to /auth/welcome
	               // .requestMatchers("/auth/user/**").authenticated() // Require authentication for /auth/user/**
	               // .requestMatchers("/auth/admin/**").authenticated() // Require authentication for /auth/admin/**
	                .anyRequest().authenticated()
	            );
	           // .formLogin(withDefaults()); // Enable form-based login
	        
	        return http.build();
	    }
	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
