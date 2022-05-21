package com.revature.contact.ui;

import com.revature.contact.daos.CustomerDAO;
import com.revature.contact.daos.DepartmentDAO;
import com.revature.contact.models.Customer;
import com.revature.contact.models.Location;
import com.revature.contact.services.CustomerService;
import com.revature.contact.services.DepartmentService;
import com.revature.contact.services.LocationService;

import java.util.List;
import java.util.Scanner;

public class LocationMenu implements IMenu{
    private final LocationService locationService;
    private final Customer customer;

    public LocationMenu(LocationService locationService, Customer customer) {
        this.locationService = locationService;
        this.customer = customer;
    }

    @Override
    public void start() {
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        while (!exit) {
            System.out.println("\n\033[4;2m" + "STORE LOCATIONS" + "\033[0m");
            System.out.println("\nSelect one of the following:");
            System.out.println("[1] View all locations");
            System.out.println("[2] Search locations");
            System.out.println("[3] Go back to MAIN");
            System.out.println("[x] Log Out");

            System.out.print("\nEnter: ");
            input = scan.next().charAt(0);

            switch (input) {
                case '1':
                    viewAllLocations();
                    break;
                case '2':
                    searchLocation();
                    break;
                case '3':
                    new MainMenu(new Customer()).start();
                    break;
                case 'x':
                    new LoginMenu(new CustomerService(new CustomerDAO())).start();
                    break;
                default:
                    System.out.println("\nInvalid Input!");
                    break;
            }
        }
    }

    private void viewAllLocations() {
        int input = 0;
        Scanner scan = new Scanner(System.in);
        List<Location> locationList = locationService.getLocationDAO().findAllLocations();
        System.out.println("\n\033[4;2m" + "LOCATIONS:" + "\033[0m");

        for(int i = 0;i<locationList.size();i++) {
            System.out.println("\n["+(i+1)+"]"+locationList.get(i).getName());
        }

        while (true) {
            System.out.print("\nSelect a location to view: ");

            input = scan.nextInt() - 1;

            if (input > locationList.size()) {
                System.out.println("\nInvalid input");
            } else {


                for (Location l: locationList) {
                    System.out.println(l);
                    new DepartmentMenu(new DepartmentService(new DepartmentDAO()), locationService, customer).start();
                }
                break;
            }
        }
    }

    private void searchLocation() {
        String name = "";
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\nSearch location: ");
            name = scan.nextLine();

            List<Location> locations = locationService.getLocationDAO().findAllByName(name);

            if (locations.isEmpty()) {
                System.out.println("\nInvalid search!");
            } else {
                for (Location loc : locations) {
                    System.out.println(loc);
                }
                break;
            }

        }
    }
}
