package com.example.hotel_service_microservice.service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hotel_service_microservice.entity.HotelEntity;
import com.example.hotel_service_microservice.exception.ResourceNotFoundException;
import com.example.hotel_service_microservice.model.HotelModel;
import com.example.hotel_service_microservice.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public HotelModel addNewHotel(HotelModel hotelModel) {
		// TODO Auto-generated method stub
		HotelEntity addNewHotel = modelToEntityMapper(hotelModel);
		hotelRepository.save(addNewHotel);
		return entityToModelMapper(addNewHotel);
	}

	@Override
	public HotelModel updateHotel(HotelModel hotelModel, Long hotelId) {
		// TODO Auto-generated method stub
		HotelEntity hotelEntity = hotelRepository.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel not found for the id:" + hotelId));
		hotelEntity.setHotelDescription(hotelModel.getHotelDescription());
		hotelEntity.setHotelLocation(hotelModel.getHotelLocation());
		hotelEntity.setHotelName(hotelModel.getHotelName());
		hotelRepository.save(hotelEntity);
		return entityToModelMapper(hotelEntity);
	}

	@Override
	public List<HotelModel> getAllHotelsList() {
		List<HotelEntity> hotelEntityList = hotelRepository.findAll();
		List<HotelModel> hotelModelList = hotelEntityList.stream()
				.map((hotelEntity) -> entityToModelMapper(hotelEntity)).collect(Collectors.toList());
		return hotelModelList;
	}

	@Override
	public void deleteHotel(Long hotelId) {
		HotelEntity hotelEntity = hotelRepository.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel not found for the id:" + hotelId));
		hotelRepository.delete(hotelEntity);

	}

	@Override
	public HotelModel getHotelByHotelId(Long hotelId) {
		HotelEntity hotelEntity = hotelRepository.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel not found for the id:" + hotelId));
		return entityToModelMapper(hotelEntity);
	}

	private HotelEntity modelToEntityMapper(HotelModel hotelModel) {
		HotelEntity hotelEntity = new HotelEntity();
		hotelEntity.setHotelDescription(hotelModel.getHotelDescription());
		hotelEntity.setHotelLocation(hotelModel.getHotelLocation());
		hotelEntity.setHotelName(hotelModel.getHotelName());
		return hotelEntity;
	}

	private HotelModel entityToModelMapper(HotelEntity hotelEntity) {
		HotelModel hotelModel = new HotelModel();
		hotelModel.setHotelDescription(hotelEntity.getHotelDescription());
		hotelModel.setHotelLocation(hotelEntity.getHotelLocation());
		hotelModel.setHotelName(hotelEntity.getHotelName());
		return hotelModel;

	}

}
