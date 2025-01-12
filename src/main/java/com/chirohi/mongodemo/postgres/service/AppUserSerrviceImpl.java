package com.chirohi.mongodemo.postgres.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.chirohi.mongodemo.postgres.entity.UserAccounts;
import com.chirohi.mongodemo.postgres.entity.UserDetail;
import com.chirohi.mongodemo.postgres.model.UserAccountsDto;
import com.chirohi.mongodemo.postgres.repository.AppUserAccountRepository;
import com.chirohi.mongodemo.postgres.repository.UserAccountRepository;

@Service
public class AppUserSerrviceImpl implements AppUserServiceDetailService{

	@Autowired
	private AppUserAccountRepository userAccRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public UserDetail signupUser(UserAccountsDto signupRequst) {
		UserDetail user = new UserDetail();
		System.out.println("inside signupUser111111111");
		user.setName(signupRequst.getName());
		user.setEmail(signupRequst.getEmail());
		user.setPassword(encoder.encode(signupRequst.getPassword()));
		return userAccRepo.save(user);
		
	}

	@Override
	public UserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
		return userAccRepo.findById(username).get();
	}

	@Override
	public Optional<UserDetail> getUserByEmail(String email) {
		
		return userAccRepo.findById(email);
		//return Optional.empty();
	}

//	@Override
//	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//		return userAccRepo.findById(userName).get();
//	}

}
