package com.revature.contact.daos;

import com.revature.contact.connection.DatabaseConnection;
import com.revature.contact.models.Cart;
import com.revature.contact.models.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class LocationDAO implements CrudDAO<Location> {
    Connection con = DatabaseConnection.getCon();

    @Override
    public int save(Location obj) {
        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO locations (name, street, city, state, zip, phone) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getStreet());
            ps.setString(3, obj.getCity());
            ps.setString(4, obj.getState());
            ps.setString(5, obj.getZip());
            ps.setString(6, obj.getPhone());

            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n;
    }

    @Override
    public List<Location> findAll() {
        return null;
    }

    @Override
    public Location findById(int id) {
        return null;
    }

    @Override
    public List<Cart> findAllById(int id) {
        return null;
    }

    @Override
    public boolean update(Location updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }
}
