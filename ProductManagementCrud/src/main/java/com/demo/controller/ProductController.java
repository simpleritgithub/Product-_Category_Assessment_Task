package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Model.Product;
import com.demo.service.ProductService;

@RestController
@RequestMapping("/Product")
public class ProductController {
	
	@Autowired
	private ProductService ps;
	//ViewAllCategory
	 @GetMapping("/viewAll")
	    public ResponseEntity<List<Product>> viewAllProduct(@RequestParam(required = false, defaultValue = "0") int pageNumber, @RequestParam(required = false, defaultValue = "0") int pageSize)
	             {

//		 var pageNumber = 2;
//		 var pageSize = 5;
		
	        
	        List<Product> viewAll = ps.viewAllProduct();
	        
	        if(pageNumber == 0) {
	        	return ResponseEntity.ok(viewAll); 
	        }
	        
	        if (!viewAll.isEmpty()) {
	        	
	        	var startFrom = (pageNumber * pageSize) - pageSize;
	        	var end = (pageNumber * pageSize);
	        	
	        	List<Product> ll = new ArrayList<>();
	        	
	        	if(viewAll.size() > startFrom) {
	        	for(int i=startFrom;i<Math.min(end, viewAll.size());i++) {
	        		ll.add(viewAll.get(i));
	        	}
	        	}
	            return ResponseEntity.ok(ll);
	        } else {
	            return ResponseEntity.noContent().build();
	        }
	    }
	


	
	//AddProduct
	@PostMapping("/AddProduct")
	public ResponseEntity<Product> CreateProduct(@RequestBody Product product) {
	    Product savedProduct = ps.create(product);
	    
	    if (savedProduct!= null) {
	        return ResponseEntity.ok(savedProduct);
	    } else {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	    }
	}
	
	//getProductById
		@GetMapping("/viewProductById/{ProductId}")
		public ResponseEntity<Product> viewProductById(@PathVariable int ProductId ){
		    Product product = ps.findProductById(ProductId);
		    if (product != null) {
		        return ResponseEntity.ok(product);
		    } else {
		        return ResponseEntity.notFound().build();
		    }
		}
		//UpdateProduct
		@PutMapping("/update/{productID}")
		 public ResponseEntity<Product> updateproduct(@PathVariable int productID,	@RequestBody Product newproduct ){
			Product updateProduct = ps.updateProduct(productID, newproduct);
			return new ResponseEntity<Product>(updateProduct,HttpStatus.ACCEPTED);
			 
		 }
		//DeleteCategoryById
		@DeleteMapping("/DeleteById/{id}")
				public ResponseEntity<String> deleteByID(@PathVariable int id) {
				    boolean deleted = ps.deleteProduct(id);
				    if (deleted) {
				        return ResponseEntity.ok("Product with ID " + id + " deleted successfully.");
				    } else {
				        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with ID " + id + " not found.");
				    }
			}
		//MappedProductByCategoryId
		@PostMapping("/AddProduct/{catId}")
		public ResponseEntity<Product> MappedProductCategory(@RequestBody Product product, @PathVariable int catId) {
		    Product savedProduct = ps.addProduct(product, catId);
		    
		    if (savedProduct != null) {
		        return ResponseEntity.ok(savedProduct);
		    } else {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		    }
		}
	  //getProductByCategory
       @GetMapping("/getProductByCategory/{catId}")
        public ResponseEntity<List<Product>> getProductByCategory(@PathVariable int catId) {
        List<Product> products = this.ps.FindProductByCategories(catId);
        if (!products.isEmpty()) {
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
	
	
	
}
