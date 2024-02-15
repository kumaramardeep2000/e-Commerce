package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{
	Login getByEmail(String email);

}
