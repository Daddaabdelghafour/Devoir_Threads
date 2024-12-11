package DBManager;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DbConnection {

	private Connection conn ;
	private static final String url = "jdbc:mysql://localhost:3306/DL_Threads";
	private static final String username = "root";
	private static final String password = "";
	
	
	public Connection getConnection() {
		if(conn == null) {
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	return conn;
	}
	
	
	public void closeConnection() {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
				System.out.println("Fermeture de la connection");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
}
