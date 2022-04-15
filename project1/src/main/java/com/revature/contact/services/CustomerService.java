package com.revature.contact.services;

import com.revature.contact.daos.CustomerDAO;

import com.revature.contact.models.Customer;

import java.util.List;

public class CustomerService {
    private final CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public boolean isDupUsername(String username) {
        List<String> username_list = customerDAO.findAllUsernames();

        for (String u : username_list) {
            if (u.equals(username)) {
                return true;
            }
        }

        return false;
    }

    public boolean isValidUsername(String username) {
        return username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$");
    }

    public boolean isValidPassword(String password) {
        return password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@]).{8,20}$");
    }

    public boolean isValidLogin(Customer customer) {
        List<Customer> userList = customerDAO.findAll();

        for (Customer i : userList) {
            if (i.getUsername().equals(customer.getUsername()) && i.getPassword().equals(customer.getPassword())) {
                return true;
            }

        }
        return false;
    }

    public boolean isValidUsertype(Customer customer) {
        List<Customer> userList = customerDAO.findAll();

        for (Customer i : userList) {
            if (i.getUsername().equals(customer.getUsername()) && i.getUsertype().equals(customer.getUsertype()) ) {
                return true;
            }

        }
        return false;
    }

}
