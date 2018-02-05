package com.ivo.shoppingbackend.daoimpl;

import com.ivo.shoppingbackend.dao.UserDAO;
import com.ivo.shoppingbackend.dto.Address;
import com.ivo.shoppingbackend.dto.Cart;
import com.ivo.shoppingbackend.dto.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

public class UserDAOImplTest {

    private static AnnotationConfigApplicationContext context;
    private static UserDAO userDAO;
    private User user = null;
    private Cart cart = null;
    private Address address = null;


    @BeforeClass
    public static void init() {
        context = new AnnotationConfigApplicationContext();
        context.scan("com.ivo.shoppingbackend");
        context.refresh();

        userDAO = (UserDAO) context.getBean("userDAO");
    }

   /* @Test
	public void testAdd() {
		user = new User() ;
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setPassword("123456");

		// add the user
		assertEquals("Failed to add user!",true, userDAO.addUser(user));

		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);

		// link the user with the address using user id
		address.setUserId(user.getId());

		// add the address
		assertEquals("Failed to add address!",true, userDAO.addAddress(address));
	}*/

    /*@Test
	public void testAdd() {
		user = new User() ;
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setPassword("123456");

		if(user.getRole().equals("USER")) {
			// create a cart for this user
			cart = new Cart();

			cart.setUser(user);

			// attach cart with the user
			user.setCart(cart);
		}
		// add the user
		assertEquals("Failed to add user!",true, userDAO.addUser(user));
	}*/

    /*@Test
    public void testGetAddresses() {
        user = userDAO.getByEmail("hr@gmail.com");

        assertEquals("Failed to fetch the list of address and size does not match!",2,
                userDAO.listShippingAddresses(user.getId()).size());

        assertEquals("Failed to fetch the billing address and size does not match!","Mumbai",
                userDAO.getBillingAddress(user.getId()).getCity());
    }*/


}
