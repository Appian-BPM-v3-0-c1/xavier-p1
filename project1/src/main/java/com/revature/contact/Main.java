package com.revature.contact;

import com.revature.contact.daos.CustomerDAO;
import com.revature.contact.services.CustomerService;
import com.revature.contact.ui.LoginMenu;

public class Main {
    public static void main(String[] args) {
        //new MainMenu().start();
        new LoginMenu(new CustomerService(new CustomerDAO())).start();

    }
}
