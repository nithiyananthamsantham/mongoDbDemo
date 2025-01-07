package com.chirohi.mongodemo.postgres.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.chirohi.mongodemo.postgres.entity.UserDetail;
import com.chirohi.mongodemo.postgres.model.UserAccountsDto;

public interface AppUserServiceDetailService extends UserDetailsService
{
	
	public UserDetail signupUser(UserAccountsDto signupRequst);
	
	public Optional<UserDetail> getUserByEmail(String name);

}
