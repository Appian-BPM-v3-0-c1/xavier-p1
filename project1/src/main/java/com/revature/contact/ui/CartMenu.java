package com.revature.contact.ui;

import com.revature.contact.services.CartService;

import java.util.Scanner;

public class CartMenu implements IMenu{
    private final CartService cartService;



    Scanner scan = new Scanner(System.in);

    public CartMenu(CartService cartService) {

        this.cartService = cartService;
    }

    @Override
    public void start() {

        char input = ' ';
        boolean exit = false;
        //System.out.println(cartMenu);

        while (!exit) {
            System.out.println("\nCart Menu");
            System.out.println("[1] Go to ");
            System.out.println("[2] Go to ");
            System.out.println("[X] Exit");

            System.out.print("\nEnter: ");
            input = scan.next().charAt(0);

            switch (input) {
                case '1':

                    break;
                case '2':

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
    private void showItems(){


    }
}



