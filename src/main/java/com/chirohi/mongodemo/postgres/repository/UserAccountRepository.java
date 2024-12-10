package com.chirohi.mongodemo.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chirohi.mongodemo.postgres.entity.UserAccounts;

public interface UserAccountRepository extends JpaRepository<UserAccounts, String>  {

}
