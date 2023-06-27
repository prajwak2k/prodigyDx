package com.prodigydx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodigydx.model.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {
	
	List<Products> findAllCategory_id (int id);

}
