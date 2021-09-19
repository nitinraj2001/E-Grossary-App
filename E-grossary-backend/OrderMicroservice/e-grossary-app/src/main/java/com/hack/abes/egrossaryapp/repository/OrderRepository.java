package com.hack.abes.egrossaryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hack.abes.egrossaryapp.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
