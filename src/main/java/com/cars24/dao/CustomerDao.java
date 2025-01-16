package com.cars24.dao;

import com.cars24.data.Entities.req.AddCustomer;
import com.cars24.data.Entities.req.SearchCustomerReq;
import com.cars24.data.Entities.resp.CustomerProfileResponse;

import java.lang.*;

// DAO -> Data access object
public interface CustomerDao {

    public String createCustomer(AddCustomer addCustomer);

    public CustomerProfileResponse getCustomer(SearchCustomerReq searchCustomerReq);

//    public void updateCustomer();

//    public void deleteCustomer();

}
