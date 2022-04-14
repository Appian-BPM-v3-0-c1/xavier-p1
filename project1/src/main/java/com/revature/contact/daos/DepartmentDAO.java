package com.revature.contact.daos;

import com.revature.contact.connection.DatabaseConnection;
import com.revature.contact.models.Cart;
import com.revature.contact.models.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DepartmentDAO implements CrudDAO<Department> {
    Connection con = DatabaseConnection.getCon();

    @Override
    public int save(Department obj) {
        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO departments (name) VALUES (?)");
            ps.setString(1, obj.getName());

            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n;
    }

    @Override
    public List<Department> findAll() {
        return null;
    }

    @Override
    public Department findById(int id) {
        return null;
    }

    @Override
    public List<Cart> findAllById(int id) {
        return null;
    }

    @Override
    public boolean update(Department updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }
}
