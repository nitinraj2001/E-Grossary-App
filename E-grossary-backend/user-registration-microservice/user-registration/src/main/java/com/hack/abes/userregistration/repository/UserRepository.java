package com.hack.abes.userregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hack.abes.userregistration.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
