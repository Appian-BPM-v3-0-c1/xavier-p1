package com.revature.contact.daos;

import com.revature.contact.connection.DatabaseConnection;
import com.revature.contact.models.Cart;
import com.revature.contact.models.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public String findByName(String name) {
        Location location = new Location();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM locations WHERE name = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                location.setId(rs.getInt("id"));
                location.setName(rs.getString("name"));
                location.setStreet(rs.getString("street"));
                location.setCity(rs.getString("city"));
                location.setState(rs.getString("state"));
                location.setZip(rs.getString("zip"));
                location.setPhone(rs.getString("phone"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

    public List<Location> findAllByName(String name) {
        List<Location> locations = new ArrayList<>();

        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM locations WHERE name LIKE ?");
            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Location location = new Location();

                location.setId(rs.getInt("id"));
                location.setName(rs.getString("name"));
                location.setStreet(rs.getString("street"));
                location.setCity(rs.getString("city"));
                location.setState(rs.getString("state"));
                location.setZip(rs.getString("zip"));
                location.setPhone(rs.getString("phone"));

                locations.add(location);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return locations;
    }

    public List<Location> findAllLocations() {
        List<Location> locations = new ArrayList<>();

        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM locations");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Location location = new Location();

                location.setId(rs.getInt("id"));
                location.setName(rs.getString("name"));
                location.setStreet(rs.getString("street"));
                location.setCity(rs.getString("city"));
                location.setState(rs.getString("state"));
                location.setZip(rs.getString("zip"));
                location.setPhone(rs.getString("phone"));

                locations.add(location);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return locations;
    }
}


