package com.ivo.onlineshopping.handler;

import com.ivo.onlineshopping.model.RegisterModel;
import com.ivo.shoppingbackend.dao.UserDAO;
import com.ivo.shoppingbackend.dto.Address;
import com.ivo.shoppingbackend.dto.Cart;
import com.ivo.shoppingbackend.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterHandler {

    @Autowired
    private UserDAO userDAO;

    public RegisterModel init() {
        return new RegisterModel();
    }

    public void addUser(RegisterModel registerModel, User user) {
        registerModel.setUser(user);
    }

    public void addBilling(RegisterModel registerModel, Address address) {
        registerModel.setBilling(address);
    }

    public String saveAll(RegisterModel registerModel) {
        String transitionValue = "success";

        // fetch the user
        User user = registerModel.getUser();
        if (user.getRole().equals("USER")) {
            Cart cart = new Cart();
            cart.setUser(user);
            user.setCart(cart);
        }

        // save the user
        userDAO.addUser(user);

        // get the address
        Address billing = registerModel.getBilling();
        billing.setUserId(user.getId());
        billing.setBilling(true);

        // save the address
        userDAO.addAddress(billing);

        return transitionValue;
    }

}
