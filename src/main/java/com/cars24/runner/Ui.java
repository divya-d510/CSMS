package com.cars24.runner;


import com.cars24.dao.impl.CustomerDaoImpl;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.req.DeleteCustomerReq;
import com.cars24.data.req.UpdateCustomerReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.services.impl.CustomerServiceImpl;

import java.util.Scanner;

public class Ui {

    private static CustomerServiceImpl customerService = new CustomerServiceImpl();
    // Method to add a customer
    public static void addCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter customer name:");
        String name = scanner.nextLine();
        System.out.println("Enter customer phone:");
        String phone = scanner.nextLine();
        System.out.println("Enter customer email:");
        String email = scanner.nextLine();
        System.out.println("Enter customer address:");
        String address = scanner.nextLine();

        CustomerDaoImpl customerDao = new CustomerDaoImpl();
        String result = customerDao.createCustomer(name, phone, email, address);
        System.out.println(result);
    }

    // Method to get a customer's profile
    public static void getCustomer() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer email or phone:");
        String emailOrPhone = scanner.nextLine();

        CustomerProfileReq customerProfileReq = new CustomerProfileReq();

        // Check if the input is a valid email or phone (simple check for demo purposes)
        if (emailOrPhone.contains("@")) {
            // Assume it's an email
            customerProfileReq.setEmail(emailOrPhone);
        } else {
            // Otherwise, treat it as a phone number
            customerProfileReq.setPhone(emailOrPhone);
        }

        CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
        CustomerProfileRes response = customerDaoImpl.getCustomer(customerProfileReq);

        if (response != null) {
            System.out.println("Customer Profile: " + response);
        } else {
            System.out.println("No customer found with the given email or phone.");
        }
    }


    // Method to update customer details
    public static void updateCustomer() {
        UpdateCustomerReq updateCustomerRequest = new UpdateCustomerReq();
        Scanner scanner = new Scanner(System.in);
        // Collect inputs
        System.out.println("Enter the customer's name:");
        String name = scanner.nextLine();
        updateCustomerRequest.setName(name);

        System.out.println("Enter the customer's email:");
        String email = scanner.nextLine();
        updateCustomerRequest.setEmail(email);

        System.out.println("Enter the new details (leave blank if unchanged):");
        System.out.print("New Phone: ");
        String phone = scanner.nextLine();
        updateCustomerRequest.setPhone(phone.isEmpty() ? null : phone);

        System.out.print("New Address: ");
        String address = scanner.nextLine();
        updateCustomerRequest.setAddress(address.isEmpty() ? null : address);

        // Call the service method and display the result
        String result = customerService.updateCustomerProfile(updateCustomerRequest);
        System.out.println(result);

    }



    public static void deleteCustomer(){
        DeleteCustomerReq deleteCustomerRequest= new DeleteCustomerReq();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name");
        String name=scanner.nextLine();
        deleteCustomerRequest.setName(name);

        System.out.println("Enter email");
        String email=scanner.nextLine();
        deleteCustomerRequest.setEmail(email);

        String result=customerService.deleteCustomerProfile(deleteCustomerRequest);
        System.out.println(result);
    }
    }

