package com.chirohi.mongodemo.postgres.service;

import com.chirohi.mongodemo.postgres.entity.UserAccounts;
import com.chirohi.mongodemo.postgres.model.UserAccountsDto;

public interface UserService {
	
	public UserAccounts signupUser(UserAccountsDto signupRequst);

}
