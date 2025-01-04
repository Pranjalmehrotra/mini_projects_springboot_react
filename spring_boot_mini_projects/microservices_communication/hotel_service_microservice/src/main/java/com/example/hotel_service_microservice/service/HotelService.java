package com.example.hotel_service_microservice.service;

import java.util.List;

import com.example.hotel_service_microservice.model.HotelModel;

public interface HotelService {

	public HotelModel addNewHotel(HotelModel hotelModel);

	public HotelModel updateHotel(HotelModel hotelModel, Long hotelId);

	public List<HotelModel> getAllHotelsList();

	public HotelModel getHotelByHotelId(Long hotelId);

	public void deleteHotel(Long hotelId);

}
