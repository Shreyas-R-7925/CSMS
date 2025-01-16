package com.cars24.services.impl;

import com.cars24.dao.impl.CustomerDaoImpl;
import com.cars24.data.Entities.req.AddCustomer;
import com.cars24.data.Entities.req.SearchCustomerReq;
import com.cars24.data.Entities.resp.CustomerProfileResponse;
import com.cars24.services.CustomerService;

import static com.cars24.validation.CustomerValidator.validateAddCustomer;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDaoImpl customerDao = new CustomerDaoImpl();
    @Override
    public String registerCustomer(AddCustomer addCustomer) {
        try {
            validateAddCustomer(addCustomer);
            customerDao.createCustomer(addCustomer);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }


    @Override
    public CustomerProfileResponse getCustomer(SearchCustomerReq searchCustomerReq){
        CustomerProfileResponse response = customerDao.getCustomer(searchCustomerReq);
        return response;
    }


}
