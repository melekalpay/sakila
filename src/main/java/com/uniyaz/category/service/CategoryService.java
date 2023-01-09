package com.uniyaz.category.service;

import com.uniyaz.category.domain.Category;
import com.uniyaz.category.dao.CategoryDao;
import com.uniyaz.category.queryfilterdto.CategoryQueryFilterDto;

import java.util.List;

public class CategoryService {
    public List<Category> findAll() {
        CategoryDao categoryDao = new CategoryDao();
        return categoryDao.findAll();
    }
    public Category save(Category category) {
        CategoryDao categoryDao = new CategoryDao();
        return categoryDao.save(category);
    }
    public void delete(Category category) {
        CategoryDao categoryDao = new CategoryDao();
        categoryDao.delete(category);
    }
    public List<Category> findByName(String name) {
        CategoryDao categoryDao = new CategoryDao();
        return categoryDao.findAllByName(name);
    }
    public List<Category> findAllByQueryFilterDto(CategoryQueryFilterDto categoryQueryFilterDto) {
        CategoryDao categoryDao = new CategoryDao();
        return categoryDao.findAllByQueryFilterDto(categoryQueryFilterDto);
    }
}
