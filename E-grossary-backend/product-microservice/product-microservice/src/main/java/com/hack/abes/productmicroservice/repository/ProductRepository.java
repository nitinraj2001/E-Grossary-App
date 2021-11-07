package com.hack.abes.productmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hack.abes.productmicroservice.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
