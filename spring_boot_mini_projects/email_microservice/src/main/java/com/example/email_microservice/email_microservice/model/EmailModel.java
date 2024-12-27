package com.example.email_microservice.email_microservice.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailModel {

	@JsonProperty(value = "senderEmailAddress")
	private String senderEmailAddress;
	@JsonProperty(value = "senderEmailAddressList")
	private String[] senderEmailAddressList;
	@JsonProperty(value = "emailSubject")
	private String emailSubject;
	@JsonProperty(value = "emailMessageWithOrWithoutHtml")
	private String emailMessageWithOrWithoutHtml;

	public String getSenderEmailAddress() {
		return senderEmailAddress;
	}

	public void setSenderEmailAddress(String senderEmailAddress) {
		this.senderEmailAddress = senderEmailAddress;
	}

	public String[] getSenderEmailAddressList() {
		return senderEmailAddressList;
	}

	public void setSenderEmailAddressList(String[] senderEmailAddressList) {
		this.senderEmailAddressList = senderEmailAddressList;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public String getEmailMessageWithOrWithoutHtml() {
		return emailMessageWithOrWithoutHtml;
	}

	public void setEmailMessageWithOrWithoutHtml(String emailMessageWithOrWithoutHtml) {
		this.emailMessageWithOrWithoutHtml = emailMessageWithOrWithoutHtml;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public EmailModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmailModel(String[] senderEmailAddressList, String emailSubject, String emailMessageWithOrWithoutHtml) {
		super();
		this.senderEmailAddressList = senderEmailAddressList;
		this.emailSubject = emailSubject;
		this.emailMessageWithOrWithoutHtml = emailMessageWithOrWithoutHtml;
	}

	public EmailModel(String senderEmailAddress, String emailSubject, String emailMessageWithOrWithoutHtml) {
		super();
		this.senderEmailAddress = senderEmailAddress;
		this.emailSubject = emailSubject;
		this.emailMessageWithOrWithoutHtml = emailMessageWithOrWithoutHtml;
	}

	@Override
	public String toString() {
		return "EmailModel [senderEmailAddress=" + senderEmailAddress + ", senderEmailAddressList="
				+ Arrays.toString(senderEmailAddressList) + ", emailSubject=" + emailSubject
				+ ", emailMessageWithOrWithoutHtml=" + emailMessageWithOrWithoutHtml + "]";
	}

}
