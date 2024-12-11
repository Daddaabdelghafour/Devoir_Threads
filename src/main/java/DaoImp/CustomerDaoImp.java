package DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBManager.DbConnection;
import Dao.CustomerDao;
import Model.Customer;

public class CustomerDaoImp implements CustomerDao {
	
	@Override 

	public Customer getCustomerbyId(int CustomerId){
		Customer c = new Customer();
		try { 
		DbConnection db = new DbConnection();
		Connection conn = db.getConnection();
		String query = "Select * from customer where id=?";
		PreparedStatement stmt = conn.prepareStatement(query);
		
		stmt.setInt(1, CustomerId);
		ResultSet rs = stmt.executeQuery();
		c.setId(CustomerId);
		c.setEmail(rs.getString("email"));
		c.setNom(rs.getString("nom"));
		c.setPhone(rs.getString("phone"));
		
		return c;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	
	public void insertCustomer(String n , String e , String p) {
		try {
		DbConnection db = new DbConnection();
		Connection conn = db.getConnection();
		String query = "insert into customer (nom,email,phone) values"
				+ "(?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, n);
		stmt.setString(2, e);
		stmt.setString(3, p);
			
		int rs=stmt.executeUpdate();
			if(rs != 0) {
				System.out.println("Insertion Avec Success");
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	
	@Override
		public boolean customerExists(int Customer_id) {
		try {
			DbConnection db = new DbConnection();
			Connection conn = db.getConnection();
			String query = "select * from customer where id =?";
			PreparedStatement stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, Customer_id);
			try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
	

}
