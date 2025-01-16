package com.cars24.runner;

//import com.cars24.config.DbConfig;
//import com.cars24.dao.impl.CustomerDaoImpl;
//import com.cars24.data.req.AddCustomerReq;
//import com.cars24.data.req.CustomerProfileReq;
//import com.cars24.data.res.CustomerProfileRes;
//import com.cars24.services.impl.CustomerServiceImpl;
//
//import java.sql.DriverManager;
//import java.sql.SQLException;

import com.cars24.runner.Ui;

import java.util.Scanner;

//import static com.cars24.util.DbUtil.getConnection;


public class Main {
    public static void main(String[] args) {





       /* getConnection(); //establishes connection with database

        //System.out.println("Connected to database csms");


        CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
        //customerDaoImpl.createCustomer("Sameera", "9876543212", "marie.doe@example.com", "Bangalore");

        //customerDaoImpl.createCustomer2("Max", "9876543212", "max.doe@example.com", "Bangalore");

       CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
        AddCustomerReq addCustomerReq = new AddCustomerReq();
        addCustomerReq.setName("");
        addCustomerReq.setPhone("5678901230");
        addCustomerReq.setEmail("reza@example.com");
        addCustomerReq.setAddress("Chandigarh");

        customerServieImpl.registerCustomer(addCustomerReq);

        CustomerProfileReq customerProfileReq = new CustomerProfileReq();

        customerProfileReq.setEmail("sam@example.com");
        customerProfileReq.setPhone("9988776655");

        CustomerProfileRes response = customerServiceImpl.getCustomerProfile(customerProfileReq);
        System.out.println(response);

        */

        Scanner scanner = new Scanner(System.in);
        boolean exit = true;

        while(exit){
            int choice = 0;
            System.out.println("enter choice");
            System.out.println("1: Add user 2:Get user 0: exit");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    //call
                    Ui.addCustomer();
                    break;
                case 2:
                    Ui.getCustomer();
                    break;
                case 0:
                    exit=false;
            }
        }


    }
}
