package com.example.email_microservice.email_microservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.email_microservice.email_microservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class EmailMicroserviceApplicationTests {
	
	@Autowired
	private EmailService emailService;

	@Test
	void contextLoads() {
	}
	
	@Test
	void sendEmailToOnePersonTest() {
		String receiverEmailAddress = "pranjalmehrotra213@gmail.com";
		String emailSubject = "Testing of the nptp server";
		String emailMessage = "Sample test email";
		emailService.sendEmailToOnePerson(receiverEmailAddress, emailSubject, emailMessage);
	}
	
	@Test
	void sendEmailToOnePersonTestTwo() {
		String receiverEmailAddress = "susparshofficial@gmail.com";
		String emailSubject = "Testing of the nptp server 2 from pranjal";
		String emailMessage = "Sample test email 2";
		emailService.sendEmailToOnePerson(receiverEmailAddress, emailSubject, emailMessage);
	}
	
	@Test
	void sendEmailToOnePersonTestHtmlOne() {
		String receiverEmailAddress ="tarugupta06@gmail.com";
		String emailSubject = "Testing of the nptp server 2 from pranjal";
		String emailMessage = "" +
		"<h1 style = 'color:red'>Welcome to learn nstp server html demo</h1>"+
		"";
		emailService.sendEmailWithHtmlToOnePerson(receiverEmailAddress, emailSubject, emailMessage);
	}
	
	@Test
	void sendEmailWithAttachmentToOnePerson() {
		String receiverEmailAddress ="pranjalmehrotra213@gmail.com";
		String emailSubject = "Testing of the nptp server 2 from pranjal";
		String emailMessage = "Sample test email 2";
		String emailFilePath = "C:/Users/pranj/OneDrive/Documents/mini_projects_springboot/spring_boot_mini_projects/email_microservice/images/hdfc_cancelled_cheque_Edited.jpeg";
		emailService.sendEmailWithFileToOnePerson(receiverEmailAddress, emailSubject, emailMessage, emailFilePath);
	}
	

}
