package com.revature.contact.daos;

import com.revature.contact.connection.DatabaseConnection;
import com.revature.contact.models.Cart;
import com.revature.contact.models.Department;
import com.revature.contact.models.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO implements CrudDAO<Department> {
    Connection con = DatabaseConnection.getCon();

    @Override
    public int save(Department obj) {
        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO departments (name, locations_id) VALUES (?, ?)");
            ps.setString(1, obj.getName());
            ps.setInt(2, obj.getLocationId());

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

    public List<Department> findAllByName(String name) {
        List<Department> departments = new ArrayList<>();

        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM departments WHERE name LIKE ?");
            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Department department = new Department();

                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                department.setLocationId(rs.getInt("locations_id"));


                departments.add(department);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departments;
    }

    public List<Department> findAllDepartments() {
        List<Department> departments = new ArrayList<>();

        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM departments");


            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Department department = new Department();

                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                department.setLocationId(rs.getInt("locations_id"));


                departments.add(department);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departments;
    }
}
