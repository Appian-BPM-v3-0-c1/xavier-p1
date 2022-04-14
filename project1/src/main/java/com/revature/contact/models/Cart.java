package com.revature.contact.models;

public class Cart {
    private int id;
    private float totalPrice;
    private int totalQuantity;
    private int customerId;
    private int cartItemId;

    public Cart() {
    }

    public Cart(int id, float totalPrice, int totalQuantity, int customerId, int cartItemId) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.customerId = customerId;
        this.cartItemId = cartItemId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", totalQuantity=" + totalQuantity +
                ", customerId=" + customerId +
                ", cartItemId=" + cartItemId +
                '}';
    }
}
