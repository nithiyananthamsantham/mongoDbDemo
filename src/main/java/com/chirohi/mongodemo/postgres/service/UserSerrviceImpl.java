package com.chirohi.mongodemo.postgres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.chirohi.mongodemo.postgres.entity.UserAccounts;
import com.chirohi.mongodemo.postgres.model.UserAccountsDto;
import com.chirohi.mongodemo.postgres.repository.UserAccountRepository;

@Service
public class UserSerrviceImpl implements UserService{

	@Autowired
	private UserAccountRepository userAccRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public UserAccounts signupUser(UserAccountsDto signupRequst) {
		UserAccounts user = new UserAccounts();
		user.setName(signupRequst.getName());
		user.setEmail(signupRequst.getEmail());
		user.setPassword(encoder.encode(signupRequst.getPassword()));
		return userAccRepo.save(user);
		
	}

}
