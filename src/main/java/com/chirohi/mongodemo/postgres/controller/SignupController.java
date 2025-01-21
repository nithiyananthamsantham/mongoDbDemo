package com.chirohi.mongodemo.postgres.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.chirohi.mongodemo.exception.UserNotFoundException;
import com.chirohi.mongodemo.postgres.entity.UserDetail;
import com.chirohi.mongodemo.postgres.model.UserAccountsDto;
import com.chirohi.mongodemo.postgres.service.AppUserServiceDetailService;
import com.chirohi.mongodemo.postgres.service.JWTAuthenticateService;

import jakarta.validation.Valid;
import javassist.NotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
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
	Environment environment;
	
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
	  public ResponseEntity<LoginResponse> loginAndGetToken(@RequestBody @Valid LoginRequest request) throws NotFoundException {
		String token = "";		
		//System.out.println(environment.getProperty("key"));
		Optional<UserDetail> userAccount = userService.getUserByEmail(request.getusername());
		
		if(encoder.matches(request.getPassword(), userAccount.get().getPassword())) {
			
			token = authService.generateToken(request.getusername());
		}
		else {
			throw new UserNotFoundException("User Not Available.");
		}
		
	    return ResponseEntity.ok(new LoginResponse(request.getusername(), token));
	  }
}
