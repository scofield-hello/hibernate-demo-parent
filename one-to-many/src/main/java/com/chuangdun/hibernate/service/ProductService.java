package com.chuangdun.hibernate.service;

import com.chuangdun.hibernate.entity.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    List<Product> findAll();
}
