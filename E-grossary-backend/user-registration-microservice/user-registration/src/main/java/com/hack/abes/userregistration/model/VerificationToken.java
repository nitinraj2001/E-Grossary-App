package com.hack.abes.userregistration.model;

import java.time.Instant;

import javax.persistence.*;

@Entity
@Table(name="token")
public class VerificationToken {
	
	@Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private String token;
    @OneToOne(fetch =FetchType.LAZY)
    private User user;
    private Instant expiryDate;
    
	public VerificationToken() {
		super();
		
	}

	public VerificationToken(String token, User user, Instant expiryDate) {
		super();
		this.token = token;
		this.user = user;
		this.expiryDate = expiryDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Instant getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Instant expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "VerificationToken [id=" + id + ", token=" + token + ", user=" + user + ", expiryDate=" + expiryDate
				+ "]";
	}
	
	
    
    

}
