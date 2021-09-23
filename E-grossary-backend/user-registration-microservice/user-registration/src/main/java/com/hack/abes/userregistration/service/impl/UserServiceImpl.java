package com.hack.abes.userregistration.service.impl;

import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.hack.abes.userregistration.model.User;
import com.hack.abes.userregistration.model.UserRole;
import com.hack.abes.userregistration.model.VerificationToken;
import com.hack.abes.userregistration.repository.RoleRepository;
import com.hack.abes.userregistration.repository.UserRepository;
import com.hack.abes.userregistration.repository.VerificationTokenRepository;
import com.hack.abes.userregistration.service.EmailService;
import com.hack.abes.userregistration.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
		
		@Autowired
		private UserRepository userRepository;
		
		@Autowired
		private RoleRepository roleRepository;
		
		@Autowired
		private VerificationTokenRepository verificationTokenRepository;
		
		@Autowired
		private EmailService emailService;
		

		@Override
		public User createUser(User user, Set<UserRole> userRoles) throws Exception {
			
			User theUser=this.userRepository.findByUsername(user.getUsername());
			
			if(theUser!=null) {
				System.out.println("This username is already exit");
				throw new Exception("this username already exist try again");
			}
			
			else {
				for(UserRole userrole:userRoles) {
					this.roleRepository.save(userrole.getRole());
				}
				user.getUserRole().addAll(userRoles);
				theUser=this.userRepository.save(user);
				String token=generateVerificationToken(user);
				
				SimpleMailMessage mailMessage=new SimpleMailMessage();
				
				mailMessage.setTo(user.getEmail());
				
				mailMessage.setSubject("Activate Account at My Super Market App");
				
				mailMessage.setText("To activate your account please click here :" + "http://localhost:9090/accountVerification/"+token+"/"+user.getUserId() );
				
				try {
				emailService.sendEmail(mailMessage);
				
				}
				
				catch(Exception e) {
					e.printStackTrace();
				}
				
				
				
			}
			return theUser;
		}
		
		private String generateVerificationToken(User theuser) {
			
			String token=UUID.randomUUID().toString();
			
			VerificationToken verificationToken=new VerificationToken();
			
			verificationToken.setToken(token);
			
			verificationToken.setUser(theuser);
			
			this.verificationTokenRepository.save(verificationToken);
			
			return token;
			
		}

	    public User findUser(String username) {
			
			return this.userRepository.findByUsername(username);
		}

		public void deleteUser(Long id) {
			
			 this.userRepository.deleteById(id);
		}

}
