package com.chirohi.mongodemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.reactive.function.client.WebClient;

import com.chirohi.mongodemo.filter.JwtAuthenticationFilter;
import com.chirohi.mongodemo.postgres.repository.AppUserAccountRepository;

@Configuration
public class ApplicationConfiguration {
	
    private final AppUserAccountRepository userRepository;

    public ApplicationConfiguration(AppUserAccountRepository userRepository) {
        this.userRepository = userRepository;
    }
    
	   @Bean
	    UserDetailsService userDetailsService() {
	        return username -> userRepository.findByEmail(username)
	                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
	    }

	    @Bean
	    BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
	        return config.getAuthenticationManager();
	    }

	    @Bean
	    AuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(passwordEncoder());

	        return authProvider;
	    }
	    
		@Bean
		public WebClient getWebClient(){
			return WebClient.builder().build();
		}
		
	  @Bean
	  public JwtAuthenticationFilter jwtAuthenticationFilter() {
	      return new JwtAuthenticationFilter();
	  }
}
