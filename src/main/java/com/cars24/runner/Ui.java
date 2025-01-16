package com.cars24.runner;

import com.cars24.data.Entities.req.AddCustomer;

import java.util.Scanner;

public class Ui {

    private static Scanner scanner  = new Scanner(System.in);
    public static void addCustomer()
    {
        System.out.println("Enter customer details");
        AddCustomer req = new AddCustomer();
        req.setName(scanner.next());
        req.setPhone(scanner.next());
        req.setEmail(scanner.next());
        req.setAddress(scanner.next());
        
    }

    public static void getCustomer()
    {
        System.out.println("Search customer details");

        System.out.println("Enter Email  : ");

        System.out.println("Enter Phone  : ");
    }

}

