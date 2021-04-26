package com.application;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.application.fetchUser.FetchUserRequest;
import com.application.fetchUser.FetchUserResponse;
import com.application.newUser.NewUserRequest;
import com.application.newUser.NewUserResponse;

@WebService(name = "IApplication", targetNamespace = "http://application.com/")
public interface IApplication {

	@WebMethod(operationName = "createUser", action = "urn:CreateUser")
	@WebResult(name = "RESPONSE")
	NewUserResponse createUser(@WebParam(name = "REQUEST")NewUserRequest newUserRequest) throws Exception;
	
	@WebMethod(operationName = "fetchUser", action = "urn:FetchUser")
	@WebResult(name = "RESPONSE")
	public FetchUserResponse fetchUser(@WebParam(name = "REQUEST")FetchUserRequest fetchUserRequest) throws Exception;
	
}
