package com.example.hotel_service_microservice.model;

import jakarta.persistence.Column;

public class HotelModel {

	private String hotelName;

	private String hotelLocation;

	private String hotelDescription;

	public HotelModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HotelModel(String hotelName, String hotelLocation, String hotelDescription) {
		super();
		this.hotelName = hotelName;
		this.hotelLocation = hotelLocation;
		this.hotelDescription = hotelDescription;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelName() {
		return hotelName;
	}

	public String getHotelLocation() {
		return hotelLocation;
	}

	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}

	public String getHotelDescription() {
		return hotelDescription;
	}

	public void setHotelDescription(String hotelDescription) {
		this.hotelDescription = hotelDescription;
	}

	@Override
	public String toString() {
		return "HotelModel [hotelName=" + hotelName + ", hotelLocation=" + hotelLocation + ", hotelDescription="
				+ hotelDescription + "]";
	}

}
