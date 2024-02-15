package com.project.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.model.Login;
import com.project.demo.repository.LoginRepository;
import com.project.demo.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginRepository lr;

	@Override
	public Login getByEmail(String email) {
		
		return lr.getByEmail(email);
	}

	@Override
	public void saveUser(Login login) {
		this.lr.save(login);
		
	}

}
