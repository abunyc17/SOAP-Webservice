package com.application.newUser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.application.commonMethod.CommonResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NewUserResponse extends CommonResponse{

	public NewUserResponse(){}
	
	NewUserResponse(String code, String message){
		super(code, message);
	}
}
