package com.cars24.validation;

import com.cars24.data.Entities.req.AddCustomerReq;

public class CustomerValidator {

    public static void validateAddCustomer(AddCustomerReq addCustomerReq){
        validateName(addCustomerReq.getName());
        validatePhone(addCustomerReq.getPhone());
        validateGmail(addCustomerReq.getEmail());
        validateAddress(addCustomerReq.getAddress());
    }

    private static void validateName(String name){
        if(name == null){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if(name.length() < 3 || name.length() > 100){
            throw new IllegalArgumentException("Name should be min 3 or max 100 characters.");
        }
    }

    private static void validatePhone(String phone){
        if(phone.length() != 10){
            throw new IllegalArgumentException("Phone no should be equal to 10");
        }
    }

    private static void validateGmail(String email){
        if (email == null || !email.matches("^[\\w-.]+@[\\w-]+\\.[a-z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email format.");
        }
    }

    private static void validateAddress(String address){
        if(address == null){
            throw new IllegalArgumentException("Address cannot be null");
        }
    }
}
