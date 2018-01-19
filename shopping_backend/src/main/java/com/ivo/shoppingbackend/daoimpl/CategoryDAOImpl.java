package com.ivo.shoppingbackend.daoimpl;

import com.ivo.shoppingbackend.dao.CategoryDAO;
import com.ivo.shoppingbackend.dto.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

    private static List<Category> categories = new ArrayList<>();

    static {

        // first
        Category category = new Category();
        category.setId(1);
        category.setName("Television");
        category.setDescription("Television description");
        category.setImageUrl("CAT_1.png");

        categories.add(category);

        // second
        category = new Category();
        category.setId(1);
        category.setName("Mobile");
        category.setDescription("Mobile description");
        category.setImageUrl("CAT_2.png");

        categories.add(category);

        // third
        category = new Category();
        category.setId(1);
        category.setName("Laptop");
        category.setDescription("Laptop description");
        category.setImageUrl("CAT_3.png");

        categories.add(category);
    }

    @Override
    public List<Category> list() {
        return categories;
    }

}
