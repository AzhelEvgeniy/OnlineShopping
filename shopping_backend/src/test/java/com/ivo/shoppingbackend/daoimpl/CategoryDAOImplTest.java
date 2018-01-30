package com.ivo.shoppingbackend.daoimpl;

import com.ivo.shoppingbackend.dao.CategoryDAO;
import com.ivo.shoppingbackend.dto.Category;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

public class CategoryDAOImplTest {

    private static AnnotationConfigApplicationContext context;

    private static CategoryDAO categoryDAO;

    private Category category;

    @BeforeClass
    public static void init() {
        context = new AnnotationConfigApplicationContext();
        context.scan("com.ivo.shoppingbackend");
        context.refresh();
        categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
    }

    @Test
    public void testAddCategory() {
        category = new Category();

        category.setName("Television");
        category.setDescription("Television description");
        category.setImageUrl("CAT_1.png");

        assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));
    }

}
