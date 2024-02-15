package com.project.demo.service;

import java.util.List;

import com.project.demo.model.Product;

public interface ProductService {
	void saveProduct(Product product);
	List<Product> getAllProduct();
	void deleteProductById(Integer product_id);
	Product searchProductById(Integer product_id);

}
