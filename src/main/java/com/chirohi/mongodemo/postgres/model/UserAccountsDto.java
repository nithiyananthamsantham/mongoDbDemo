package com.chirohi.mongodemo.postgres.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserAccountsDto {
	
	String name;
	String email;
	String password;
	
	

}
