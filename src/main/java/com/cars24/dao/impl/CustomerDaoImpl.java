package com.cars24.dao.impl;

import com.cars24.dao.CustomerDao;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.req.DeleteCustomerReq;
import com.cars24.data.req.UpdateCustomerReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.util.DbUtil;

import java.sql.*;

public class CustomerDaoImpl implements CustomerDao {
    private final static String INSERT_SUCCESS_MESSAGE = "Customer created successfully!";
    private final static String INSERT_ERROR_MESSAGE = "Error while Adding Customer!";

    Connection connection = DbUtil.getConnection();

    @Override
    public String createCustomer(String name, String phone, String email, String address) {
        String insertSQL =
                "INSERT INTO customers (customer_id, name, phone, email, address) VALUES ("
                        + 0 + ", '" + name + "', '" + phone + "', '" + email + "', '" + address + "');";

        System.out.println(insertSQL);

       // Connection connection = DbUtil.getConnection();

        try {
            Statement statement = connection.createStatement();
            int rowsInserted = statement.executeUpdate(insertSQL);
            System.out.println(rowsInserted + " row(s) inserted");
        } catch (Exception e) {
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

    public String createCustomer(AddCustomerReq addCustomerReq) {
        String insertSQL = "INSERT INTO customers (name, phone, email, address) VALUES (?, ?, ?, ?);";


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

    public CustomerProfileRes getCustomer(CustomerProfileReq customerProfileReq) {
//        now select query to execute
        String selectSQL = "SELECT name, phone, email, address FROM customers WHERE email = ? or phone = ?";
        Connection connection = DbUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, customerProfileReq.getEmail());
            preparedStatement.setString(2, customerProfileReq.getPhone());

            CustomerProfileRes customerProfileRes = new CustomerProfileRes();

//            virtual table that stores the result
//            when you put contact info 1 unique record is expected
//            next - cursor first points to the first row, then to the second and so on but we dont know if there is a record or not
//            hence you check it in the while loop
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
//                String name = resultSet.getString("name");
//                String phone = resultSet.getString("phone");
//                String email = resultSet.getString("email");
//                String address = resultSet.getString("address");
//
//                System.out.println("name: "+name);
//                System.out.println("phone: "+phone);
//                System.out.println("email: "+email);
//                System.out.println("address: "+address);

                customerProfileRes.setName(resultSet.getString("name"));
                customerProfileRes.setPhone(resultSet.getString("phone"));
                customerProfileRes.setEmail(resultSet.getString("email"));
                customerProfileRes.setAddress(resultSet.getString("address"));

            }
            return customerProfileRes;
        } catch (Exception e) {
            System.out.println("Error while adding customer");
        }
        return null;
    }



    @Override
    public String updateCustomer(UpdateCustomerReq updateCustomerRequest) {
        String updateSQL = "UPDATE customers SET phone = ?, address = ? WHERE name = ? AND email=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setString(3, updateCustomerRequest.getName());
            preparedStatement.setString(2, updateCustomerRequest.getAddress());
            preparedStatement.setString(1, updateCustomerRequest.getPhone());
            preparedStatement.setString(4, updateCustomerRequest.getEmail());

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                return "Customer updated successfully!";
            } else {
                return "Customer not found for the provided phone and email.";
            }
        } catch (SQLException e) {
            return "Error while updating the customer: " + e.getMessage();
        }
    }


    @Override
    public String deleteCustomer(DeleteCustomerReq deleteCustomerRequest) {
        String deleteSQL = "DELETE FROM customers WHERE name = ? AND email = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setString(1, deleteCustomerRequest.getName());
            preparedStatement.setString(2, deleteCustomerRequest.getEmail());

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                return "Customer deleted successfully!";
            } else {
                return "No customer found with the given name or email.";
            }
        } catch (SQLException e) {
            return "Error while deleting the customer: " + e.getMessage();
        }
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

