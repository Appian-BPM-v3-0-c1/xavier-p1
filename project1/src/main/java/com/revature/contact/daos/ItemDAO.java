package com.revature.contact.daos;

import com.revature.contact.connection.DatabaseConnection;
import com.revature.contact.models.Cart;
import com.revature.contact.models.Items;

import java.sql.Connection;
import java.util.List;

public class ItemDAO implements CrudDAO<Items>{
    Connection con = DatabaseConnection.getCon();

    @Override
    public int save(Items obj) {
        return 0;
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
}
