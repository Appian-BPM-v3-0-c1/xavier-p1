package com.revature.contact.services;

import com.revature.contact.daos.CartDAO;

public class CartService {
    private final CartDAO cartDAO;

    public CartService(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    public CartDAO getCartDAO() {
        return getCartDAO();
    }
}
