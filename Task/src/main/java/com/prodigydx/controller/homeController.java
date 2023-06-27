package com.prodigydx.controller;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.prodigydx.model.category;
import com.prodigydx.service.CategoryServices;
import com.prodigydx.service.ProductService;

@Controller
public class homeController {
@Autowired
CategoryServices services;
 @Autowired 
 ProductService productService;
 @GetMapping({"/","/home"})
 public String home(Model model) {
 return "index"; 
 }
 @GetMapping("/shop")
 public String shop(Model model) {
	 model.addAttribute("categories", services.getAllCategory());
	 model.addAttribute("products", productService.getAllProduct());
	 return "shop";
 }
 @GetMapping("/shop/category/{id}")
 public String shopByCategory(Model model,@PathVariable int id) {
	 model.addAttribute("categories", services.getAllCategory());
	 model.addAttribute("products", productService.getAllProductByCategoryId(id));
	 return "shop";
 }
 @GetMapping("/shop/viewproduct/{id}")
 public String viewProduct(Model model,@PathVariable int id) {
	 model.addAttribute("product" , productService.getProductById(id).get());
	 return "viewProduct";
 }
 
 
 
 
 
 
 
 
 
}
