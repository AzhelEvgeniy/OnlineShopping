package com.ivo.onlineshopping.service;

import com.ivo.onlineshopping.model.UserModel;
import com.ivo.shoppingbackend.dao.CartLineDAO;
import com.ivo.shoppingbackend.dao.ProductDAO;
import com.ivo.shoppingbackend.dto.Cart;
import com.ivo.shoppingbackend.dto.CartLine;
import com.ivo.shoppingbackend.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service("cartService")
public class CartService {

    @Autowired
    private CartLineDAO cartLineDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private HttpSession httpSession;

    // return the cart of the user who has logged in
    private Cart getCart() {
        return ((UserModel) httpSession.getAttribute("userModel")).getCart();
    }

    // returns the entire cart lines
    public List<CartLine> getCartLines() {
        return cartLineDAO.list(this.getCart().getId());
    }

    public String updateCartLine(int cartLineId, int count) {
        // fetch the cart line
        CartLine cartLine = cartLineDAO.get(cartLineId);
        if (cartLine == null) {
            return "result=error";
        } else {
            Product product = cartLine.getProduct();

            double oldTotal = cartLine.getTotal();

            if (product.getQuantity() <= count) {
                count = product.getQuantity();
            }

            cartLine.setProductCount(count);
            cartLine.setBuyingPrice(product.getUnitPrice());
            cartLine.setTotal(product.getUnitPrice() * count);

            cartLineDAO.update(cartLine);

            Cart cart = this.getCart();
            cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
            cartLineDAO.updateCart(cart);

            return "result=updated";
        }
    }

    public String deleteCartLine(int cartLineId) {
        // fetch the cart line
        CartLine cartLine = cartLineDAO.get(cartLineId);

        if (cartLine == null) {
            return "result=error";
        } else {
            // update the cart
            Cart cart = this.getCart();
            cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
            cart.setCartLines(cart.getCartLines() - 1);
            cartLineDAO.updateCart(cart);

            // remove the cart line
            cartLineDAO.delete(cartLine);

            return "result=deleted";
        }
    }

    public String addCartLine(int productId) {
        String response = "error";

        Cart cart = this.getCart();

        CartLine cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), productId);
        if (cartLine == null) {
            // add a new cartLine
            cartLine = new CartLine();

            // fetch the product
            Product product = productDAO.get(productId);

            cartLine.setCartId(cart.getId());
            cartLine.setProduct(product);
            cartLine.setBuyingPrice(product.getUnitPrice());
            cartLine.setProductCount(1);
            cartLine.setTotal(product.getUnitPrice());
            cartLine.setAvailable(true);

            cartLineDAO.add(cartLine);

            cart.setCartLines(cart.getCartLines() + 1);
            cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
            cartLineDAO.updateCart(cart);

            response = "result=added";
        }

        return response;
    }
}
