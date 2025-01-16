//package com.cars24.runner;
//
//import com.cars24.dao.CustomerDao;
//import com.cars24.dao.impl.CustomerDaoImpl;
//import com.cars24.data.Entities.req.AddCustomerReq;
//import com.cars24.data.Entities.req.SearchCustomerReq;
//import com.cars24.data.Entities.resp.CustomerProfileResponse;
//import com.cars24.services.CustomerService;
//import com.cars24.services.impl.CustomerServiceImpl;
//import com.cars24.util.DbUtil;
//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner  = new Scanner(System.in);
//        boolean exit = true;
//        System.out.println("Enter choice: ");
//        System.out.println("1 -> Add customer");
//        System.out.println("2 -> Get customer");
//        System.out.println("0 -> Exit");
//        while(exit){
//            int choice = scanner.nextInt();
//
//            switch (choice){
//                case 1: Ui.addCustomer();
//                    break;
//                case 2: Ui.getCustomer();
//                    break;
//                case 0:
//                    exit = false;
//            }
//        }
//
//    }
//}


package com.cars24.runner;

import com.cars24.data.Entities.req.DeleteCustomerReq;
import com.cars24.data.Entities.req.UpdateCustomerReq;
import com.cars24.services.impl.CustomerServiceImpl;
import com.cars24.util.DbUtil;

public class Main {
    public static void main(String[] args) {
        System.out.println("Application starts!!");
        DbUtil.getDbConnection();
        CustomerServiceImpl customerService = new CustomerServiceImpl();

//        AddCustomerReq addCustomer = new AddCustomerReq();
//        addCustomer.setName("shreyas_r");
//        addCustomer.setPhone("9606250176");
//        addCustomer.setEmail("suma@gmail.com");
//        addCustomer.setAddress("G12");
//        customerService.registerCustomer(addCustomer);

//        CustomerDaoImpl customerDao = new CustomerDaoImpl();
//        SearchCustomerReq searchCustomerReq = new SearchCustomerReq();
//        searchCustomerReq.setEmail("john.doe@example.com");
//        searchCustomerReq.setPhone("9876543210");
//        CustomerProfileResponse response = customerDao.getCustomer(searchCustomerReq);
//        System.out.println(response);

//        CustomerProfileResponse res = customerService.getCustomer(searchCustomerReq);
//        System.out.println(res);

//        UpdateCustomerReq updateCustomerReq = new UpdateCustomerReq();
//        updateCustomerReq.setName("NewMary");
//        updateCustomerReq.setEmail("mary.jane@example.com");
//        updateCustomerReq.setPhone("9999991111");
//        updateCustomerReq.setAddress("Pune");

//        String res = customerService.updateCustomerByEmail(updateCustomerReq);
//        System.out.println(res);
//
//        UpdateCustomerReq updateCustomerReq2 = new UpdateCustomerReq();
//        updateCustomerReq2.setPhone("8765432109");
//        updateCustomerReq2.setName("NewJane");
//        updateCustomerReq2.setEmail("newJane@example.com");
//        updateCustomerReq2.setAddress("Bombay");
//
//        String res2 = customerService.updateCustomerByPhone(updateCustomerReq2);
//        System.out.println(res2);

        DeleteCustomerReq deleteCustomerReq = new DeleteCustomerReq();
        deleteCustomerReq.setPhone("7473745553");
        deleteCustomerReq.setEmail("jackadf@gmalil.com");

        String response = customerService.deleteCustomer(deleteCustomerReq);
        System.out.println(response);


        System.out.println("Application stopped");
    }
}



// main depends on service
// service depends on dao