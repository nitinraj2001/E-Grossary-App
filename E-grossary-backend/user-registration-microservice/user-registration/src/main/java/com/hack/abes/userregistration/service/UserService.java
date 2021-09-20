package com.hack.abes.userregistration.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.hack.abes.userregistration.model.User;
import com.hack.abes.userregistration.model.UserRole;

@Service
public interface UserService {
	

	public User createUser(User user,Set<UserRole>userRoles) throws Exception;
    
	public User findUser(String username);
	
	public void deleteUser(Long id);

}
