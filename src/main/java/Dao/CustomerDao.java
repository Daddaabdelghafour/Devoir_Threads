package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import DBManager.DbConnection;
import Model.Customer;
import Model.Orders;

public interface CustomerDao {

	public Customer getCustomerbyId(int CustomerId);
	
	public void insertCustomer(String n , String e , String p);
	
	public boolean customerExists(int customerId);
	       
}
