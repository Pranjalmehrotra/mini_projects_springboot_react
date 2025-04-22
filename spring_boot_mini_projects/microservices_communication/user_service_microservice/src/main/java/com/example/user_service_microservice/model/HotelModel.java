package com.example.user_service_microservice.model;

public class HotelModel {

	private String hotelName;

	private String hotelLocation;

	private String hotelDescription;

	private Long hotelId;

	public HotelModel() {
	}

	public HotelModel(String hotelName, String hotelLocation, String hotelDescription, Long hotelId) {
		super();
		this.hotelName = hotelName;
		this.hotelLocation = hotelLocation;
		this.hotelDescription = hotelDescription;
		this.hotelId = hotelId;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
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
