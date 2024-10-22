package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Model.Category;
import com.demo.Model.Product;
import com.demo.dao.CategoryDao;

@Service
public class CategoryServiceImpl implements CategoryService {
    
    @Autowired
    private CategoryDao cd;

    @Override
    public Category create(Category category) {
        return cd.save(category);
    }

	@Override
	public Category updateCategory(int Cid, Category newc) {
	    Category existingCategory= cd.findById(Cid);
	    if (existingCategory != null) {
	        existingCategory.setTitle(newc.getTitle());
	       
	        
	        return cd.save(existingCategory);
	    }
		return existingCategory;  
	    }
	    
	    @Override
		public void delete(int categoryId) {
			cd.deleteById(categoryId);
			
		}


    @Override
    public Category getById(int categoryId) {
        Category optionalCategory = cd.findById(categoryId);
        return optionalCategory;
    }

    @Override
    public List<Category> viewAllCategory() {
        return cd.findAll();
    }

	
  
	}

	

