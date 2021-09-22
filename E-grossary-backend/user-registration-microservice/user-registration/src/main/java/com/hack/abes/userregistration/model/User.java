package com.hack.abes.userregistration.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class User{
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long userId;
	    
		@NotEmpty(message="usename is required")
		private String username;
		
		@NotEmpty(message="email is required")
		private String email;
		
		@NotEmpty(message="valid password is required")
		private String password;
		
		@NotEmpty(message="firstname is required")
		private String firstname;
		
		@NotEmpty(message="lastname is required")
		private String lastname;
		
		@NotEmpty(message="phonenumber is required")
		private String phonenumber;
		
		private boolean enabled=false;
		
		@NotEmpty(message="address is required is required")
		private String address;
		
		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="user")
		@JsonIgnore
		private Set<UserRole> userRole=new HashSet<>();

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getPhonenumber() {
			return phonenumber;
		}

		public void setPhonenumber(String phonenumber) {
			this.phonenumber = phonenumber;
		}

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

		public Set<UserRole> getUserRole() {
			return userRole;
		}

		public void setUserRole(Set<UserRole> userRole) {
			this.userRole = userRole;
		}

		public User() {
			super();
		}

		public User(String username, String email, String password, String firstname, String lastname,
				String phonenumber, boolean enabled, String address, Set<UserRole> userRole) {
			super();
			this.username = username;
			this.email = email;
			this.password = password;
			this.firstname = firstname;
			this.lastname = lastname;
			this.phonenumber = phonenumber;
			this.enabled = enabled;
			this.address = address;
			this.userRole = userRole;
		}
		
		

	

		
}
