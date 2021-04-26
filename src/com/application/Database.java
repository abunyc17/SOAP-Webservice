package com.application;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.application.fetchUser.FetchUserRequest;
import com.application.fetchUser.FetchUserResponse;
import com.application.newUser.NewUserRequest;
import com.application.newUser.NewUserResponse;

public class Database {

	public Connection dbConnector() {
	    
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//create a connection object
			//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCL","SCHOOLPORTAL","SCHOOLPORTAL");
			
			Properties props = new Properties();
			props.setProperty("user", "SCHOOLPORTAL");
			props.setProperty("password", "SCHOOLPORTAL");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCL", props);
			
			System.out.println("connection successful");
			return conn;
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("connection Failed");
			return null;
		}
	}
	
	
	public NewUserResponse createNewUser(NewUserRequest newUserRequest) throws Exception {
		
		NewUserResponse newUserResponse = new NewUserResponse();
		Connection conn = null;
		CallableStatement cst = null;
		
		try {
			conn = dbConnector();
			
			cst = conn.prepareCall("{call soapy(?,?,?,?,?,?,?,?)}");
			
			cst.setString(1, newUserRequest.getFirstName());
			cst.setString(2, newUserRequest.getMiddleName());
			cst.setString(3, newUserRequest.getLastName());
			cst.setString(4, newUserRequest.getUsername());
			cst.setString(5, newUserRequest.getPhoneNumber());
			cst.setString(6, newUserRequest.getEmail());
			cst.setDate(7, getCurrentDate(newUserRequest.getDob(), "dd/MM/yyyy"));
			
            cst.registerOutParameter(8, Types.VARCHAR);
						
			cst.execute();
			
			String resp = cst.getString(8);
			System.out.println(resp);
			
			// set to failure
			newUserResponse.setResponseMessage("FAILURE");
			newUserResponse.setResponseCode("01");
			
			//set to success
			if(resp.trim().toUpperCase().equals("SUCCESSFUL")) {
				newUserResponse.setResponseMessage("SUCCESSFUL");
				newUserResponse.setResponseCode("00");
			}
		
			cst.close();
			conn.close();
			
			return newUserResponse;
		}
		catch(SQLException e) {
			cst.close();
			conn.close();
			
			e.printStackTrace();
			return newUserResponse;
		}
				
	}
	
	
	public FetchUserResponse selectUser(FetchUserRequest fetchUserRequest) throws Exception {
		
		FetchUserResponse fetchUserResponse = new FetchUserResponse();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			
			conn = dbConnector();
			
			String sql = "SELECT SOAPEXAMPLE.FIRSTNAME,\r\n" + 
					"       SOAPEXAMPLE.MIDDLENAME,\r\n" + 
					"       SOAPEXAMPLE.LASTNAME,\r\n" + 
					"       SOAPEXAMPLE.USERNAME,\r\n" + 
					"       SOAPTEST.PHONE_NUM,\r\n" + 
					"       SOAPTEST.EMAIL,\r\n" + 
					"       SOAPTEST.DATE_OF_BIRTH\r\n" + 
					"  FROM soapexample\r\n" + 
					"       INNER JOIN soaptest\r\n" + 
					"           ON     SOAPEXAMPLE.USER_ID = SOAPTEST.USER_ID\r\n" + 
					"              AND (soapexample.USERNAME = ? OR soaptest.EMAIL = ?  OR soaptest.PHONE_NUM = ?)";
			
			
			
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, fetchUserRequest.getFilter());
			pst.setString(2, fetchUserRequest.getFilter());
			pst.setString(3, fetchUserRequest.getFilter());
			
			rs = pst.executeQuery();
			

			fetchUserResponse.setResponseCode("01");
			fetchUserResponse.setResponseMessage("FAILURE");
			
			while (rs.next()) {
				
				fetchUserResponse.setFirstName(rs.getString(1));
				fetchUserResponse.setMiddleName(rs.getString(2));
				fetchUserResponse.setLastName(rs.getString(3));
				fetchUserResponse.setUsername(rs.getString(4));
				fetchUserResponse.setPhoneNumber(rs.getString(5));
				fetchUserResponse.setEmail(rs.getString(6));
				fetchUserResponse.setDob(rs.getString(7));

				fetchUserResponse.setResponseCode("00");
				fetchUserResponse.setResponseMessage("SUCCESSFUL");
				
			}
						
			rs.close();
			pst.close();
			conn.close();
			
			return fetchUserResponse;
		}
		catch(SQLException e) {
			rs.close();
			pst.close();
			conn.close();
			
			e.printStackTrace();

			return fetchUserResponse;
		}
		
	}

	
	
	private static java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    //System.out.println("dateString1: " + new java.sql.Date(today.getTime()));
	    return new java.sql.Date(today.getTime());
	}
	
	private static java.sql.Date getCurrentDate(String inputDate, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date javaDate = getCurrentDate();
		
		try {
			if (inputDate.trim().length() > 0) {}
				javaDate = sdf.parse(inputDate);
			
		} catch (Exception e) {}		
	    return new java.sql.Date(javaDate.getTime());
	}
	
	
	
}
