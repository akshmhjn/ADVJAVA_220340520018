package com.cdac.service;

public class LoginService {

	public boolean loginCheck(String username, String password) {
		if(username.equals("Akshay") && password.equals("2122"))
			return true;
		return false;
	}

}
