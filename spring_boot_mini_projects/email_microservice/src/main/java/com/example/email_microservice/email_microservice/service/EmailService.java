package com.example.email_microservice.email_microservice.service;

import com.example.email_microservice.email_microservice.model.CustomiseEmailResponse;

public interface EmailService {
	
	public CustomiseEmailResponse sendEmailToOnePerson(String receiverEmailAddress, String emailSubject,String emailMessage);
	public CustomiseEmailResponse sendEmailToMultiplePerson(String[] receiverEmailAddress, String emailSubject,String emailMessage);
	public CustomiseEmailResponse sendEmailWithHtmlToOnePerson(String receiverEmailAddress, String emailSubject,String htmlContent);
	public CustomiseEmailResponse sendEmailWithFileToOnePerson(String receiverEmailAddress, String emailSubject,String emailMessage,String emailFilePath);

  
}
