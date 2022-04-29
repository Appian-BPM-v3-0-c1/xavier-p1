package com.revature.contact.ui;

import com.revature.contact.daos.CustomerDAO;
import com.revature.contact.models.Customer;
import com.revature.contact.models.Department;
import com.revature.contact.models.Items;
import com.revature.contact.models.Location;
import com.revature.contact.services.CustomerService;
import com.revature.contact.services.DepartmentService;
import com.revature.contact.services.ItemService;
import com.revature.contact.services.LocationService;

import java.util.Scanner;

public class AdminMenu implements IMenu {
    private final LocationService locationService;
    private final DepartmentService departmentService;
    private final ItemService itemService;
    private final Customer customer;

    public AdminMenu(LocationService locationService, DepartmentService departmentService, ItemService itemService, Customer customer) {
        this.locationService = locationService;
        this.departmentService = departmentService;
        this.itemService = itemService;
        this.customer = customer;
    }
    Scanner scan = new Scanner(System.in);

    @Override
    public void start() {
        char input = ' ';

        exit:
        {
            while (true) {
                System.out.println("\nWelcome back Admin! How may we assist you?");
                System.out.println("[1] Create a new location.");
                System.out.println("[2] Create a new department.");
                System.out.println("[3] Create a new item.");
                System.out.println("[x] Log Out\n");

                input = scan.next().charAt(0);

                switch (input) {
                    case '1':
                        createLocation();
                        break;
                    case '2':
                        createDepartment();
                        break;
                    case '3':
                        createItem();
                    case 'x':
                        new LoginMenu(new CustomerService(new CustomerDAO())).start();
                        break;
                    default:
                        System.out.println("\nInvalid input!");
                        break;
                }
            }
        }
    }

    private void createItem() {
        char input = ' ';
        boolean exit = false;
        boolean confirm = false;
        Scanner scan = new Scanner(System.in);
        Items items = new Items();

        while (!exit) {
            System.out.print("\nEnter in item name: ");
            items.setName(scan.nextLine().toLowerCase());

            System.out.print("\nEnter in item price: ");
            items.setPrice(scan.nextFloat());
            scan.nextLine();

            System.out.print("\nEnter in item stock: ");
            items.setStock(scan.nextInt());

            System.out.print("\nEnter in item brand: ");
            items.setBrand(scan.nextLine().toLowerCase());
            scan.nextLine();

            System.out.print("\nEnter in item department ID: ");
            items.setDepartmentsId(scan.nextInt());



            while (!confirm) {
                System.out.println("\nIs this correct? (y/n)\n");
                System.out.println(items);

                input = scan.next().charAt(0);
                switch (input) {
                    case 'y':
                        itemService.getItemDAO().save(items);
                        System.out.println("\nStore item created successfully!");
                        exit = true;
                        confirm = true;
                        break;
                    case 'n':
                        confirm = true;
                        break;
                    default:
                        System.out.println("Invalid input!");
                        break;
                }
            }
        }
    }

    private void createDepartment() {
        char input = ' ';
        boolean exit = false;
        boolean confirm = false;
        Scanner scan = new Scanner(System.in);
        Department department = new Department();

        while (!exit) {
            System.out.print("\nEnter in department name: ");
            department.setName(scan.nextLine().toLowerCase());
            scan.nextLine();

            System.out.print("\nEnter in store location ID: ");
            department.setLocationId(scan.nextInt());
            scan.nextLine();

            while (!confirm) {
                System.out.println("\nIs this correct? (y/n)\n");
                System.out.println(department);

                input = scan.next().charAt(0);
                switch (input) {
                    case 'y':
                        departmentService.getDepartmentDAO().save(department);
                        System.out.println("\nStore department created successfully!");
                        exit = true;
                        confirm = true;
                        break;
                    case 'n':
                        confirm = true;
                        break;
                    default:
                        System.out.println("Invalid input!");
                        break;
                }
            }
        }
    }

    private void createLocation() {

        char input = ' ';
        boolean exit = false;
        boolean confirm = false;
        Scanner scan = new Scanner(System.in);
        Location location = new Location();

        while (!exit) {
            System.out.print("\nEnter in location name: ");
            location.setName(scan.nextLine().toLowerCase());

            System.out.print("\nEnter in location street: ");
            location.setStreet(scan.nextLine().toLowerCase());
            scan.nextLine();

            System.out.print("\nEnter in location city: ");
            location.setCity(scan.next().toLowerCase());

            System.out.print("\nEnter in location state: ");
            location.setState(scan.next().toLowerCase());

            System.out.print("\nEnter in location zip: ");
            location.setZip(scan.next());

            System.out.print("\nEnter in location phone number: ");
            location.setPhone(scan.next());

            while (!confirm) {
                System.out.println("\nIs this correct? (y/n)\n");
                System.out.println(location);

                input = scan.next().charAt(0);
                switch (input) {
                    case 'y':
                        locationService.getLocationDAO().save(location);
                        System.out.println("\nStore location created successfully!");
                        exit = true;
                        confirm = true;
                        break;
                    case 'n':
                        confirm = true;
                        break;
                    default:
                        System.out.println("Invalid input!");
                        break;
                }
            }
        }
    }
}
