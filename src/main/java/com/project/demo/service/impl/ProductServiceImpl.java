package com.project.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.model.Product;
import com.project.demo.repository.ProductRepository;
import com.project.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository pr;

	@Override
	public void saveProduct(Product product) {
		this.pr.save(product);

	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public void deleteProductById(Integer product_id) {
		this.pr.deleteById(product_id);
		
	}

	@Override
	public Product searchProductById(Integer product_id) {
		
		return pr.getById(product_id);
	}

	

}
