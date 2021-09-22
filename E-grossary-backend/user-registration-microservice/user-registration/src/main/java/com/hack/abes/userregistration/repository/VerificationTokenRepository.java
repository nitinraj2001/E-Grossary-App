package com.hack.abes.userregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hack.abes.userregistration.model.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

	public VerificationToken findByToken(String token);
}
