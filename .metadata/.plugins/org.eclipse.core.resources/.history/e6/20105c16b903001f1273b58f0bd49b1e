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

import com.demo.Model.Category;
import com.demo.Model.Product;
import com.demo.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
    
    @Autowired
    private CategoryService cs;
    
    //View All Category
    @GetMapping("/ViewAllCategory")
    public ResponseEntity<List<Category>> getAllCategories(
        @RequestParam(required = false, defaultValue = "0") int pageNumber,
        @RequestParam(required = false, defaultValue = "0") int pageSize) {

        List<Category> allCategories = cs.viewAllCategory();

        if (pageNumber <= 0 || pageSize <= 0) {
            return ResponseEntity.ok(allCategories);
        }

        if (!allCategories.isEmpty()) {
            int startIndex = (pageNumber - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, allCategories.size());

            if (startIndex < endIndex) {
                List<Category> paginatedCategories = allCategories.subList(startIndex, endIndex);
                return ResponseEntity.ok(paginatedCategories);
            }
        }

        return ResponseEntity.noContent().build();
    }

    
    
    //CreateCategoey
    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category createdCategory = cs.create(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }
    
    //ViewCategoryById
    @GetMapping("/getById/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
        Category category = cs.getById(id);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    //updateCategoryById
    @PutMapping("/update/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id,@RequestBody Category newCategory) {
        Category updatedCategory = cs.updateCategory(id, newCategory);
        return new ResponseEntity<Category>(updatedCategory,HttpStatus.OK);
    }
    
    //DeleteCategoryById
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        cs.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
 
   
}
