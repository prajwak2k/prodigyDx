package com.prodigydx.model;

import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.JoinColumnOrFormula;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.NonFinal;

//@Entity
@Data
//@Table(name ="users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id ;
	
	@Column(nullable = false)
	private String fristName;
	private String lastName;
	
	@Column(nullable = false,unique = true)
	@Email(message = "{error.invalid_emial}")
	private String email;
	@NotEmpty
	private String password;
	
	
	
	
	public String getFristName() {
		return fristName;
	}
	public void setFristName(String fristName) {
		this.fristName = fristName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	@ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinTable(
			name = "user_Role",
			joinColumns = 	{@JoinColumn(name="USER_ID",referencedColumnName = "ID"}),
					inversesjoinColumns	= {@JoinColumn(name="ROLE_ID",referencedColumnName = "ID")}	
			
			)
	
	private List<Role> roles;
	public Users(Users user) {
		super();
		
		this.fristName = user.getFristName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.roles = user.getRoles();
	}
	
	
	
	
	
	
	
	

}
