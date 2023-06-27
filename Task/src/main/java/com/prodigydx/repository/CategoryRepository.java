package com.prodigydx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodigydx.model.category;

public interface CategoryRepository extends JpaRepository<category, Integer> {

}
