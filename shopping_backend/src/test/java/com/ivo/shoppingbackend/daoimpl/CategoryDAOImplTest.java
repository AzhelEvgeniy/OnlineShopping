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
        /*category = new Category();

        category.setName("Television");
        category.setDescription("Television description");
        category.setImageUrl("CAT_1.png");

        assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));*/
    }

    @Test
    public void testGetCategory() {
        /*Category television = categoryDAO.get(3);

        String expectedName = "Television";

        assertEquals("Successfully fetched a category from the table!", expectedName, television.getName());*/
    }

    @Test
    public void testUpdateCategory() {
        /*category = categoryDAO.get(1);
        category.setName("UpdatedTest");

        assertEquals("Successfully updated a category inside the table!", true, categoryDAO.update(category));*/
    }

    @Test
    public void testDeleteCategory() {
        /*category = categoryDAO.get(1);

        assertEquals("Successfully deleted a category inside the table!", true, categoryDAO.delete(category));*/
    }

    @Test
    public void testListCategory() {
        //assertEquals("Successfully fetched the list of categories from the table!", 2, categoryDAO.list().size());
    }

    @Test
    public void testCRUDCategory() {
        // added
        category = new Category();
        category.setName("Television");
        category.setDescription("Television description");
        category.setImageUrl("CAT_1.png");
        assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));

        // getted
        Category television = categoryDAO.get(1);
        String expectedName = "Television";
        assertEquals("Successfully fetched a category from the table!", expectedName, television.getName());

        // updated
        category = categoryDAO.get(1);
        category.setName("UpdatedTest");
        assertEquals("Successfully updated a category inside the table!", true, categoryDAO.update(category));

        // deleted
        category = categoryDAO.get(1);
        assertEquals("Successfully deleted a category inside the table!", true, categoryDAO.delete(category));
    }

}
