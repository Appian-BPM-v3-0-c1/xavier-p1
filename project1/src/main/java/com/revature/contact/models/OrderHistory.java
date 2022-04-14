package com.revature.contact.models;

public class OrderHistory {
    private int id;
    private String date;
    private int cartId;

    public OrderHistory() {
    }

    public OrderHistory(int id, String date, int cartId) {
        this.id = id;
        this.date = date;
        this.cartId = cartId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Override
    public String toString() {
        return "OrderHistory{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", cartId=" + cartId +
                '}';
    }
}
