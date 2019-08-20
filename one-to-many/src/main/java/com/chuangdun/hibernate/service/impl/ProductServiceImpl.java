package com.chuangdun.hibernate.service.impl;

import com.chuangdun.hibernate.entity.Category;
import com.chuangdun.hibernate.entity.Product;
import com.chuangdun.hibernate.repository.ProductRepository;
import com.chuangdun.hibernate.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findOne() {
        Optional<Product> product = productRepository.findById(1L);
        Category category = product.get().getCategory();
        System.out.println(category);
        return product;
    }
}
