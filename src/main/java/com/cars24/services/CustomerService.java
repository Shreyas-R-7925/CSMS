package com.cars24.services;

import com.cars24.data.Entities.req.AddCustomer;
import com.cars24.data.Entities.req.SearchCustomerReq;
import com.cars24.data.Entities.resp.CustomerProfileResponse;

// service classes corresponds to the business logic
// dao classes corresponds to the database logic ( CRUD )

public interface CustomerService {

    public String registerCustomer(AddCustomer addCustomer);

    public CustomerProfileResponse getCustomer(SearchCustomerReq searchCustomerReq);
}
