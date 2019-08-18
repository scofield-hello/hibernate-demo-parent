package com.chuangdun.hibernate.repository;

import com.chuangdun.hibernate.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
