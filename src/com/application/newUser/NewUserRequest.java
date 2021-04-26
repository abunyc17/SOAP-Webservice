package com.application.newUser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NewUserRequest {
	
	@XmlElement(name = "FIRST_NAME")
	private String firstName;
	
	@XmlElement(name = "MIDDLE_NAME")
	private String middleName;
	
	@XmlElement(name = "LAST_NAME")
	private String lastName;
	
	@XmlElement(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	@XmlElement(name = "EMAIL")
	private String email;
	
	@XmlElement(name = "DATE_OF_BIRTH")
	private String dob;

	@XmlTransient
	private String username;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getUsername() {
		username = getFirstName() + "-" + getLastName();
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
