package com.example.email_microservice.email_microservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import com.example.email_microservice.email_microservice.model.CustomiseEmailResponse;
import com.example.email_microservice.email_microservice.model.EmailModel;
import com.example.email_microservice.email_microservice.service.EmailService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EmailServiceController {

	private EmailService emailService;

	public EmailServiceController(EmailService emailService) {
		this.emailService = emailService;
	}

	// 1. Sending emails with file to multiple persons
	// @RequestMapping(value= "/send-email-to-multiple-users",method =
	// RequestMethod.POST)

	@PostMapping("/send-html-email-single-user")
	public ResponseEntity<CustomiseEmailResponse> sendHtmlEmailToSingleUser(@RequestBody EmailModel emailModel) {
		CustomiseEmailResponse categoriseEmailResponse = this.emailService.sendEmailWithHtmlToOnePerson(
				emailModel.getSenderEmailAddress(), emailModel.getEmailSubject(),
				emailModel.getEmailMessageWithOrWithoutHtml());
		return ResponseEntity.ok(categoriseEmailResponse);

	}

	/*
	 * Here we want to send the email model along with file, so we have to use
	 * RequestPart not RequestBody for emailModel  and not RequestPart, not RequestParam for file.
	 */
	@PostMapping("/send-normal-email-single-user-file")
	public ResponseEntity<CustomiseEmailResponse> sendNormalEmailToSingleUserWithFile(
			@RequestPart EmailModel emailModel, @RequestPart MultipartFile emailFile) {
		CustomiseEmailResponse categoriseEmailResponse = this.emailService.sendEmailWithFileToOnePerson(
				emailModel.getSenderEmailAddress(), emailModel.getEmailSubject(),
				emailModel.getEmailMessageWithOrWithoutHtml(), emailFile.getOriginalFilename());
		return ResponseEntity.ok(categoriseEmailResponse);

	}

	@PostMapping("/send-normal-email-mutiple-users")
	public ResponseEntity<CustomiseEmailResponse> sendNormalEmailToMultipleUsers(@RequestBody EmailModel emailModel) {
		CustomiseEmailResponse categoriseEmailResponse = this.emailService.sendEmailToMultiplePerson(
				emailModel.getSenderEmailAddressList(), emailModel.getEmailSubject(),
				emailModel.getEmailMessageWithOrWithoutHtml());
		return ResponseEntity.ok(categoriseEmailResponse);

	}

}