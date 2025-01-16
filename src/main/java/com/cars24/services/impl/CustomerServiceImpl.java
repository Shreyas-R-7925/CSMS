package com.cars24.services.impl;

import com.cars24.dao.impl.CustomerDaoImpl;
import com.cars24.data.Entities.req.AddCustomerReq;
import com.cars24.data.Entities.req.DeleteCustomerReq;
import com.cars24.data.Entities.req.SearchCustomerReq;
import com.cars24.data.Entities.req.UpdateCustomerReq;
import com.cars24.data.Entities.resp.CustomerProfileResponse;
import com.cars24.services.CustomerService;

import static com.cars24.validation.CustomerValidator.*;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDaoImpl customerDao = new CustomerDaoImpl();
    @Override
    public String registerCustomer(AddCustomerReq addCustomerReq) {
        try {
            validateAddCustomer(addCustomerReq);
            customerDao.createCustomer(addCustomerReq);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public CustomerProfileResponse getCustomer(SearchCustomerReq searchCustomerReq){
        try {
            validateGetCustomer(searchCustomerReq);
            CustomerProfileResponse response = customerDao.getCustomer(searchCustomerReq);
            return response;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String updateCustomerByEmail(UpdateCustomerReq updateCustomerReq) {
        try {
            validateUpdateCustomer(updateCustomerReq);
            String updatedResponse = customerDao.updateCustomerByEmail(updateCustomerReq);
            return updatedResponse;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String updateCustomerByPhone(UpdateCustomerReq updateCustomerReq){
        try{
            validateUpdateCustomer(updateCustomerReq);
            String updatedResponse = customerDao.updateCustomerByPhone(updateCustomerReq);
            return updatedResponse;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteCustomer(DeleteCustomerReq deleteCustomerReq){
        try {
            validateDeleteCustomer(deleteCustomerReq);
            String deletedResponse = customerDao.deleteCustomer(deleteCustomerReq);
            return deletedResponse;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
