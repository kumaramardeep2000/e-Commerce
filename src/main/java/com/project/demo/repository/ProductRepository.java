package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
