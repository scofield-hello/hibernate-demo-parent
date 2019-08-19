package com.chuangdun.hibernate.service;

import com.chuangdun.hibernate.entity.Category;

import java.util.List;

public interface CategoryService {

    Category save(Category category);

    List<Category> findAll();

    void delete(Category category);

    void deleteById(Long id);
}
