package com.cars24.runner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;

        while(exit){
            int choice = 0;
            System.out.println("Enter choice:");
            System.out.println("1: Add user 2: Get user 3: Update user 4: Delete user 0: Exit");
            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    // Call method to add customer
                    Ui.addCustomer();
                    break;
                case 2:
                    // Call method to get customer
                    Ui.getCustomer();
                    break;
                case 3:
                    // Call method to update customer
                    Ui.updateCustomer();
                    break;
                case 4:
                    // Call method to delete customer
                    Ui.deleteCustomer();
                    break;
                case 0:
                    exit = false;

                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
