package com.revature.contact.ui;

import com.revature.contact.daos.CustomerDAO;
import com.revature.contact.daos.DepartmentDAO;
import com.revature.contact.daos.LocationDAO;
import com.revature.contact.models.Cart;
import com.revature.contact.models.Customer;
import com.revature.contact.models.Items;
import com.revature.contact.services.*;

import java.util.List;
import java.util.Scanner;

public class ItemMenu implements IMenu{
    private final LocationService locationService;
    private final DepartmentService departmentService;
    private final CustomerService customerService;
    private final ItemService itemService;

    private final Customer customer;

    public ItemMenu(LocationService locationService, DepartmentService departmentService, CustomerService customerService, ItemService itemService, Customer customer) {
        this.locationService = locationService;
        this.departmentService = departmentService;
        this.customerService = customerService;
        this.itemService = itemService;
        this.customer = customer;
    }


    @Override
    public void start() {
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        while (!exit) {
            System.out.println("\n\033[4;2m" + "STORE ITEMS" + "\033[0m");
            System.out.println("\nSelect one of the following:");
            System.out.println("[1] View all items");
            System.out.println("[2] Search items by name");
            System.out.println("[3] Search items by brand");
            System.out.println("[4] Go to cart");
            System.out.println("[5] Go to order history");
            System.out.println("[6] Change store department in the current store location");
            System.out.println("[7] Change store location");
            System.out.println("[8] Go back to MAIN");
            System.out.println("[x] Log Out");

            System.out.print("\nEnter: ");
            input = scan.next().charAt(0);

            switch (input) {
                case '1':
                    viewAllItems();
                    break;
                case '2':
                    searchItemsByName();
                    break;
                case '3':
                    searchItemsByBrand();
                    break;
                case '4':
                    //viewCart();
                case '5':
                    //viewOrderHistory();
                case '6':
                    new DepartmentMenu(new DepartmentService(new DepartmentDAO()), new LocationService(new LocationDAO()), new Customer()).start();
                    break;
                case '7':
                    new LocationMenu(new LocationService(new LocationDAO()), new Customer()).start();
                    break;
                case '8':
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

    private void viewAllItems() {
        int input = 0;
        Scanner scan = new Scanner(System.in);
        List<Items> itemList = itemService.getItemDAO().findAllItems();

        for(int i = 0;i<itemList.size();i++) {
            System.out.println("["+(i+1)+"]"+" "+itemList.get(i));
        }

        while (true) {
            System.out.print("\nSelect an item to view: ");

            input = scan.nextInt() - 1;

            if (input < itemList.size()) {
                Items interested = itemList.get(input);
                System.out.println("\nYou are interested in item: \n"  + interested.getBrand() +  "(" + interested.getName()+ ")" + " for $" + "\033[4;2m" + interested.getPrice() + "\033[0m" +".");
                System.out.println("\nShould this item be added to your cart?");
                System.out.println("\n(y/n)");

                if (scan.next().charAt(0) == 'y') {
                    if (interested.getStock() > 0) {
                        Cart cart = new Cart();
                        cart.setTotalPrice(interested.getPrice());
                        cart.setTotalQuantity(interested.getStock());
                        cart.setCustomerId(interested.getId());


                        System.out.println("\n" + interested.getBrand() + " " + interested.getName() + " is being added to your cart.");
                        break;
                    } else if (interested.getStock() == 0) {
                        System.out.println("SOLD OUT! We restock daily, so please check back in later. Feel free to shop through our other items.");
                        break;
                    } else {
                        System.out.println("\nInvalid input.");
                    }
                }
            } else {
                System.out.println("\nInvalid input");
                break;
            }
        }
    }

    private void searchItemsByName() {
        String name = "";
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\nSearch Items: ");
            name = scan.nextLine();

            List<Items> items = itemService.getItemDAO().findAllByName(name);

            if (items.isEmpty()) {
                System.out.println("\nInvalid search!");
            } else {
                for (Items loc : items) {
                    System.out.println(loc);
                }
            }
        }
    }

    private void searchItemsByBrand() {
        String brand = "";
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\nSearch Brand Name: ");
            brand = scan.nextLine();

            List<Items> items = itemService.getItemDAO().findAllByBrand(brand);

            if (items.isEmpty()) {
                System.out.println("\nInvalid search!");
            } else {
                for (Items loc : items) {
                    System.out.println(loc);
                }
            }
        }
    }
    /*private void viewCart() {

        List<Cart> carts = cartService.getCartDAO().findAllById(customer.getId());
        for (Cart c : carts){
            System.out.println(itemService.getItemDAO().findAllById(c.getId()));
        }
        System.out.println("\nWill that complete your purchase today?");

    }
    private void viewOrderHistory() {
    }*/
}
