package com.example.hotel_service_microservice.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel_info_tbl")
public class HotelEntity {

	@Id
	@Column(name = "hotel_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long hotelId;

	@Column(name = "hotel_name")
	private String hotelName;

	@Column(name = "hotel_location")
	private String hotelLocation;

	@Column(name = "hotel_description")
	private String hotelDescription;

	public HotelEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HotelEntity(Long hotelId, String hotelName, String hotelLocation, String hotelDescription) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelLocation = hotelLocation;
		this.hotelDescription = hotelDescription;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
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
		return "HotelEntity [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelLocation=" + hotelLocation
				+ ", hotelDescription=" + hotelDescription + "]";
	}

}
