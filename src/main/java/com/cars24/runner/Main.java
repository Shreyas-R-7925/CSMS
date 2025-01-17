package com.cars24.runner;

import com.cars24.dao.CustomerDao;
import com.cars24.dao.impl.CustomerDaoImpl;
import com.cars24.data.Entities.req.AddCustomerReq;
import com.cars24.data.Entities.req.SearchCustomerReq;
import com.cars24.data.Entities.resp.CustomerProfileResponse;
import com.cars24.services.CustomerService;
import com.cars24.services.impl.CustomerServiceImpl;
import com.cars24.util.DbUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner  = new Scanner(System.in);
        boolean exit = true;
        System.out.println("Enter choice: ");
        System.out.println("1 -> Add customer");
        System.out.println("2 -> Get customer");
        System.out.println("3 -> Update customer by phone");
        System.out.println("4 -> Update customer by email");
        System.out.println("5 -> Delete customer");
        System.out.println("0 -> Exit");
        while(exit){
            int choice = scanner.nextInt();

            switch (choice){
                case 1: Ui.addCustomer();
                    break;
                case 2: Ui.getCustomer();
                    break;
                case 3: Ui.updateCustomerByPhone();
                    break;
                case 4: Ui.updateCustomerByEmail();
                    break;
                case 5: Ui.deleteCustomer();
                    break;
                case 0:
                    exit = false;
            }
        }

    }
}

// main depends on service
// service depends on dao