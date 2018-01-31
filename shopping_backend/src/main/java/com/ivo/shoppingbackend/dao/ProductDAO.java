package com.ivo.shoppingbackend.dao;

import com.ivo.shoppingbackend.dto.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> list();

    Product get(int id);
    boolean add(Product product);
    boolean update(Product product);
    boolean delete(Product product);

    // business methods
    List<Product> listActiveProducts();
    List<Product> listActiveProductsByCategories(int categoryId);
    List<Product> getLatestActiveProducts(int count);

}
