package com.hack.abes.userregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hack.abes.userregistration.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
