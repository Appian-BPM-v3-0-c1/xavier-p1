package com.revature.contact.ui;

import com.revature.contact.daos.DepartmentDAO;
import com.revature.contact.daos.ItemDAO;
import com.revature.contact.daos.LocationDAO;
import com.revature.contact.models.Customer;
import com.revature.contact.services.CustomerService;
import com.revature.contact.services.DepartmentService;
import com.revature.contact.services.ItemService;
import com.revature.contact.services.LocationService;


import java.util.Scanner;

public class LoginMenu implements IMenu {
    private final CustomerService customerService;

    public LoginMenu(CustomerService customerService) {
        this.customerService = customerService;
    }

    Scanner scan = new Scanner(System.in);
    Customer customer = new Customer();

    @Override
    public void start() {
        char input;
        exit:
        {
            while (true) {
                System.out.println("\nWelcome to " + "\033[4;2m" + "CONTACT SPORTING GOODS!" + "\033[0m");
                System.out.println("\nSelect one of the following:");
                System.out.println("[1] Log in");
                System.out.println("[2] Create new account");
                System.out.println("[x] Exit\n");

                input = scan.next().charAt(0);

                switch (input) {
                    case '1':
                        login();
                        break;
                    case '2':
                        createAccount();
                        break;
                    case 'x':
                        break exit;
                    default:
                        System.out.println("\nInvalid input!");
                        break;
                }
            }
        }
    }

    public void createAccount() {
        String username;
        String password1;
        String password2;
        String firstname;
        String lastname;
        String email;
        String address;
        String city;
        String state;
        String zip;

        Scanner scan = new Scanner(System.in);


        System.out.println("\nCreating account...");

        while (true) {
            while (true) {
                System.out.print("\nEnter in username: ");
                username = scan.next();

                if (!customerService.isDupUsername(username)) {
                    if (customerService.isValidUsername(username)) {
                        customer.setUsername(username);
                        break;
                    } else {
                        System.out.println("\nInvalid username :(");
                    }

                } else {
                    System.out.println("\nDuplicate username :(");
                }
            }

            while (true) {
                System.out.print("\nEnter in password: ");
                password1 = scan.next();

                System.out.print("\nEnter in password again: ");
                password2 = scan.next();


                if (password1.equals(password2)) {
                    if (customerService.isValidPassword(password1)) {
                        customer.setPassword(password1);
                        break;
                    } else {
                        System.out.println("\nInvalid password!");
                    }
                } else {
                    System.out.println("Password does not match! Try again");
                }
            }

            System.out.print("\nEnter in first name: ");
            firstname = scan.next();
            customer.setFirstName(firstname);

            System.out.print("\nEnter in last name: ");
            lastname = scan.next();
            customer.setLastName(lastname);

            System.out.print("\nEnter in email: ");
            email = scan.next();
            customer.setEmail(email);

            System.out.print("\nEnter in address: ");
            address = scan.next();
            scan.nextLine();
            customer.setAddress(address);

            System.out.print("\nEnter in city: ");
            city = scan.next();
            scan.nextLine();
            customer.setCity(city);

            System.out.print("\nEnter in state: ");
            state = scan.next();
            scan.nextLine();
            customer.setState(state);

            System.out.print("\nEnter in zip: ");
            zip = scan.next();
            customer.setZip(zip);


            System.out.println("\nPlease confirm credentials (y/n)");
            System.out.print("Username: " + username);
            System.out.print("\nPassword: " + password1);
            System.out.print("\nFirst name: " + firstname);
            System.out.print("\nLast name: " + lastname);
            System.out.print("\nEmail: " + email);
            System.out.print("\nAddress: " + address);
            System.out.print("\nCity: " + city);
            System.out.print("\nState: " + state);
            System.out.print("\nZip: " + zip);

            System.out.print("\nEnter: ");

            if (scan.next().charAt(0) == 'y') {
                customerService.getCustomerDAO().save(customer);

                System.out.println("Account Created Successfully!");
                break;
            }
        }
    }

    private void login() {
        while (true) {
            System.out.print("\nUsername: ");
            customer.setUsername(scan.next());

            System.out.print("Password: ");
            customer.setPassword((scan.next()));

            if (customerService.isValidLogin(customer)) {
                customer = customerService.getCustomerDAO().findByUsername(customer.getUsername());

                if (customer.getUsertype().equals("default")) {
                    System.out.println("Login accepted!");
                    System.out.println("\n\033[4;2m" + "MAIN PAGE" + "\033[0m");
                    System.out.println("\nHello " + customer.getFirstName() +"!");
                    new MainMenu(customer).start();
                    break;
                } else if (customer.getUsertype().equals("admin")) {
                    System.out.println("\nWelcome valued Employee");
                   new AdminMenu(new LocationService(new LocationDAO()),new DepartmentService(new DepartmentDAO()),new ItemService(new ItemDAO()),customer).start();
                }
            }
        }
    }
}