package com.chirohi.mongodemo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chirohi.mongodemo.model.Reservation;
import com.chirohi.mongodemo.service.HotelReservationServiceInterface;

@RestController
public class HotelReservationController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	HotelReservationServiceInterface hotelReservation;
	
	//@CrossOrigin(origins = "http://localhost:9091") 
	@PostMapping("/reservation")
	public ResponseEntity<Object> createReservation(@RequestBody Reservation reservationObj){
		
		reservationObj = hotelReservation.createReservation(reservationObj);
		log.info("Reservation confirmed!!!");
		return ResponseEntity.ok(reservationObj);
	}
	
	@CrossOrigin(origins = "*") 
	@GetMapping("/getReservationList")
	public ResponseEntity<Object> getReservationList(){
		
		List<Reservation> reservationList = hotelReservation.findAll();
		log.info("Get All the reservations!!!");
		return ResponseEntity.ok(reservationList);
	}
	@PutMapping("/updateReservation/{id}"  )
	public ResponseEntity<Object> updateReservation(@PathVariable String id, @RequestBody Reservation reservationObj){
		if(reservationObj !=null) {
			reservationObj.setId(id);
		}
		hotelReservation.saveById(reservationObj);
		log.info("Reservation updated!!!");
		return ResponseEntity.ok("Updated");
	}
	
	@GetMapping("/reservation/{id}"  )
	public ResponseEntity<Object> findById(@PathVariable String id){
		
		Optional<Reservation> reservation = hotelReservation.findById(id);
		log.info("Reservation found!!!");
		return ResponseEntity.ok(reservation);
	}
	
	@GetMapping("/reservationNameList")
	public ResponseEntity<Object> getReservationNameList(){
		
		List<Reservation> reservationList = hotelReservation.findAll();
		
		List<String> nameList = reservationList.stream().map(Reservation::getGuestName).collect(Collectors.toList());
		
		return ResponseEntity.ok(nameList);
	}
	
	

}
