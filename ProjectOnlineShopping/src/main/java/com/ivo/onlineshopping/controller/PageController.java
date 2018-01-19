package com.ivo.onlineshopping.controller;

import com.ivo.shoppingbackend.dao.CategoryDAO;
import com.ivo.shoppingbackend.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.Path;

@Controller
public class PageController {

    @Autowired
    private CategoryDAO categoryDAO;

    @RequestMapping(value = {"/", "home", "index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Home");

        // passing the list of categories
        mv.addObject("categories", categoryDAO.list());

        mv.addObject("userClickHome", true);
        return mv;
    }

    @RequestMapping(value = "/about")
    public ModelAndView about() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "About us");
        mv.addObject("userClickAbout", true);
        return mv;
    }

    @RequestMapping(value = "/contact")
    public ModelAndView contact() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Contact");
        mv.addObject("userClickContact", true);
        return mv;
    }

    /* Methods to load all products, based on category */

    @RequestMapping(value = "/show/all/products")
    public ModelAndView showAllProducts() {
        ModelAndView mv = new ModelAndView("/page");
        mv.addObject("title", "All Products");

        mv.addObject("categories", categoryDAO.list());

        mv.addObject("userClickAllProducts", true);
        return mv;
    }

    @RequestMapping(value = "/show/category/{categoryId}/products")
    public ModelAndView showProductsByCategory(@PathVariable("categoryId") int categoryId) {
        ModelAndView mv = new ModelAndView("page");

        Category category = null;
        category = categoryDAO.getCategoryById(categoryId);

        mv.addObject("title", category.getName());

        // passing the list of categories
        mv.addObject("categories", categoryDAO.list());

        // passing the single category object
        mv.addObject("category", category);

        mv.addObject("userClickProductsByCategory", true);
        return mv;
    }
}
