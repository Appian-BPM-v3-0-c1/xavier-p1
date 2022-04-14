package com.revature.contact.daos;

import com.revature.contact.models.Cart;

import java.util.List;

public interface CrudDAO <T>{
    int save(T obj);

    List<T> findAll();

    T findById(int id);

    List<Cart> findAllById(int id);

    boolean update(T updatedObj);

    boolean removeById(String id);
}
