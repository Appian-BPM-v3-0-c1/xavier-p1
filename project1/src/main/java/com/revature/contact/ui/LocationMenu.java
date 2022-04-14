package com.revature.contact.ui;

import com.revature.contact.models.Location;
import com.revature.contact.services.LocationService;

import java.util.Scanner;

public class LocationMenu implements IMenu{
    private final LocationService locationservice;

    public LocationMenu(LocationService locationservice) {
        this.locationservice = locationservice;
    }

    @Override
    public void start() {
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        while (!exit) {
            System.out.println("\nWelcome to Store Locations menu!");
            System.out.println("[1] Search locations");
            System.out.println("[2] Create locations");
            System.out.println("[X] Exit");

            System.out.print("\nEnter: ");
            input = scan.next().charAt(0);

            switch (input) {
                case '1':
                    //viewAllLocation();
                    break;
                case '2':
                    searchLocation();
                    break;
                case '3':
                    createLocation();
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

    private void searchLocation() {
        String name = "";


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
                        locationservice.getLocationDAO().save(location);
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
