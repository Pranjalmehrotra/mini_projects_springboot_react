package com.example.email_microservice.email_microservice.service;

import java.io.File;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.email_microservice.email_microservice.model.CustomiseEmailResponse;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

	private JavaMailSender javaMailSender;

	@Value("spring.mail.username")
	private String senderEmailAddress;

	private Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

	public EmailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public CustomiseEmailResponse sendEmailToOnePerson(String receiverEmailAddress, String emailSubject,
			String emailMessage) {
		CustomiseEmailResponse customiseResponse = new CustomiseEmailResponse();
		try {
			if (StringUtils.isNotEmpty(emailSubject) && StringUtils.isNotEmpty(emailSubject)
					&& StringUtils.isNotEmpty(receiverEmailAddress)) {
				SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
				simpleMailMessage.setTo(receiverEmailAddress);
				simpleMailMessage.setSubject(emailSubject);
				simpleMailMessage.setText(emailMessage);
				simpleMailMessage.setFrom(senderEmailAddress);
				javaMailSender.send(simpleMailMessage);
				logger.info("The email has been send with the values: {}", simpleMailMessage);
				customiseResponse.setResponseStatus("200");
				customiseResponse.setResponseData(simpleMailMessage);
				customiseResponse.setResponseMessage("Email send successfully");
			}
		} catch (Exception e) {
			logger.info("Email send failed with exception::{}", e);
			customiseResponse.setResponseStatus("400");
			customiseResponse.setResponseData(e);
			customiseResponse.setResponseMessage("Exception occured while sending the email");

		}
		return customiseResponse;
	}

	@Override
	public CustomiseEmailResponse sendEmailToMultiplePerson(String[] receiverEmailAddress, String emailSubject,
			String emailMessage) {
		CustomiseEmailResponse customiseResponse = new CustomiseEmailResponse();
		try {
			if (StringUtils.isNotEmpty(emailSubject) && StringUtils.isNotEmpty(emailSubject)
					&& receiverEmailAddress != null && receiverEmailAddress.length > 0) {
				SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
				simpleMailMessage.setTo(receiverEmailAddress);
				simpleMailMessage.setSubject(emailSubject);
				simpleMailMessage.setText(emailMessage);
				simpleMailMessage.setFrom(senderEmailAddress);
				javaMailSender.send(simpleMailMessage);
				logger.info("The email has been send to the multiple users with the values :{}", simpleMailMessage);
				customiseResponse.setResponseStatus("200");
				customiseResponse.setResponseData(simpleMailMessage);
				customiseResponse.setResponseMessage("Email send successfully");
			}
		} catch (Exception e) {
			logger.info("Email send failed with exception::{}", e);
			customiseResponse.setResponseStatus("400");
			customiseResponse.setResponseData(e);
			customiseResponse.setResponseMessage("Exception occured while sending the email");

		}
		return customiseResponse;
	}

	@Override
	public CustomiseEmailResponse sendEmailWithHtmlToOnePerson(String receiverEmailAddress, String emailSubject,
			String htmlContent) {
		CustomiseEmailResponse customiseResponse = new CustomiseEmailResponse();
		try {
			if (StringUtils.isNotEmpty(htmlContent) && StringUtils.isNotEmpty(htmlContent)
					&& StringUtils.isNotEmpty(htmlContent)) {
				MimeMessage htmlSubjectEmail = javaMailSender.createMimeMessage();
				MimeMessageHelper htmlEmailMessage = new MimeMessageHelper(htmlSubjectEmail);
				htmlEmailMessage.setTo(receiverEmailAddress);
				htmlEmailMessage.setSubject(emailSubject);
				htmlEmailMessage.setText(htmlContent, true);
				htmlEmailMessage.setFrom(senderEmailAddress);
				javaMailSender.send(htmlSubjectEmail);
				customiseResponse.setResponseStatus("200");
				customiseResponse.setResponseData(htmlSubjectEmail);
				customiseResponse.setResponseMessage("Email send successfully");
			}

		} catch (Exception e) {
			logger.info("Email send failed with exception::{}", e);
			customiseResponse.setResponseStatus("400");
			customiseResponse.setResponseData(e);
			customiseResponse.setResponseMessage("Exception occured while sending the email");
		}
		return customiseResponse;

	}

	@Override
	public CustomiseEmailResponse sendEmailWithFileToOnePerson(String receiverEmailAddress, String emailSubject,
			String emailMessage, String emailFilePath) {
		CustomiseEmailResponse customiseResponse = new CustomiseEmailResponse();
		try {
			if (StringUtils.isNotEmpty(emailSubject) && StringUtils.isNotEmpty(emailSubject)
					&& StringUtils.isNotEmpty(receiverEmailAddress) && StringUtils.isNotEmpty(emailFilePath)) {
				File file = new File(emailFilePath);
				MimeMessage fileEmailSender = javaMailSender.createMimeMessage();
				MimeMessageHelper fileMessageEmail = new MimeMessageHelper(fileEmailSender, true);
				fileMessageEmail.setTo(receiverEmailAddress);
				fileMessageEmail.setSubject(emailSubject);
				fileMessageEmail.setText(emailMessage);
				fileMessageEmail.setFrom(senderEmailAddress);
				fileMessageEmail.addAttachment(file.getName(), file);
				javaMailSender.send(fileEmailSender);
				logger.info("Email send successfully with values:{}", fileMessageEmail);
				customiseResponse.setResponseStatus("200");
				customiseResponse.setResponseData(fileMessageEmail);
				customiseResponse.setResponseMessage("Email send successfully");

			}

		} catch (Exception e) {
			logger.info("Email send failed with exception::{}", e);
			customiseResponse.setResponseStatus("400");
			customiseResponse.setResponseData(e);
			customiseResponse.setResponseMessage("Exception occured while sending the email");

		}
		return customiseResponse;

	}

}
