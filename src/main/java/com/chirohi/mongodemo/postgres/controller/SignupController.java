package com.chirohi.mongodemo.postgres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chirohi.mongodemo.postgres.model.UserAccountsDto;
import com.chirohi.mongodemo.postgres.service.UserService;


@RestController
public class SignupController 
{
	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<Object> signup(@RequestBody UserAccountsDto signupRequest)
	{
		userService.signupUser(signupRequest);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
//	@PostMapping("/login")
//	  public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
//	    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
//	    String token = JwtHelper.generateToken(request.getEmail());
//	    return ResponseEntity.ok(new LoginResponse(request.getEmail(), token));
//	  }
}
