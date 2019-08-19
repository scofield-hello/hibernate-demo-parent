package com.chuangdun.hibernate.service.impl;

import com.chuangdun.hibernate.entity.Category;
import com.chuangdun.hibernate.repository.CategoryRepository;
import com.chuangdun.hibernate.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }
}
