package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.Model.Category;
import com.demo.Model.Product;

public interface ProductService {
	
	public Product addProduct(Product product, int catId);
	public Product create(Product product);
	public List<Product> viewAllProduct();
	 public Product findProductById(int productId);
	 boolean deleteProduct(int productId);
	 public Product updateProduct(int pid, Product newp);
//	 List<Product> getProductByCategory(int catId);
	 public List<Product>FindProductByCategories(int catid);
	
	
}
