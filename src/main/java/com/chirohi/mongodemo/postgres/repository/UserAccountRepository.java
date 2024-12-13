package com.chirohi.mongodemo.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chirohi.mongodemo.postgres.entity.UserAccounts;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccounts, String>  {

}
