package com.chirohi.mongodemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chirohi.mongodemo.model.Reservation;
import com.chirohi.mongodemo.repository.HotelReservationRepository;

@Service
public class HotelReservationServiceImpl implements HotelReservationServiceInterface{

	@Autowired
	HotelReservationRepository reservationRepository;
	
	@Override
	public Reservation createReservation(Reservation reservation) {
		return reservationRepository.insert(reservation);
	}

	@Override
	public List<Reservation> findAll() {
		return reservationRepository.findAll();
	}

	@Override
	public Optional<Reservation> findById(String id) {
		
		Optional<Reservation> reserveObj = reservationRepository.findById(id);
		
		return reserveObj;
	}
	
	@Override
	public String saveById(Reservation reservation) {
		
		reservationRepository.save(reservation);
		
		return "success";
	}



}
