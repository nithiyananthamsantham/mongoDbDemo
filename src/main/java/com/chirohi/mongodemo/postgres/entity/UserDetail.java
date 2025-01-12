package com.chirohi.mongodemo.postgres.entity;


import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user_detail", schema="dev_hotel_pro")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDetail implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String name;
	@Id
	String email;
	String password;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of();
	}
	@Override
	public String getUsername() {
		return name;
	}

}
