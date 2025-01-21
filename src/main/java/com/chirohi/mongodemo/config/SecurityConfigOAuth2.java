//package com.chirohi.mongodemo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfigOAuth2 {
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity
//				.authorizeHttpRequests(auth -> {
//					try {
//                        auth.requestMatchers("/").permitAll() // Permit all access to
//                                .anyRequest()
//                                .authenticated();
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				});
//			http.oauth2Login(Customizer.withDefaults());
//			http.formLogin(Customizer.withDefaults());
//		return http.build();
//	}
//
//}
