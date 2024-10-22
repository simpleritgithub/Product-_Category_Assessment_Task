package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Model.Category;
import com.demo.Model.Product;
import com.demo.dao.CategoryDao;
import com.demo.dao.ProductDao;

@Service
public  class ProductServicveImpl implements ProductService {
	
	@Autowired
	private ProductDao pd;
	
	
	@Autowired
	private CategoryDao cd;
	
	 @Override
	    public Product create(Product product) {
	        return pd.save(product);
	    }
	 
	@Override
	public Product addProduct(Product product, int catId) {
	    Category categoryOptional = cd.findById(catId);
	    
	    if (categoryOptional!=null) {
	        Category category = categoryOptional;
	        product.setCategory(category);
	        return pd.save(product);
	    } else {
	       
	        return null;
	    }
	
	}
	
	 @Override
	    public List<Product> viewAllProduct() {
	       

	   
	        List<Product> productList =pd.findAll();

	        return productList;
	    }


	@Override
	public Product findProductById(int productId) {
		 return pd.findById(productId);
	}


	@Override
	public boolean deleteProduct(int productId) {
	    try {
	        pd.deleteById(productId);
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}




	@Override
	public Product updateProduct(int pid, Product newp) {
	    Product existingProduct = pd.findById(pid);
	    if (existingProduct != null) {
	        existingProduct.setProductName(newp.getProductName());
	        existingProduct.setProductPrice(newp.getProductPrice());
	        existingProduct.setStock(newp.getStock());
	        existingProduct.setProductDesc(newp.getProductDesc());
	        
	        return pd.save(existingProduct);
	    } else {
	        
	        return null;
	    }
	}
	  public List<Product>FindProductByCategories(int catid){
		Category cat =   this.cd.findById(catid);
		List<Product>findByCategory =  this.pd.findByCategory(cat);
		return findByCategory;
	    	
	    }







	 





	
}









	


	
	
	

