package com.revature.contact.daos;

import com.revature.contact.connection.DatabaseConnection;
import com.revature.contact.models.Cart;
import com.revature.contact.models.OrderHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderHistoryDAO implements CrudDAO<OrderHistory>{
    Connection con = DatabaseConnection.getCon();

    @Override
    public int save(OrderHistory obj) {
        return 0;
    }

    @Override
    public List<OrderHistory> findAll() {
        return null;
    }

    @Override
    public OrderHistory findById(int id) {
        return null;
    }

    @Override
    public List<Cart> findAllById(int id) {
        return null;
    }

    @Override
    public boolean update(OrderHistory updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

    public List<OrderHistory> findByOrderHistory(int id) {
        List<OrderHistory> historyList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM cart WHERE customer_id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                OrderHistory orderHistory = new OrderHistory();

                orderHistory.setId(rs.getInt("id"));
                orderHistory.setDate(rs.getString("date"));
                orderHistory.setCartId(rs.getInt("carts_id"));

                historyList.add(orderHistory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return historyList;
    }
}
