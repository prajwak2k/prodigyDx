package com.prodigydx.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.util.Optional;

import org.apache.tomcat.util.http.fileupload.impl.IOFileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.prodigydx.dto.ProductDto;
import com.prodigydx.model.Products;
import com.prodigydx.model.category;
import com.prodigydx.service.CategoryServices;
import com.prodigydx.service.ProductService;

@Controller
public class AdminController {
	@Autowired
	CategoryServices service;
	@Autowired
	ProductService service2;
	
	
	
	
	@GetMapping("/home")
	public String homePage() {
		return"home";
	}
	
	@GetMapping("/admin/categories")
	public String getCat(org.springframework.ui.Model model) {
		model.addAttribute("categories" ,service.getAllCategory());
		return"categories";
	}
	@GetMapping("/admin/categories/add")
	public String getAddCat(org.springframework.ui.Model model1) {
		model1.addAttribute ("category",new category());
		return"categoriesadd";
	}
	@PostMapping("/admin/categories/add")
	public String postAddCat(@ModelAttribute ("category") category model1) {
		service.addCategory(model1);
		return"redirect:/admin/categories";
	}
	
	@GetMapping("/admin/categories/delete/{id}")
	public String deletecat(@PathVariable int id) {
		service.deleteCategoryById(id);
		return"redirect:/admin/categories";
	}
	@GetMapping("/admin/categories/update/{id}")
	
	public String update(@PathVariable int id, Model model) {
	
		Optional<category> optional = service.getCategoryById(id);
		if(optional.isPresent()) {
			model.addAttribute("category", optional.get());
			return"categoriesadd";
		}
		else {
			return"Data is Not Present";
		}
		
	}
	
	//product Section
	@GetMapping("/admin/products")
	public String products(Model model) {
		model.addAttribute("products",service2.getAllProduct());
		return"products";
	}
	@GetMapping("/admin/products/add")
	public String productsAdd(Model model) {
		model.addAttribute("productsDTO",new ProductDto());
		model.addAttribute("categories" ,service.getAllCategory());
		return"productsAdd";
	}
	
	@PostMapping("/admin/products/add")
	public String productsAddPost(@ModelAttribute("productsDTO") ProductDto dto,@RequestParam("productImage") MultipartFile file, 
			@RequestParam("imgName") String imgName)throws IOException {
		Products products = new Products();
		products.setPname(dto.getPname());
		products.setCategory(service.getCategoryById(dto.getCategoryId()).get());
		products.setQuantity(dto.getQuantity());
		products.setDiscription(dto.getDiscription());
		String imageUUID;
		if(!file.isEmpty()) {
			imageUUID=file.getOriginalFilename();
			Paths fileNameAndPath = Paths.get(uploadDir,imageUUID);
			Files.write(fileNameAndPath, file.getBytes());
		}else {
			imageUUID=imgName;
			
		}
		products.setImages(imageUUID);
		service2.addProduct(products);
		return "redirect:/admin/products";
		
	}
	
	
	public static Stirng uploadDir = System.getProperty("user.dir") +"src/main/java/resorces/static/images/productImages";
			


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
