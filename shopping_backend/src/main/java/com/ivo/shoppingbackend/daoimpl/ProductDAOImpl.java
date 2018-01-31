package com.ivo.shoppingbackend.daoimpl;

import com.ivo.shoppingbackend.dao.ProductDAO;
import com.ivo.shoppingbackend.dto.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Product> list() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Product", Product.class)
                .getResultList();
    }

    @Override
    public Product get(int id) {
        try {
            return sessionFactory.getCurrentSession().get(
                    Product.class,
                    Integer.valueOf(id));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(Product product) {
        try {
            sessionFactory.getCurrentSession().persist(product);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Product product) {
        try {
            sessionFactory.getCurrentSession().update(product);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Product product) {
        try {
            product.setActive(false);
            return this.update(product);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }


    @Override
    public List<Product> listActiveProducts() {
        String selectActvieProducts = "FROM Product WHERE active = :active";
        return sessionFactory.getCurrentSession()
                .createQuery(selectActvieProducts, Product.class)
                .setParameter("active", true)
                .getResultList();
    }

    @Override
    public List<Product> listActiveProductsByCategories(int categoryId) {
        String selectActvieProductsByCategory = "FROM Product WHERE active = :active AND category_id = :categoryId";
        return sessionFactory.getCurrentSession()
                .createQuery(selectActvieProductsByCategory, Product.class)
                .setParameter("active", true)
                .setParameter("categoryId", categoryId)
                .getResultList();
    }

    @Override
    public List<Product> getLatestActiveProducts(int count) {
        String selectLatestActiveProducts = "FROM Product WHERE active = :active ORDER BY id";
        return sessionFactory.getCurrentSession()
                .createQuery(selectLatestActiveProducts, Product.class)
                .setParameter("active", true)
                .setFirstResult(0)
                .setMaxResults(count)
                .getResultList();
    }
}
