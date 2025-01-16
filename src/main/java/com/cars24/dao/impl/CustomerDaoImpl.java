package com.cars24.dao.impl;

import com.cars24.dao.CustomerDao;
import com.cars24.data.Entities.req.AddCustomer;
import com.cars24.data.Entities.req.SearchCustomerReq;
import com.cars24.data.Entities.resp.CustomerProfileResponse;
import com.cars24.util.DbUtil;

import java.sql.*;

public class CustomerDaoImpl implements CustomerDao {

    private final static String INSERT_SUCCESS_MESSAGE = "Customer added successfully!";
    private final static String INSERT_ERROR_MESSAGE = "Error! while adding the customer";

    private final static String READ_SUCCESS_MESSAGE = "Customer read";

    public String createCustomerv1(String name, String phone, String email, String address) {

        Connection connection = DbUtil.getDbConnection();
        String insertSQL =
                "INSERT INTO customers (name,phone,email,address) VALUES"
                + "("+ "'" + name + "' ," + "'" + phone + "' , '" + email + "' ,'" + address + "'" + ");";
//        System.out.println(insertSQL);

        try {
            Statement statement = connection.createStatement();
            int rowsInserted = statement.executeUpdate(insertSQL);
//            System.out.println(rowsInserted + " row(s) inserted.");
            return INSERT_SUCCESS_MESSAGE;
        } catch (SQLException e){
            System.out.println("Error while inserting data to customer table " + e);
            e.printStackTrace();
            return INSERT_ERROR_MESSAGE;
        }
    }

    @Override
    public String createCustomer(AddCustomer addCustomer){
        Connection connection = DbUtil.getDbConnection();

        String insertSQL = "INSERT INTO customers (name, phone, email, address) VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, addCustomer.getName());
            preparedStatement.setString(2, addCustomer.getPhone());
            preparedStatement.setString(3, addCustomer.getEmail());
            preparedStatement.setString(4, addCustomer.getAddress());

            int rowsInserted = preparedStatement.executeUpdate();
//            System.out.println("Rows inserted : " + rowsInserted);
            return INSERT_SUCCESS_MESSAGE;
        }

        catch (Exception e){
            System.out.println(e);
            return INSERT_ERROR_MESSAGE;
        }
    }

    @Override
    public CustomerProfileResponse getCustomer(SearchCustomerReq searchCustomerReq){
        Connection connection = DbUtil.getDbConnection();

        String readSQL = "SELECT name, phone, email, address FROM customers where phone = ? or email = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(readSQL);
            preparedStatement.setString(1, searchCustomerReq.getPhone());
            preparedStatement.setString(2,searchCustomerReq.getEmail());

            CustomerProfileResponse response = new CustomerProfileResponse();
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                response.setName(resultSet.getString("name"));
                response.setEmail(resultSet.getString("email"));
                response.setPhone(resultSet.getString("phone"));
                response.setAddress(resultSet.getString("address"));
            }
            return response;
        }
        catch (Exception e){
            System.out.println("Data not found!");
        }

        return null;
    }
}
