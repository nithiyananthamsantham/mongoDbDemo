package com.chirohi.mongodemo.postgres.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.chirohi.mongodemo.postgres.entity.UserDetail;

import jakarta.persistence.LockModeType;

@Repository
public interface AppUserAccountRepository extends JpaRepository<UserDetail, String>  {

	//public UserDetail findByEmail(String email);
	//@Lock(LockModeType.PESSIMISTIC_READ)
	Optional<UserDetail> findByEmail(String email);
	
}
