package com.cars24.validation;

import com.cars24.data.req.AddCustomerReq;



public class CustomerValidation {
    public void validateAddCustomerRequest(AddCustomerReq addCustomerReq) {
        //throwing an exception manually so that if name is wrong then doesn't go further

        validateCustomerName(addCustomerReq.getName());
        // validateCustomerPhone(addCustomerReq.getPhone());
    }
    private void validateCustomerName(String name){
        if(name==null){
            throw new IllegalArgumentException("Name cannot be Empty");
        }
        if(name.length()<3 || name.length()>100){
            throw new IllegalArgumentException("Name should be 3 char min and 100 char max");
        }
    }
//    public boolean validateCustomerPhone(String phone){
//        String regex = "^[6-9]\\d{9}$";
//
//        // Check if the phone number matches the regex
//        return phone.matches(regex);
//    }


}