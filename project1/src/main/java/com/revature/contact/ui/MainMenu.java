package com.revature.contact.ui;


import com.revature.contact.daos.CartDAO;
import com.revature.contact.daos.LocationDAO;
import com.revature.contact.models.Customer;
import com.revature.contact.services.CartService;
import com.revature.contact.services.LocationService;


import java.util.Scanner;

public class MainMenu implements IMenu {
    private final Customer customer;

    public MainMenu(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void start() {
        System.out.println("\nHello " + customer.getFirstName() +"!");
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        while (!exit) {
            System.out.println("\nWelcome to CONTACT SPORTING GOODS!");
            System.out.println("[1] Go to locations menu");
            System.out.println("[X] Exit");

            System.out.print("\nEnter: ");
            input = scan.next().charAt(0);

            switch (input) {
                case '1':
                    new LocationMenu(new LocationService(new LocationDAO()),customer).start();
                    break;
                case '2':
                    new CartMenu(new CartService(new CartDAO())).start();
                    break;
                case '3':
                    new OrderHistoryMenu().start();
                case 'x':
                    exit = true;
                    break;
                default:
                    System.out.println("\nInvalid Input!");
                    break;
            }
        }
    }
}
