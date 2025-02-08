package com.chirohi.mongodemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.chirohi.mongodemo.filter.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	   private final AuthenticationProvider authenticationProvider;
	    private final JwtAuthenticationFilter jwtAuthenticationFilter;

	    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter, AuthenticationProvider authenticationProvider) {
	        this.authenticationProvider = authenticationProvider;
	        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
	    }
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
		.cors(cors -> cors.disable())// Disable CSRF for simplicity
				.authorizeHttpRequests(auth -> {
					try {
                        auth.requestMatchers("/signup", "/loginAndGetToken","/hello")
                                .permitAll() // Permit all access to
                                .anyRequest()
                                .authenticated()
                                .and()
                                .sessionManagement(management -> management
                                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .authenticationProvider(authenticationProvider)
                                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
			//	.formLogin(Customizer.withDefaults());// Enable form-based login
		return http.build();
	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}


	
//	@Bean
//	public AuthenticationManager getAuthenticationManager(AuthenticationConfiguration congig) throws Exception {
//		return congig.getAuthenticationManager();
//	}
	
//    @Bean
//    AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(passwordEncoder());
//
//        return authProvider;
//    }
    
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new AppUserSerrviceImpl();
//    }
    
    
//    @Bean
//    UserDetail userDetailsService(String userName) {
//    	
//    	if(userDetailsService.loadUserByUsername(userName)!=null) {
//    		return userDetailsService.getUserByEmail(userName).get();
//    	}
//		return null;
//    }
    
//  @Bean
//  public JwtAuthenticationFilter jwtAuthenticationFilter() {
//      return new JwtAuthenticationFilter();
//  }
}
