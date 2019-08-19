package com.chuangdun.hibernate;

import com.chuangdun.hibernate.entity.Category;
import com.chuangdun.hibernate.entity.Product;
import com.chuangdun.hibernate.service.CategoryService;
import com.chuangdun.hibernate.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OneToManyTest {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @Test
    public void testServiceNotNull() {
        Assert.assertNotNull(categoryService);
        Assert.assertNotNull(productService);
    }

    /**
     * @Test public void testInsertCategory(){
     * Category category = Category.builder().build();
     * category.setName("食品");
     * category = categoryService.save(category);
     * Assert.assertNotNull(category.getId());
     * }
     * @Test public void testInsertProduct(){
     * List<Category> categories = categoryService.findAll();
     * Category category = categories.get(0);
     * Product product1 = Product.builder().build();
     * product1.setName("康师傅方便面");
     * Product product2 = Product.builder().build();
     * product2.setName("南街村方便面");
     * product1.setCategory(category);
     * product2.setCategory(category);
     * <p>
     * product1 = productService.save(product1);
     * product2 =productService.save(product2);
     * <p>
     * Assert.assertNotNull(product1.getId());
     * Assert.assertNotNull(product2.getId());
     * }
     */

    @Test
    public void testCascadeRemoveCategory() {
        List<Category> categories = categoryService.findAll();
        System.out.println(categories);
        Category category = categories.get(0);
        List<Product> products = productService.findAll();
        System.out.println(products);
        categoryService.deleteById(category.getId());
        /*categories = categoryService.findAll();
        Assert.assertTrue(categories.isEmpty());
        products = productService.findAll();
        Assert.assertTrue(products.isEmpty());*/
    }
}
