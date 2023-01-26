package com.example.mephim.service;

import com.example.mephim.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    List<Category> findByMovie(Integer movieId);
}
