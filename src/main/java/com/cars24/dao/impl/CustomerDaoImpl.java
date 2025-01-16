package com.cars24.dao.impl;

import com.cars24.dao.CustomerDao;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.util.DbUtil;

import java.sql.*;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class CustomerDaoImpl implements CustomerDao {
    private final static String INSERT_SUCCESS_MESSAGE = "Customer created successfully!";
    private final static String INSERT_ERROR_MESSAGE = "Error while Adding Customer!";


    @Override
    public String createCustomer(String name, String phone, String email, String address) {
        String insertSQL =
                "INSERT INTO customers (customer_id, name, phone, email, address) VALUES ("
                        + 0 + ", '" + name + "', '" + phone + "', '" + email + "', '" + address + "');";

        System.out.println(insertSQL);

        Connection connection = DbUtil.getConnection();

        try{
            Statement statement = connection.createStatement();
            int rowsInserted = statement.executeUpdate(insertSQL);
            System.out.println(rowsInserted+" row(s) inserted");
        }
        catch(Exception e){
            System.out.println("Error while inserting data to customer table");
            e.printStackTrace();
        }

        return "";


    }

    /*public String createCustomer2(String name, String phone, String email, String address){
        String insertSQL = "INSERT INTO customers (name, phone, email, address) VALUES (?, ?, ?, ?);";
        Connection connection = DbUtil.getConnection();

        try {
            // Prepare the statement
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);

            // Set the parameter values from the method's arguments
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, address);

            // Execute the update and get the number of rows affected
            int rowsInserted = preparedStatement.executeUpdate();
            return INSERT_SUCCESS_MESSAGE;


        } catch (SQLException e) {
            e.printStackTrace();  // Print the stack trace for debugging
            return INSERT_ERROR_MESSAGE;
        }
    }*/

    public String createCustomer(AddCustomerReq addCustomerReq){
        String insertSQL = "INSERT INTO customers (name, phone, email, address) VALUES (?, ?, ?, ?);";
        Connection connection = DbUtil.getConnection();

        try {
            // Prepare the statement
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);

            // Set the parameter values from the method's arguments
            preparedStatement.setString(1, addCustomerReq.getName());
            preparedStatement.setString(2, addCustomerReq.getPhone());
            preparedStatement.setString(3, addCustomerReq.getEmail());
            preparedStatement.setString(4, addCustomerReq.getAddress());

            // Execute the update and get the number of rows affected
            int rowsInserted = preparedStatement.executeUpdate();
            return INSERT_SUCCESS_MESSAGE;


        } catch (SQLException e) {
            e.printStackTrace();  // Print the stack trace for debugging
            return INSERT_ERROR_MESSAGE;
        }


        }

    public CustomerProfileRes getCustomer(CustomerProfileReq customerProfileReq){
//        now select query to execute
        String selectSQL = "SELECT name, phone, email, address FROM customers WHERE email = ? or phone = ?";
        Connection connection = DbUtil.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, customerProfileReq.getEmail());
            preparedStatement.setString(2, customerProfileReq.getPhone());

            CustomerProfileRes customerProfileRes = new CustomerProfileRes();

//            virtual table that stores the result
//            when you put contact info 1 unique record is expected
//            next - cursor first points to the first row, then to the second and so on but we dont know if there is a record or not
//            hence you check it in the while loop
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
//                String name = resultSet.getString("name");
//                String phone = resultSet.getString("phone");
//                String email = resultSet.getString("email");
//                String address = resultSet.getString("address");
//
//                System.out.println("name: "+name);
//                System.out.println("phone: "+phone);
//                System.out.println("email: "+email);
//                System.out.println("address: "+address);

                customerProfileRes.setName( resultSet.getString("name"));
                customerProfileRes.setPhone(resultSet.getString("phone"));
                customerProfileRes.setEmail(resultSet.getString("email"));
                customerProfileRes.setAddress(resultSet.getString("address"));

            }
            return customerProfileRes;
        } catch (Exception e){
            System.out.println("Error while adding customer");
        }
        return null;
    }

    }



    /* @Override
    public void getCustomer() {

    }

    @Override
    public void updateCustomer() {

    }

    @Override
    public void deleteCustomer() {

    }*/

