package com.hack.abes.userregistration.controller;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hack.abes.userregistration.Exception.UserNotAuthenticated;
import com.hack.abes.userregistration.Exception.UserNotFoundException;
import com.hack.abes.userregistration.Exception.UserWithSameUsernameFoundException;
import com.hack.abes.userregistration.model.AuthenticateUserRequest;
import com.hack.abes.userregistration.model.Role;
import com.hack.abes.userregistration.model.User;
import com.hack.abes.userregistration.model.UserRole;
import com.hack.abes.userregistration.repository.RoleRepository;
import com.hack.abes.userregistration.repository.UserRepository;
import com.hack.abes.userregistration.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository theUserRepository;
	
	@Autowired
	private RoleRepository theRoleRepository;
	
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
	
		
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.findUser(username);
	}
	
	@DeleteMapping("/{userId}")
	public String deleteUser(@PathVariable("userId")Long userId) {
		this.userService.deleteUser(userId);
		return "user with userid "+userId+" is deleted successfully";
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticateUser(@RequestBody AuthenticateUserRequest request ) throws UserNotAuthenticated{
		User theUser=this.theUserRepository.findByUsername(request.getUsername());
		if(theUser!=null) {
			if(request.getPassword().contentEquals(theUser.getPassword())) {
				return ResponseEntity.ok("you are authenticated and can access our functionalities!!");
			}
		}
		throw new UserNotAuthenticated(theUser);
	}
	
	@GetMapping("/fetchByUsername/{username}")
	public ResponseEntity<User> getUserByUserName(@PathVariable("username") String username) throws UserNotFoundException {
		
		User theUser=this.userService.findUser(username);
		
		if(theUser==null) {
			throw new UserNotFoundException(username);
		}
		
		return ResponseEntity.ok(theUser);
		
	}
	
	@GetMapping("/getRole/{id}")
	public ResponseEntity<Role> getUserRole(@PathVariable Long id) throws UserNotFoundException{
		Role theRole=this.theRoleRepository.findById(id).get();
		if(theRole==null) {
			throw new UserNotFoundException(id.toString());
		}
		return ResponseEntity.ok(theRole);
	}

}
