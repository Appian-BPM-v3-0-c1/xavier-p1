package com.revature.contact.ui;


import com.revature.contact.daos.CustomerDAO;
import com.revature.contact.daos.DepartmentDAO;
import com.revature.contact.daos.ItemDAO;
import com.revature.contact.daos.LocationDAO;
import com.revature.contact.models.Customer;
import com.revature.contact.models.Department;
import com.revature.contact.models.Items;
import com.revature.contact.models.Location;
import com.revature.contact.services.CustomerService;
import com.revature.contact.services.DepartmentService;
import com.revature.contact.services.ItemService;
import com.revature.contact.services.LocationService;

import java.util.List;
import java.util.Scanner;

public class DepartmentMenu implements IMenu{
    private final DepartmentService departmentService;
    private final LocationService locationService;
    private final Customer customer;

    public DepartmentMenu(DepartmentService departmentService, LocationService locationService, Customer customer) {
        this.departmentService = departmentService;
        this.locationService = locationService;
        this.customer = customer;
    }


    @Override
    public void start() {
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);
        Items items = new Items();

        while (!exit) {
            System.out.println("\n\033[4;2m" + "STORE DEPARTMENTS" + "\033[0m");
            System.out.println("\nSelect one of the following:");
            System.out.println("[1] View all departments");
            System.out.println("[2] Search departments");
            System.out.println("[3] Change store location");
            System.out.println("[4] Go back to MAIN");
            System.out.println("[x] Exit");

            System.out.print("\nEnter: ");
            input = scan.next().charAt(0);

            switch (input) {
                case '1':
                    viewAllDepartments();
                    break;
                case '2':
                    searchDepartments();
                    break;
                case '3':
                    new LocationMenu(new LocationService(new LocationDAO()), new Customer()).start();
                    break;
                case '4':
                    new MainMenu(new Customer()).start();
                    break;
                case 'x':
                    exit = true;
                    break;
                default:
                    System.out.println("\nInvalid Input!");
                    break;
            }
        }
    }

    private void viewAllDepartments() {
        int input = 0;
        Scanner scan = new Scanner(System.in);
        List<Department> departmentList = departmentService.getDepartmentDAO().findAllDepartments();

        for(int i = 0;i<departmentList.size();i++) {
            System.out.println("["+(i+1)+"]"+departmentList.get(i).getName());
        }

        while (true) {
            System.out.print("\nSelect a department to view: ");

            input = scan.nextInt();

            if (input > departmentList.size()) {
                System.out.println("\nInvalid input");
            } else if(input == departmentList.size()){
                System.out.println("\nThis department is down due to maintenance(04/15/2022 8:00AM to 8:00PM). Please try another department.");
            } else {
                for (Department l: departmentList) {
                    System.out.println(l);
                    new ItemMenu(new LocationService(new LocationDAO()),new DepartmentService(new DepartmentDAO()),new CustomerService(new CustomerDAO()),new ItemService(new ItemDAO()),customer).start();
                }
                break;
            }
        }
    }

    private void searchDepartments() {
        String name = "";
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\nSearch Departments: ");
            name = scan.nextLine();

            List<Department> departments = departmentService.getDepartmentDAO().findAllByName(name);

            if (departments.isEmpty()) {
                System.out.println("\nInvalid search!");
            } else {
                for (Department loc : departments) {
                    System.out.println(loc);
                }

            }
            break;
        }
    }
}
