package com.chuangdun.hibernate;

import com.chuangdun.hibernate.entity.Category;
import com.chuangdun.hibernate.entity.Product;
import com.chuangdun.hibernate.repository.CategoryRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

/**
 * @author nick
 */
@Log4j2
@SpringBootApplication
public class MyBootApplication implements ApplicationRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(MyBootApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.debug("--------------服务已启动");
        Product product1 = Product.builder().build();
        product1.setName("康师傅方便面");
        Product product2 = Product.builder().build();
        product2.setName("南街村方便面");

        Category category = Category.builder().build();
        category.setName("食品");

        category.getProducts().add(product1);
        category.getProducts().add(product2);

        product1.setCategory(category);
        product2.setCategory(category);

        categoryRepository.save(category);
        Optional<Category> optional = categoryRepository.findById(category.getId());
        if (optional.isPresent()){
            Category category1 = optional.get();
            Product product3 = Product.builder().build();
            product3.setName("卫龙辣条");
            category1.getProducts().add(product3);
            //product3.setCategory(category1);
            categoryRepository.save(category1);
            System.out.println(category1);
        }
    }
}
