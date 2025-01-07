package com.chirohi.mongodemo.postgres.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.chirohi.mongodemo.postgres.entity.UserAccounts;
import com.chirohi.mongodemo.postgres.entity.UserDetail;
import com.chirohi.mongodemo.postgres.model.UserAccountsDto;
import com.chirohi.mongodemo.postgres.service.AppUserServiceDetailService;
import com.chirohi.mongodemo.postgres.service.JWTAuthenticateService;
import com.chirohi.mongodemo.postgres.service.UserService;

import javassist.NotFoundException;


@RestController
public class SignupController 
{
//	@Autowired
//	private UserService userService;
	
	@Autowired
	private AppUserServiceDetailService userService;
	
	@Value("${hotel.app.provider.url}")
	String providerUrl;
	
	@Autowired
	WebClient webClientBuilder;
	
	@Autowired
	JWTAuthenticateService authService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	@PostMapping("/signup")
	public ResponseEntity<Object> signup(@RequestBody UserAccountsDto signupRequest)
	{
		userService.signupUser(signupRequest);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	
	@PostMapping("/signUpGitUrl")
	public ResponseEntity<String> signupGit(@RequestBody UserAccountsDto signupRequest)
	{
		return ResponseEntity.ok(webClientBuilder
				.post()
				.uri(providerUrl)
				.bodyValue(signupRequest)
				.retrieve()
				.bodyToMono(String.class)
				.block());
	}
	
	@PostMapping("/loginAndGetToken")
	  public ResponseEntity<LoginResponse> loginAndGetToken(@RequestBody LoginRequest request) throws NotFoundException {
		String token = "";		
		
		Optional<UserDetail> userAccount = userService.getUserByEmail(request.getusername());
		
		if(encoder.matches(request.getPassword(), userAccount.get().getPassword())) {
			
			token = authService.generateToken(request.getusername());
			
		}
		
	    return ResponseEntity.ok(new LoginResponse(request.getusername(), token));
	  }
}
