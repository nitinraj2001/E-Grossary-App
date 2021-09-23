package com.hack.abes.userregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hack.abes.userregistration.model.User;
import com.hack.abes.userregistration.model.VerificationToken;
import com.hack.abes.userregistration.repository.UserRepository;
import com.hack.abes.userregistration.repository.VerificationTokenRepository;
import com.hack.abes.userregistration.service.UserService;

@Controller
public class UserAccountVerificationController {
	
	@Autowired
	private VerificationTokenRepository verificationTokenRepo;
	
	@Autowired
	private UserRepository theUserRepository;
	
	@Autowired
	private UserService theUserService;
	
	@RequestMapping(path = "/accountVerification/{token}/{id}", method = RequestMethod.GET)
	public String getAccountVerified(@PathVariable String token, @PathVariable Long id) {
		
		User theUser=this.theUserRepository.findById(id).get();
		
		VerificationToken theVerificationToken=this.verificationTokenRepo.findByUser(theUser);
		
		if(token.equalsIgnoreCase(theVerificationToken.getToken())) {
			
			System.out.println("active status of "+theUser.getUsername()+"is "+theUser.isEnabled());
			theUser.setEnabled(true);
			this.theUserService.updateUser(theUser);
			System.out.println("active status of "+theUser.getUsername()+"is "+theUser.isEnabled());
			return "AccountVerificationSuccess";
		}
		
	   return "AccountVerificationFailed";
	}

}
