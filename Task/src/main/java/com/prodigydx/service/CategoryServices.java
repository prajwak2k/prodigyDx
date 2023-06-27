package com.prodigydx.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodigydx.model.category;
import com.prodigydx.repository.CategoryRepository;

@Service
public class CategoryServices {
	@Autowired 
	CategoryRepository repository;
	
	public void addCategory( category cat) {
		repository.save(cat);
	}
	
	public List<category> getAllCategory(){
		return repository.findAll();
	}
	
	public void deleteCategoryById(int id) {
		repository.deleteById(id);
		
	}
	
	public Optional<category> getCategoryById(int id){
		return repository.findById(id);
	}
}
