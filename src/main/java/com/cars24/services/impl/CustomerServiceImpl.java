package com.cars24.services.impl;

import com.cars24.dao.impl.CustomerDaoImpl;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.req.DeleteCustomerReq;
import com.cars24.data.req.UpdateCustomerReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.services.CustomerService;
import com.cars24.validation.CustomerValidation;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDaoImpl customerDao = new CustomerDaoImpl();

    private CustomerValidation customerValidation = new CustomerValidation();

    @Override
    public String registerCustomer(AddCustomerReq addCustomerReq) {


        try {
            // Step 1: Validate input
            customerValidation.validateAddCustomerRequest(addCustomerReq);

            // Step 2: Call DAO to create customer
            customerDao.createCustomer(addCustomerReq);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public CustomerProfileRes getCustomerProfile(CustomerProfileReq customerProfileReq){
        CustomerProfileRes res = customerDao.getCustomer(customerProfileReq);
        return res;

    }

    public String updateCustomerProfile(UpdateCustomerReq updateCustomerReq){
        String response = customerDao.updateCustomer(updateCustomerReq);
        return response;
    }
    public String deleteCustomerProfile(DeleteCustomerReq deleteCustomerRequest){
        String response=customerDao.deleteCustomer(deleteCustomerRequest);
        return response;
    }
}