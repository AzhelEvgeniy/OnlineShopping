package com.ivo.shoppingbackend.daoimpl;

import com.ivo.shoppingbackend.dao.ProductDAO;
import com.ivo.shoppingbackend.dto.Product;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

public class ProductDAOImplTest {

    private static AnnotationConfigApplicationContext context;

    private static ProductDAO productDAO;

    private Product product;

    @BeforeClass
    public static void init() {
        context = new AnnotationConfigApplicationContext();
        context.scan("com.ivo.shoppingbackend");
        context.refresh();
        productDAO = (ProductDAO) context.getBean("productDAO");
    }

    @Test
    public void testCRUDProduct() {

        // created
       /* product = new Product();
        product.setName("Oppo Selfie S53");
        product.setBrand("Oppo");
        product.setDescription("This is test descr");
        product.setUnitPrice(25000);
        product.setActive(true);
        product.setCategoryId(3);
        product.setSupplierId(3);

        assertEquals("Something went wrong while inserting a new product!",
                true, productDAO.add(product));

        // getted, updated
        product = productDAO.get(13);
        product.setName("Samsung Galaxy s7");
        assertEquals("Something went wrong while updating the existing record!",
                true, productDAO.update(product));

        // deleted
        assertEquals("Something went wrong while deleting the existing record!",
                true, productDAO.delete(product));

        // list
        assertEquals("Something went wrong while fetching the list of existing record!",
                13, productDAO.list().size());*/
    }

    @Test
    public void testListActiveProducts() {
        assertEquals("Something went wrong while fetching the list of existing record!",
                11, productDAO.listActiveProducts().size());
    }

    @Test
    public void testListActiveProductsByCategories() {
        assertEquals("Something went wrong while fetching the list of existing record!",
                4, productDAO.listActiveProductsByCategories(1).size());
    }

    @Test
    public void testGetLatestActiveProducts() {
        assertEquals("Something went wrong while fetching the list of existing record!",
                5, productDAO.getLatestActiveProducts(5).size());
    }


}
