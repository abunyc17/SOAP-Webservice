package com.application.fetchUser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FetchUserRequest {

	@XmlElement(name="SEARCH_CRITERION")
	private String filter;

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}
	
	FetchUserRequest(){}
	
	FetchUserRequest(String filter){
		this.filter = filter;
	}
	
}
