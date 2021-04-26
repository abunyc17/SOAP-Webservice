package com.application;

import javax.jws.WebService;

import com.application.fetchUser.FetchUserRequest;
import com.application.fetchUser.FetchUserResponse;
import com.application.newUser.NewUserRequest;
import com.application.newUser.NewUserResponse;

@WebService(targetNamespace = "http://application.com/", endpointInterface = "com.application.IApplication", portName = "ApplicationPort", serviceName = "ApplicationService")
public class Application implements IApplication {

	@Override
	public NewUserResponse createUser(NewUserRequest newUserRequest) throws Exception {

		NewUserResponse newUserResponse = new NewUserResponse();
		
		//validate compulsory parameters
		if (newUserRequest.getFirstName().trim().isEmpty()
				|| newUserRequest.getLastName().trim().isEmpty()
				|| newUserRequest.getPhoneNumber().trim().isEmpty()){
			
			newUserResponse.setResponseCode("02");
			newUserResponse.setResponseMessage("MANDATORY FIELDS");
			
			return newUserResponse;
		}
		
		//call procedure to create user
		newUserResponse = new Database().createNewUser(newUserRequest);
		
		return newUserResponse;
	}

	@Override
	public FetchUserResponse fetchUser(FetchUserRequest fetchUserRequest) throws Exception {
		
		FetchUserResponse fetchUserResponse = new FetchUserResponse();
		
		//select user based on filter passed
		fetchUserResponse = new Database().selectUser(fetchUserRequest);
				
		return fetchUserResponse;
	}

}
