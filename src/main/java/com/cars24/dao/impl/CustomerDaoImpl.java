package com.cars24.dao.impl;

import com.cars24.dao.CustomerDao;
import com.cars24.data.Entities.req.AddCustomerReq;
import com.cars24.data.Entities.req.DeleteCustomerReq;
import com.cars24.data.Entities.req.SearchCustomerReq;
import com.cars24.data.Entities.req.UpdateCustomerReq;
import com.cars24.data.Entities.resp.CustomerProfileResponse;
import com.cars24.util.DbUtil;

import java.sql.*;

public class CustomerDaoImpl implements CustomerDao {

    private final static String INSERT_SUCCESS_MESSAGE = "Customer added successfully!";
    private final static String INSERT_ERROR_MESSAGE = "Error! while adding the customer";
    private final static String UPDATE_BY_EMAIL_SUCCESS_MESSAGE = "Customer updated by email successfully!!";
    private final static String UPDATE_BY_PHONE_SUCCESS_MESSAGE = "Customer updated by phone successfully";
    private final static String UPDATE_ERROR_MESSAGE = "Error! while updating the customer";
    private final static String DELETE_MESSAGE = "Deleted customer successfully";
    private final static String DELETE_ERROR_MESSAGE = "Error! Could not delete the specified record!";
    private final static String NO_AFFECT_MESSAGE = "No rows affected on execution.";
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
    public String createCustomer(AddCustomerReq addCustomerReq){
        Connection connection = DbUtil.getDbConnection();

        String insertSQL = "INSERT INTO customers (name, phone, email, address) VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, addCustomerReq.getName());
            preparedStatement.setString(2, addCustomerReq.getPhone());
            preparedStatement.setString(3, addCustomerReq.getEmail());
            preparedStatement.setString(4, addCustomerReq.getAddress());

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
            preparedStatement.setString(2, searchCustomerReq.getEmail());

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

    @Override
    public String updateCustomerByPhone(UpdateCustomerReq updateCustomerReq) {
        Connection connection = DbUtil.getDbConnection();

        String updateSQL = "UPDATE customers set name = ?, email = ?, address = ? where phone = ?";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setString(1, updateCustomerReq.getName());
            preparedStatement.setString(2, updateCustomerReq.getEmail());
            preparedStatement.setString(3, updateCustomerReq.getAddress());
            preparedStatement.setString(4, updateCustomerReq.getPhone());

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 0){
                return NO_AFFECT_MESSAGE;
            }

            return UPDATE_BY_PHONE_SUCCESS_MESSAGE;
        }
        catch (Exception e){
            System.out.println(e);
            return UPDATE_ERROR_MESSAGE;
        }
    }

    @Override
    public String updateCustomerByEmail(UpdateCustomerReq updateCustomerReq){
        Connection connection = DbUtil.getDbConnection();

        String updateSQL = "UPDATE customers set name = ?, phone = ?, address = ? where email = ?";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setString(1, updateCustomerReq.getName());
            preparedStatement.setString(2, updateCustomerReq.getPhone());
            preparedStatement.setString(3, updateCustomerReq.getAddress());
            preparedStatement.setString(4, updateCustomerReq.getEmail());

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 0){
                return NO_AFFECT_MESSAGE;
            }
            return UPDATE_BY_EMAIL_SUCCESS_MESSAGE;
        }
        catch (Exception e){
            System.out.println(e);
            return UPDATE_ERROR_MESSAGE;
        }
    }

    @Override
    public String deleteCustomer(DeleteCustomerReq deleteCustomerReq) {

        Connection connection = DbUtil.getDbConnection();
        String deleteSQL = "DELETE from customers where phone = ? and email = ?";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setString(1, deleteCustomerReq.getPhone());
            preparedStatement.setString(2, deleteCustomerReq.getEmail());

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 0){
                return NO_AFFECT_MESSAGE;
            }
            return DELETE_MESSAGE;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return DELETE_ERROR_MESSAGE;
        }
    }

}
