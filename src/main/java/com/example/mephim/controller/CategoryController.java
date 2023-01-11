package com.example.mephim.controller;

import com.example.mephim.entity.Category;
import com.example.mephim.entity.Movie;
import com.example.mephim.response.CustomResponse;
import com.example.mephim.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/list-category")
    public ResponseEntity<?> listMovie() {
        List<Category> categoryList = categoryService.findAll();
        if(categoryList.isEmpty()) return new ResponseEntity<>(new CustomResponse<>(10, "data is empty"), HttpStatus.OK);
        return new ResponseEntity<>(new CustomResponse<>(10,categoryList), HttpStatus.OK);
    }
}
