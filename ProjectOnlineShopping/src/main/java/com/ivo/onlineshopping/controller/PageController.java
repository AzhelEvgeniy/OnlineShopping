package com.ivo.onlineshopping.controller;

import com.ivo.onlineshopping.exception.ProductNotFoundException;
import com.ivo.shoppingbackend.dao.CategoryDAO;
import com.ivo.shoppingbackend.dao.ProductDAO;
import com.ivo.shoppingbackend.dto.Category;
import com.ivo.shoppingbackend.dto.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.Path;

@Controller
public class PageController {

    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(value = {"/", "home", "index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Home");

        logger.info("Inside PageController index method - INFO");
        logger.debug("Inside PageController index method - DEBUG");

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
        category = categoryDAO.get(categoryId);

        mv.addObject("title", category.getName());

        // passing the list of categories
        mv.addObject("categories", categoryDAO.list());

        // passing the single category object
        mv.addObject("category", category);

        mv.addObject("userClickProductsByCategory", true);
        return mv;
    }

    /*
    * Viewing a single product
    * */

    @RequestMapping(value = "/show/{id}/product")
    public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
        ModelAndView mv = new ModelAndView("page");

        Product product = productDAO.get(id);

        if (product == null) throw new ProductNotFoundException();

        // update the view count
        int countView = product.getViews();
        product.setViews(countView++);
        productDAO.update(product);
        // ------------------

        mv.addObject("title", product.getName());
        mv.addObject("product", product);

        mv.addObject("userClickShowProduct", true);

        return mv;
    }


    /* having a similar mapping to our flow id */
    @RequestMapping(value = "/register")
    public ModelAndView register() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Sign Up");
        return mv;
    }

    /* Login spring security */
    @RequestMapping(value = "/login")
    public ModelAndView login(@RequestParam(name = "error", required = false) String error) {
        ModelAndView mv = new ModelAndView("login");

        if (error != null) {
            mv.addObject("message", "Invalid Username and Password!");
        }

        mv.addObject("title", "Login");
        return mv;
    }

    /* access denied page */
    @RequestMapping(value = "/access-denied")
    public ModelAndView access_denied() {
        ModelAndView mv = new ModelAndView("error");

        mv.addObject("title", "403 - Acess Denied");
        mv.addObject("errorTitle", "Aha, you are caught!");
        mv.addObject("errorDescription", "You are not authorized to view this page!");

        return mv;
    }
}
