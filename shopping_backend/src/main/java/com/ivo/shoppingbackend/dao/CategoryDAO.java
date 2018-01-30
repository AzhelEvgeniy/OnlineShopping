package com.ivo.shoppingbackend.dao;

import com.ivo.shoppingbackend.dto.Category;

import java.util.List;

public interface CategoryDAO {

    boolean add(Category category);

    List<Category> list();

    Category getCategoryById(int id);
}
