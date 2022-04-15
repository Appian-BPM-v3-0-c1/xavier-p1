package com.revature.contact.services;

import com.revature.contact.daos.ItemDAO;

public class ItemService {
    private final ItemDAO itemDAO;

    public ItemService(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }


    public ItemDAO getItemDAO() {
        return itemDAO();
    }

    private ItemDAO itemDAO() {
        return itemDAO;
    }
}
