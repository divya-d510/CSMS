package com.cars24.runner;

import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;

import java.util.Scanner;

public class Ui {
    private final static Scanner scanner  = new Scanner(System.in);
    public static void addCustomer()
    {
        System.out.println("Enter customer details");
        AddCustomerReq addCustomerReq = new AddCustomerReq();


        addCustomerReq.setEmail(scanner.next());
        addCustomerReq.setPhone(scanner.next());
    }

    public static void getCustomer()
    {
        System.out.println("Search customer details");

        System.out.println("Enter Email  : ");

        System.out.println("Enter Phone  : ");
    }
}