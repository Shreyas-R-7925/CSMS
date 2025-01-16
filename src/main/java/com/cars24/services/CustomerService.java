package com.cars24.services;

import com.cars24.data.Entities.req.AddCustomerReq;
import com.cars24.data.Entities.req.DeleteCustomerReq;
import com.cars24.data.Entities.req.SearchCustomerReq;
import com.cars24.data.Entities.req.UpdateCustomerReq;
import com.cars24.data.Entities.resp.CustomerProfileResponse;

// service classes corresponds to the business logic
// dao classes corresponds to the database logic ( CRUD )

public interface CustomerService {

    public String registerCustomer(AddCustomerReq addCustomerReq);

    public CustomerProfileResponse getCustomer(SearchCustomerReq searchCustomerReq);

    public String updateCustomerByPhone(UpdateCustomerReq updateCustomerReq);

    public String updateCustomerByEmail(UpdateCustomerReq updateCustomerReq);

    public String deleteCustomer(DeleteCustomerReq deleteCustomerReq);
}
