package com.prodigydx.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="roles")
public class Role<Users> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
@Column(nullable = false, unique = true)
@NotEmpty
private String name;

@ManyToMany(mappedBy = "roles")
private List<Users>users;
	

}
