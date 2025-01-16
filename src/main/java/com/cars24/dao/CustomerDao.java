package com.cars24.dao;

import com.cars24.data.Entities.req.AddCustomerReq;
import com.cars24.data.Entities.req.DeleteCustomerReq;
import com.cars24.data.Entities.req.SearchCustomerReq;
import com.cars24.data.Entities.req.UpdateCustomerReq;
import com.cars24.data.Entities.resp.CustomerProfileResponse;

import java.lang.*;

// DAO -> Data access object
public interface CustomerDao {

    public String createCustomer(AddCustomerReq addCustomerReq);

    public CustomerProfileResponse getCustomer(SearchCustomerReq searchCustomerReq);

    public String updateCustomerByPhone(UpdateCustomerReq updateCustomerReq);

    public String updateCustomerByEmail(UpdateCustomerReq updateCustomerReq);

    public String deleteCustomer(DeleteCustomerReq deleteCustomerReq);

}
