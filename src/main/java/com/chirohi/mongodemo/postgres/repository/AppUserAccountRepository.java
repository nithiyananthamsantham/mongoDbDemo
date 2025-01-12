package com.chirohi.mongodemo.postgres.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chirohi.mongodemo.postgres.entity.UserDetail;

@Repository
public interface AppUserAccountRepository extends JpaRepository<UserDetail, String>  {

	//public UserDetail findByEmail(String email);
	Optional<UserDetail> findByEmail(String email);
	
}
