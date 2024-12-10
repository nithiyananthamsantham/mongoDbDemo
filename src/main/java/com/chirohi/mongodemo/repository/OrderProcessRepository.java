package com.chirohi.mongodemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chirohi.mongodemo.model.Order;

@Repository
public interface OrderProcessRepository extends MongoRepository<Order, String> {

}
