package com.geekstartup.login;

import org.springframework.stereotype.Service;

@Service
public class UserValidation {
	
	public boolean isValidUser(String user,String password) {
		
		if(user.equals("Ashish") && password.equals("password"))
			return true;
		
		return false;
		
	}

}
