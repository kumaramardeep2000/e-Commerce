package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	Admin findByEmail(String email);

}
