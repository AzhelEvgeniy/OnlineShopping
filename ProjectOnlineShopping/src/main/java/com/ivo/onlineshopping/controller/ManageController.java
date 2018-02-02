package com.ivo.onlineshopping.controller;

import com.ivo.shoppingbackend.dao.CategoryDAO;
import com.ivo.shoppingbackend.dao.ProductDAO;
import com.ivo.shoppingbackend.dto.Category;
import com.ivo.shoppingbackend.dto.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private ProductDAO productDAO;

    private static final Logger logger = LoggerFactory.getLogger(ManageController.class);

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView showManageProducts(@RequestParam(name="operation", required = false) String opeation) {
        ModelAndView mv = new ModelAndView("page");

        mv.addObject("userClickManageProducts", true);
        mv.addObject("title", "Manage Products");

        Product nProduct = new Product();
        // set few of the fields
        nProduct.setSupplierId(1);
        nProduct.setActive(true);

        mv.addObject("product", nProduct);

        if (opeation != null) {
            if (opeation.equals("product")) {
                mv.addObject("message", "Product Submitted Successfully!");
            }
        }

        return mv;
    }

    // handling product submission
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct,
                                          BindingResult results,
                                          Model model)
    {
        // check if there are any errors
        if (results.hasErrors()) {
            model.addAttribute("userClickManageProducts", true);
            model.addAttribute("title", "Manage Products");
            model.addAttribute("message", "Validation failed for Product Submitted");
            return "page";
        }

        logger.info(mProduct.toString());

        // new product
        productDAO.add(mProduct);

        return "redirect:/manage/products?operation=product";
    }

    // returning categories for all the request mapping
    @ModelAttribute("categories")
    public List<Category> getCategory() {
        return categoryDAO.list();
    }

}
