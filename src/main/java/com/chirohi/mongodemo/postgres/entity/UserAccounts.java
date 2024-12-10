package com.chirohi.mongodemo.postgres.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user_acc", schema="dev_hotel_pro")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserAccounts {
	
	@Id
	String name;
	String email;
	String password;
	
	

}
