package com.cars24.runner;

import com.cars24.data.Entities.req.AddCustomerReq;
import com.cars24.data.Entities.req.DeleteCustomerReq;
import com.cars24.data.Entities.req.SearchCustomerReq;
import com.cars24.data.Entities.req.UpdateCustomerReq;
import com.cars24.services.impl.CustomerServiceImpl;
import com.cars24.util.DbUtil;

import java.util.Scanner;

public class Ui {

    static CustomerServiceImpl customerService = new CustomerServiceImpl();

    private static Scanner scanner  = new Scanner(System.in);
    public static void addCustomer()
    {
        System.out.println("Enter customer details");
        AddCustomerReq req = new AddCustomerReq();
        System.out.println("Enter name of the customer: ");
        req.setName(scanner.next());
        System.out.println("Enter phone number of the customer");
        req.setPhone(scanner.next());
        System.out.println("Enter email of the customer");
        req.setEmail(scanner.next());
        System.out.println("Enter addresss of the customer");
        req.setAddress(scanner.next());
        System.out.println(customerService.registerCustomer(req));

    }

    public static void getCustomer()
    {
        System.out.println("Search customer details");
        SearchCustomerReq searchCustomerReq = new SearchCustomerReq();

        System.out.println("Enter Email  : ");
        searchCustomerReq.setEmail(scanner.next());

        System.out.println("Enter Phone  : ");
        searchCustomerReq.setPhone(scanner.next());

        System.out.println(customerService.getCustomer(searchCustomerReq));

    }

    public static void updateCustomerByEmail(){
        System.out.println("Update customer by email");
        UpdateCustomerReq updateCustomerReq = new UpdateCustomerReq();

        System.out.println("Enter existing email of the customer");
        updateCustomerReq.setEmail(scanner.next());

        System.out.println("Enter updated/existing name of the customer");
        updateCustomerReq.setName(scanner.next());

        System.out.println("Enter updated/existing phone of the customer");
        updateCustomerReq.setPhone(scanner.next());

        System.out.println("Enter updated/existing address of the customer");
        updateCustomerReq.setAddress(scanner.next());

        System.out.println(customerService.updateCustomerByEmail(updateCustomerReq));
    }

    public static void updateCustomerByPhone(){
        System.out.println("Update customer by phone number");
        UpdateCustomerReq updateCustomerReq = new UpdateCustomerReq();

        System.out.println("Enter existing phone number of the customer");
        updateCustomerReq.setPhone(scanner.next());

        System.out.println("Enter updated/existing name of the customer");
        updateCustomerReq.setName(scanner.next());

        System.out.println("Enter updated/existing email of the customer");
        updateCustomerReq.setEmail(scanner.next());

        System.out.println("Enter updated/existing address of the customer");
        updateCustomerReq.setAddress(scanner.next());

        System.out.println(customerService.updateCustomerByPhone(updateCustomerReq));
    }

    public static void deleteCustomer(){
        System.out.println("Delete customer");
        DeleteCustomerReq deleteCustomerReq = new DeleteCustomerReq();

        System.out.println("Enter email of the customer");
        deleteCustomerReq.setEmail(scanner.next());

        System.out.println("Enter phone of the customer");
        deleteCustomerReq.setPhone(scanner.next());

        System.out.println(customerService.deleteCustomer(deleteCustomerReq));
    }

}

