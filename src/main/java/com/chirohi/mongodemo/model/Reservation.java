package com.chirohi.mongodemo.model;

import java.util.Date;
import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Reservation {
	
    private String id;
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getChecInDate() {
		return checInDate;
	}
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reservation(String id, Date checInDate, Date checkOutDate, String guestName, String guestEmail,
			int roomNumber) {
		super();
		this.id = id;
		this.checInDate = checInDate;
		this.checkOutDate = checkOutDate;
		this.guestName = guestName;
		this.guestEmail = guestEmail;
		this.roomNumber = roomNumber;
	}
	@Override
	public int hashCode() {
		return Objects.hash(checInDate, checkOutDate, guestEmail, guestName, id, roomNumber);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(checInDate, other.checInDate) && Objects.equals(checkOutDate, other.checkOutDate)
				&& Objects.equals(guestEmail, other.guestEmail) && Objects.equals(guestName, other.guestName)
				&& Objects.equals(id, other.id) && roomNumber == other.roomNumber;
	}
	public void setChecInDate(Date checInDate) {
		this.checInDate = checInDate;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getGuestEmail() {
		return guestEmail;
	}
	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	private Date checInDate;
    private Date checkOutDate;
    private String guestName;
    private String guestEmail;
    private int roomNumber;
}
