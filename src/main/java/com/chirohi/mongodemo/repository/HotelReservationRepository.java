package com.chirohi.mongodemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chirohi.mongodemo.model.Reservation;

@Repository
public interface HotelReservationRepository extends MongoRepository<Reservation, String> {
	
	@Query("UPDATE com.chirohi.mongodemo.model.Reservation r where r.id = :id")
	String saveById(@Param ("id") String id);

}
