package DaoImp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DBManager.DbConnection;
import Dao.OrderDao;
import Model.Orders;

public class OrderDaoImp implements OrderDao {

	@Override
	public List<Orders> getAllOrders(){
		List<Orders> orders = new ArrayList<Orders>();
		try {
		DbConnection db = new DbConnection();
		Connection conn = db.getConnection();
		String query = "select * from orders ";
		Statement stmt = conn.createStatement();
		ResultSet rs =stmt.executeQuery(query);
	
		while(rs.next()) {
			Orders o = new Orders(rs.getInt("id"),rs.getDate("date"),rs.getDouble("amount"));
			orders.add(o);
		}
		return orders;
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return orders;
	}
	
	
	
	@Override
	public void insertOrder(Date d , double amount , int cid) {
		try { 
		DbConnection db = new DbConnection();
		Connection conn = db.getConnection();
		String query = "insert into orders(date , amount , customer_id)"
				+ "values (?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setDate(1, d);
		stmt.setDouble(2, amount);
		stmt.setInt(3, cid);
		
		int r = stmt.executeUpdate();
		if(r != 0) {
			System.out.println("Insertion Successful");
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	

	
	
}
