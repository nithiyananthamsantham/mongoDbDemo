package com.chirohi.mongodemo.service;

import java.util.List;
import java.util.Optional;

import com.chirohi.mongodemo.model.Reservation;

public interface HotelReservationServiceInterface {
	
	Reservation createReservation(Reservation reservation);
	
	List<Reservation> findAll();
	
	Optional<Reservation> findById(String id);
	
	String saveById(Reservation reservation) ;
	

}
