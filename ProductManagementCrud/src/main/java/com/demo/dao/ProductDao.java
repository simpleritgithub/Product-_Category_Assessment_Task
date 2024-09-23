 package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.Model.Category;
import com.demo.Model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{
public  Product findById(int product) ;
List<Product>  findByCategory(Category category);

}
