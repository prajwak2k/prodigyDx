package com.prodigydx.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodigydx.model.Products;
import com.prodigydx.repository.ProductRepository;
@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	public List<Products> getAllProduct(){
		return repository.findAll();
	}
	public void addProduct(Products products) {
		repository.save(products);
	}
	
	public void removeProductById(long id) {
		repository.deleteById(id);
	}
	public Optional<Products> getProductById(long id){
		return repository.findById(id);
	}
	public List<Products>getAllProductByCategoryId(int id){
		return repository.findAllCategory_id(id);	
	}

}
