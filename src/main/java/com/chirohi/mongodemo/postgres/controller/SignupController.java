package com.chirohi.mongodemo.postgres.controller;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.chirohi.mongodemo.exception.UserNotFoundException;
import com.chirohi.mongodemo.postgres.entity.UserDetail;
import com.chirohi.mongodemo.postgres.model.UserAccountsDto;
import com.chirohi.mongodemo.postgres.service.AppUserServiceDetailService;
import com.chirohi.mongodemo.postgres.service.JWTAuthenticateService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.Valid;
import javassist.NotFoundException;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SignupController 
{
//	@Autowired
//	private UserService userService;
	
	@Autowired
	private AppUserServiceDetailService userService;
	
//	@Value("${hotel.app.provider.url}")
//	String providerUrl;
	
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
	
	
	@PostMapping("signup/signupGitUrl")
	public Mono<String> signupGit(@RequestBody UserAccountsDto signupRequest)
	{
//		return ResponseEntity.ok(webClientBuilder
//				.post()
//				.uri(providerUrl)
//				.bodyValue(signupRequest)
//				.retrieve()
//				.bodyToMono(String.class)
//				.block());
		
		 return Mono.fromCallable(() -> {
	            var res = webClientBuilder.get()
	                    .uri("http://www.google.com")
	                    .retrieve()
	                    .bodyToMono(String.class)
	                    .block();
	    
//	            log.info("END");
	    
	            return res;
	        })
	        .subscribeOn(Schedulers.boundedElastic());
//	        .doOnSubscribe(s -> log.info("START"));
	}
	
	@PostMapping("/loginAndGetToken")
	  public ResponseEntity<LoginResponse> loginAndGetToken(@Valid @RequestBody LoginRequest request) throws NotFoundException {
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
	
	@GetMapping("/getRequestWithBody")
	public ResponseEntity<Object> getRequestWithBody(@Valid @RequestBody LoginRequest loginRequest) throws Exception{
		
		try {
			return ResponseEntity.ok("success");
		} catch (Exception e) {
			throw new Exception(); 
		}
	}
	
	@PostMapping("/postMethodWithoutBody")
	public ResponseEntity<Object> postMethodWithoutBody(){
		
		return ResponseEntity.ok("success");
	}
	
	@GetMapping("/hello")
	public ResponseEntity<Object> hello(){
		
		return ResponseEntity.ok("success");
	}
}
