package com.revature.contact.daos;

import com.revature.contact.connection.DatabaseConnection;
import com.revature.contact.models.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO implements CrudDAO<Cart> {
    Connection con = DatabaseConnection.getCon();

    @Override
    public int save(Cart obj) {
        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO carts (total_price, total_quantity, customer_id, cart_id) VALUES (?, ?, ?, ?, ?)");
            ps.setFloat(1, obj.getTotalPrice());
            ps.setFloat(2, obj.getTotalQuantity());
            ps.setInt(3, obj.getCustomerId());
            ps.setInt(4, obj.getCartItemId());


            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n;
    }

    @Override
    public List<Cart> findAll() {
        return null;
    }

    @Override
    public Cart findById(int id) {
        return null;
    }

    @Override
    public List<Cart> findAllById(int id) {
        return null;
    }

    @Override
    public boolean update(Cart updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }


    //@Override
    public boolean removeCartById(int id) {
        try {
            PreparedStatement ps = con.prepareStatement("delete from carts where customer_id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Cart> findCart() {
        List<Cart> cartList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM carts WHERE customer_id = ?");
            //ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cart cart = new Cart();

                cart.setId(rs.getInt("id"));
                cart.setTotalPrice(rs.getFloat("total_price"));
                cart.setTotalQuantity(rs.getInt("total_quantity"));
                cart.setCustomerId(rs.getInt("customer_id"));
                cart.setCartItemId(rs.getInt("cart_items_id"));


                cartList.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cartList;
    }
}
