package com.ivo.shoppingbackend.dao;

import com.ivo.shoppingbackend.dto.Address;
import com.ivo.shoppingbackend.dto.User;

import java.util.List;

public interface UserDAO {

    // add an user
    boolean addUser(User user);

    User getByEmail(String email);

    // add an address
    boolean addAddress(Address address);

    // alternative
    Address getBillingAddress(int userId);

    List<Address> listShippingAddresses(int userId);
}
