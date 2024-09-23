package com.demo.service;

import java.util.List;

import com.demo.Model.Category;

public interface CategoryService {
	
	public Category create(Category category);
	public void delete(int categoryId);
	public Category getById(int Category);
	public List<Category>viewAllCategory();
	public Category updateCategory(int Cid, Category newc);

	
	
	
	
	
	
	
}
