package com.project.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.model.Admin;
import com.project.demo.repository.AdminRepository;
import com.project.demo.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository ar;
	@Override
	public Admin getByEmail(String email) {
		return ar.findByEmail(email);
		
	}

}
