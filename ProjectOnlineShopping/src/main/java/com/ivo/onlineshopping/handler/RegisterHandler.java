package com.ivo.onlineshopping.handler;

import com.ivo.onlineshopping.model.RegisterModel;
import com.ivo.shoppingbackend.dao.UserDAO;
import com.ivo.shoppingbackend.dto.Address;
import com.ivo.shoppingbackend.dto.Cart;
import com.ivo.shoppingbackend.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class RegisterHandler {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public RegisterModel init() {
        return new RegisterModel();
    }

    public void addUser(RegisterModel registerModel, User user) {
        registerModel.setUser(user);
    }

    public void addBilling(RegisterModel registerModel, Address address) {
        registerModel.setBilling(address);
    }

    public String validateUser(User user, MessageContext error) {
        String transitionValue = "success";

        // checking if password matches confirm password
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            error.addMessage(new MessageBuilder()
                    .error()
                    .source("confirmPassword")
                    .defaultText("Password does not macth the confirm password!")
                    .build());

            transitionValue = "failure";
        }

        // check the uniqueness of the email id
        if (userDAO.getByEmail(user.getEmail()) != null) {
            error.addMessage(new MessageBuilder()
                    .error()
                    .source("email")
                    .defaultText("Email address is already used!")
                    .build());

            transitionValue = "failure";
        }

        return transitionValue;
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

        // encode the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

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
