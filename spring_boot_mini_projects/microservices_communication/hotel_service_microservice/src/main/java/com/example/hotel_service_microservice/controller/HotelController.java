package com.example.hotel_service_microservice.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.hotel_service_microservice.model.HotelCommonResponse;
import com.example.hotel_service_microservice.model.HotelModel;
import com.example.hotel_service_microservice.service.HotelService;

@RestController
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/create-new-hotel")
	public ResponseEntity<HotelCommonResponse> createNewHotel(HotelModel hotelModel) {
		HotelCommonResponse createNewHotelResponse = new HotelCommonResponse();
		try {
			if (!ObjectUtils.isEmpty(hotelModel)) {
				HotelModel newUserModel = hotelService.addNewHotel(hotelModel);
				createNewHotelResponse.setStatusCode("201");
				createNewHotelResponse.setResponseMessage("User Created Successfully");
				createNewHotelResponse.setResponseData(newUserModel);

			} else {
				createNewHotelResponse.setStatusCode("500");
				createNewHotelResponse.setResponseMessage("User not created!Please enter details in correct format");
				createNewHotelResponse.setResponseData(null);
			}
		} catch (Exception e) {
			createNewHotelResponse.setStatusCode("500");
			createNewHotelResponse.setResponseMessage("Exception in creating the user!!");
			createNewHotelResponse.setResponseData(e);
		}
		return ResponseEntity.ok(createNewHotelResponse);

	}

	@PostMapping(value = "/update-hotel/{hotelId}")
	public ResponseEntity<HotelCommonResponse> updateHotelInfo(HotelModel hotelModel, @PathVariable("hotelId")Long hotelId) {
		HotelCommonResponse updatingHotelResponse = new HotelCommonResponse();
		try {
			if (!ObjectUtils.isEmpty(hotelModel)) {
				HotelModel newHotelModel = hotelService.updateHotel(hotelModel, hotelId);
				updatingHotelResponse.setStatusCode("200");
				updatingHotelResponse.setResponseMessage("User Updated Successfully");
				updatingHotelResponse.setResponseData(newHotelModel);

			} else {
				updatingHotelResponse.setStatusCode("500");
				updatingHotelResponse.setResponseMessage("User details not updated!Please enter details in correct format");
				updatingHotelResponse.setResponseData(null);
			}
		} catch (Exception e) {
			updatingHotelResponse.setStatusCode("500");
			updatingHotelResponse.setResponseMessage("Exception in updating the user details!!");
			updatingHotelResponse.setResponseData(e);
		}
		return ResponseEntity.ok(updatingHotelResponse);

	}

	@PostMapping(value = "/delete-hotel/{hotelId}")
	public ResponseEntity<HotelCommonResponse> deleteUser(@PathVariable("hotelId") Long hotelId) {
		HotelCommonResponse deletingHotelResponse = new HotelCommonResponse();
		try {
			hotelService.deleteHotel(hotelId);
			deletingHotelResponse.setStatusCode("200");
			deletingHotelResponse.setResponseMessage("User deleted successfully");
			deletingHotelResponse.setResponseData("Deletion occurs");

		} catch (Exception e) {
			deletingHotelResponse.setStatusCode("500");
			deletingHotelResponse.setResponseMessage("Exception in deleting the user details!!");
			deletingHotelResponse.setResponseData(e);
		}
		return ResponseEntity.ok(deletingHotelResponse);

	}

	@GetMapping(value = "/get-all-hotels")
	public ResponseEntity<HotelCommonResponse> listOfAllUsers() {
		HotelCommonResponse userListResponse = new HotelCommonResponse();
		try {
			List<HotelModel> hotelModelist = hotelService.getAllHotelsList();
			userListResponse.setStatusCode("200");
			userListResponse.setResponseMessage("List of all users");
			userListResponse.setResponseData(hotelModelist);

		} catch (Exception e) {
			userListResponse.setStatusCode("500");
			userListResponse.setResponseMessage("Exception in fetching all user list");
			userListResponse.setResponseData(e);
		}
		return ResponseEntity.ok(userListResponse);

	}
	
	@GetMapping(value = "/get-user/{hotelId}")
	public ResponseEntity<HotelCommonResponse> singleUserByUserId(@PathVariable("hotelId")Long hotelId) {
		HotelCommonResponse hotelListResponse = new HotelCommonResponse();
		try {
			HotelModel singleHotel = hotelService.getHotelByHotelId(hotelId);
			hotelListResponse.setStatusCode("200");
			hotelListResponse.setResponseMessage("User detail fetched successfully");
			hotelListResponse.setResponseData(singleHotel);

		} catch (Exception e) {
			hotelListResponse.setStatusCode("500");
			hotelListResponse.setResponseMessage("Exception in fetching User detail");
			hotelListResponse.setResponseData(e);
		}
		return ResponseEntity.ok(hotelListResponse);

	}
}



