package com.hack.abes.userregistration.Exception;

import com.hack.abes.userregistration.model.User;

@SuppressWarnings("serial")
public class UserNotAuthenticated extends Exception {
	
	public UserNotAuthenticated(User theUser) {
        super(String.format("User with id '%s' is already exist try with different username!!", theUser.getUsername()));
    }

}
