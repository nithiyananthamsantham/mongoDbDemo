package com.chirohi.mongodemo.postgres.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.chirohi.mongodemo.postgres.entity.UserAccounts;
import com.chirohi.mongodemo.postgres.model.UserAccountsDto;

public interface UserService// extends UserDetailsService
{
	
	public UserAccounts signupUser(UserAccountsDto signupRequst);
	
	public Optional<UserAccounts> getUserByName(String name);

}
