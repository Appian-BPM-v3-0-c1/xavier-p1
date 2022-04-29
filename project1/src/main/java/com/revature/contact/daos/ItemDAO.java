package com.revature.contact.daos;

import com.revature.contact.connection.DatabaseConnection;
import com.revature.contact.models.Cart;
import com.revature.contact.models.Items;
import com.revature.contact.models.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO implements CrudDAO<Items> {
    Connection con = DatabaseConnection.getCon();

    @Override
    public int save(Items obj) {
        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO items (name, price, stock, brand, departments_id) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, obj.getName());
            ps.setFloat(2, obj.getPrice());
            ps.setInt(3, obj.getStock());
            ps.setString(4, obj.getBrand());
            ps.setInt(5, obj.getDepartmentsId());

            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n;
    }

    @Override
    public List<Items> findAll() {
        return null;
    }

    @Override
    public Items findById(int id) {
        return null;
    }

    @Override
    public List<Cart> findAllById(int id) {
        return null;
    }

    @Override
    public boolean update(Items updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

    public List<Items> findAllByName(String name) {
        List<Items> items = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM items WHERE name LIKE ?");
            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Items item = new Items();

                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setPrice(rs.getFloat("price"));
                item.setStock(rs.getInt("stock"));
                item.setBrand(rs.getString("brand"));
                item.setDepartmentsId(rs.getInt("departments_id"));

                items.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<Items> findAllItems() {
        List<Items> items = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM items");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Items item = new Items();

                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setPrice(rs.getFloat("price"));
                item.setStock(rs.getInt("stock"));
                item.setBrand(rs.getString("brand"));
                item.setDepartmentsId(rs.getInt("departments_id"));

                items.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
    public List<Items> findAllByBrand(String brand) {
        List<Items> items = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM items WHERE brand LIKE ?");
            ps.setString(1, "%" + brand + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Items item = new Items();

                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setPrice(rs.getFloat("price"));
                item.setStock(rs.getInt("stock"));
                item.setBrand(rs.getString("brand"));
                item.setDepartmentsId(rs.getInt("departments_id"));

                items.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
}