package com.revature.contact.daos;

import com.revature.contact.connection.DatabaseConnection;
import com.revature.contact.models.Cart;
import com.revature.contact.models.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements CrudDAO<Customer> {
    Connection con = DatabaseConnection.getCon();

    @Override
    public int save(Customer obj) {
        int n = 0;
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO customers (firstname, lastname, username, email, password, address, city, state, zip, usertype) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, obj.getFirstName());
            ps.setString(2, obj.getLastName());
            ps.setString(3, obj.getUsername());
            ps.setString(4, obj.getEmail());
            ps.setString(5, obj.getPassword());
            ps.setString(6, obj.getAddress());
            ps.setString(7, obj.getCity());
            ps.setString(8, obj.getState());
            ps.setString(9, obj.getZip());
            ps.setString(10, obj.getUsertype());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;

    }

    @Override
    public List<Customer> findAll() {
        List<Customer> userList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM customers");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Customer customer = new Customer();

                customer.setId(rs.getInt("id"));
                customer.setUsername(rs.getString("username"));
                customer.setPassword(rs.getString("password"));

                userList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public List<Cart> findAllById(int id) {
        return null;
    }

    @Override
    public boolean update(Customer updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

    public List<String> findAllUsernames() {
        List<String> usernameList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT (username) FROM customers");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                usernameList.add(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usernameList;
    }

    public int getId(String username) {
        int id = 0;

        try {
            PreparedStatement ps = con.prepareStatement("SELECT (id) FROM customers where username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
    public Customer findByUsername(String username) {

        Customer customer = new Customer();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM customers WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                customer.setId(rs.getInt("id"));
                customer.setFirstName(rs.getString("firstname"));
                customer.setLastName(rs.getString("lastname"));
                customer.setUsername(rs.getString("username"));
                customer.setEmail(rs.getString("email"));
                customer.setPassword(rs.getString("password"));
                customer.setAddress(rs.getString("address"));
                customer.setCity(rs.getString("city"));
                customer.setState(rs.getString("state"));
                customer.setZip(rs.getString("zip"));
                customer.setUsertype(rs.getString("usertype"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
