package com.ivo.shoppingbackend.daoimpl;

import com.ivo.shoppingbackend.dao.CategoryDAO;
import com.ivo.shoppingbackend.dto.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

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
        category.setId(2);
        category.setName("Mobile");
        category.setDescription("Mobile description");
        category.setImageUrl("CAT_2.png");

        categories.add(category);

        // third
        category = new Category();
        category.setId(3);
        category.setName("Laptop");
        category.setDescription("Laptop description");
        category.setImageUrl("CAT_3.png");

        categories.add(category);
    }

    @Override
    @Transactional
    public boolean add(Category category) {
        try {
            sessionFactory.getCurrentSession().persist(category);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Category> list() {
        return categories;
    }

    @Override
    public Category getCategoryById(int id) {
        for (Category c : categories) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

}
