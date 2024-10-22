package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.Model.Category;
import com.demo.Model.Product;

@Repository

public interface CategoryDao extends JpaRepository<Category, Integer> {
  
	public  Category findById(int category) ;
}
 