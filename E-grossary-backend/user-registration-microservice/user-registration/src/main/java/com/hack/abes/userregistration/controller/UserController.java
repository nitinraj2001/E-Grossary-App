package com.hack.abes.userregistration.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hack.abes.userregistration.Exception.UserWithSameUsernameFoundException;
import com.hack.abes.userregistration.model.Role;
import com.hack.abes.userregistration.model.User;
import com.hack.abes.userregistration.model.UserRole;
import com.hack.abes.userregistration.model.VerificationToken;
import com.hack.abes.userregistration.repository.VerificationTokenRepository;
import com.hack.abes.userregistration.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private VerificationTokenRepository verficationRepo;
	
	@PostMapping("/")
	public User createNewUser(@RequestBody User theuser) throws Exception {
		try {
		User user=this.userService.findUser(theuser.getUsername());
		if(user!=null) {
			throw new UserWithSameUsernameFoundException(theuser.getUsername());
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		theuser.setPassword(theuser.getPassword());
		Set<UserRole> userroles=new HashSet<>();
		Role role=new Role();
		role.setRoleName("USER");
		UserRole userrole=new UserRole();
		userrole.setRole(role);
		userrole.setUser(theuser);
		userroles.add(userrole);
		return this.userService.createUser(theuser, userroles);
		
	}
	
	@GetMapping("/accountVerification")
	public String sendVerificationMessage(@RequestParam("token") String token) {
		System.out.println(token);
		VerificationToken verToken=null;
		try {
		 verToken=this.verficationRepo.findByToken(token);
		}catch(Exception e) {
			e.printStackTrace();
			
			
		}
		if(!verToken.getToken().equalsIgnoreCase(token)||verToken==null) {
			
			
			return "<html lang=\"en\">\r\n" + 
					"<head>\r\n" + 
					"  <title>AccountVerificationFailure</title>\r\n" + 
					"  <meta charset=\"utf-8\">\r\n" + 
					"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
					"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n" + 
					"  <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\r\n" + 
					"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n" + 
					"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"<h1 align=\"center\" style=\"color:red\">Your Account can't be activated due to invalid token, try to verify your token again!!</h1>\r\n" + 
					"\r\n" + 
					"</body>\r\n" + 
					"</html>";
				
		}
	
		
		return "<html lang=\"en\">\r\n" + 
				"<head>\r\n" + 
				"  <title>AccountVerificationSuccess</title>\r\n" + 
				"  <meta charset=\"utf-8\">\r\n" + 
				"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n" + 
				"  <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\r\n" + 
				"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n" + 
				"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<h1 align=\"center\" style=\"color:red\">Account is Successfully Verified And Activated</h1>\r\n" + 
				"<div class=\"container\" style=\"margin-left:30% color:blue\">\r\n" + 
				"<button style=\"margin-top:2%; margin-left:35%; color:green\"><h1>Login To My Super Market App</h1></button>\r\n" + 
				"<script type=\"text/javascript\">\r\n" + 
				"    window.location.href = \"http://localhost:4200/login\";\r\n" + 
				"</script>\r\n" + 
				"</div >\r\n" + 
				"</body>\r\n" + 
				"</html>";

		

	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.findUser(username);
	}
	
	@DeleteMapping("/{userId}")
	public String deleteUser(@PathVariable("userId")Long userId) {
		this.userService.deleteUser(userId);
		return "user with userid "+userId+" is deleted successfully";
	}

}
