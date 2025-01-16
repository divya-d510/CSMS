package com.cars24.vailidation;

import com.cars24.data.req.AddCustomerReq;

public class CustomerValidation {
    public void validateAddCustomerReq(AddCustomerReq addCustomerReq){
        validateName(addCustomerReq.getName());
        validateEmail(addCustomerReq.getEmail());
    }

    private void validateName(String name){
        if(name == null) {
            throw new IllegalArgumentException("Name cannot be EMPTY");
        }
        if(name.length()<3 || name.length()>100) {
            throw new IllegalArgumentException("Name must be between 3 and 100 characters long");
        }
    }

    private void validateEmail(String email){

    }


}
