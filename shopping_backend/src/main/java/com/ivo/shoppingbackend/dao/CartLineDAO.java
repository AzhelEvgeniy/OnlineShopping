package com.ivo.shoppingbackend.dao;

import com.ivo.shoppingbackend.dto.Cart;
import com.ivo.shoppingbackend.dto.CartLine;

import java.util.List;

public interface CartLineDAO {

    // common
    public CartLine get(int id);
    public boolean add(CartLine cartLine);
    public boolean update(CartLine cartLine);
    public boolean delete(CartLine cartLine);
    public List<CartLine> list(int cartId);

    // other business method related to the cart lines
    public List<CartLine> listAvailable(int cardId);
    public CartLine getByCartAndProduct(int cartId, int productId);

    public boolean updateCart(Cart cart);
}
