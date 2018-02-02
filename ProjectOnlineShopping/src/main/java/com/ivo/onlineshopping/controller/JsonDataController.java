package com.ivo.onlineshopping.controller;

import com.ivo.shoppingbackend.dao.ProductDAO;
import com.ivo.shoppingbackend.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping("/all/products")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productDAO.listActiveProducts();
    }

    @RequestMapping("/admin/all/products")
    @ResponseBody
    public List<Product> getAllProductsForAdmin() {
        return productDAO.list();
    }

    @RequestMapping("/category/{id}/products")
    @ResponseBody
    public List<Product> getProductsByCategory(@PathVariable int id) {
        return productDAO.listActiveProductsByCategories(id);
    }

}
