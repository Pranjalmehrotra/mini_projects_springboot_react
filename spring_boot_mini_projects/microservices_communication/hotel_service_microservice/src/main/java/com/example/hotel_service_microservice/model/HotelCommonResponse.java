package com.example.hotel_service_microservice.model;


public class HotelCommonResponse {

	private String responseMessage;
	private String statusCode;
	private Object responseData;

	public HotelCommonResponse() {
		super();
	}

	public HotelCommonResponse(String errorMessage, String statusCode, Object responseData) {
		super();
		this.responseMessage = errorMessage;
		this.statusCode = statusCode;
		this.responseData = responseData;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String errorMessage) {
		this.responseMessage = errorMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Object getResponseData() {
		return responseData;
	}

	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}

	@Override
	public String toString() {
		return "UserCommonResponse [responseMessage=" + responseMessage + ", statusCode=" + statusCode + ", responseData="
				+ responseData + "]";
	}

}

