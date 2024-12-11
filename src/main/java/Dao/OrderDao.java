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

public interface OrderDao {

	
	public List<Orders> getAllOrders();
	
	public void insertOrder(Date d , double amount , int cid);
}
