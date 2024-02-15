package com.project.demo.service;

import com.project.demo.model.Login;

public interface LoginService {
	Login getByEmail(String email); 
	void saveUser(Login login);

}
