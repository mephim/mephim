package com.example.mephim.service.impl;

import com.example.mephim.entity.Category;
import com.example.mephim.repos.CategoryRepo;
import com.example.mephim.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public List<Category> findByMovie(Integer movieId) {
        return categoryRepo.findByMovie(movieId);
    }
}
