package ThreadManager;


import DBManager.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Date;
import java.io.FileWriter;
import java.io.IOException;
import DaoImp.CustomerDaoImp;
import DaoImp.OrderDaoImp;



public class OrderWorker extends Thread {
	
	private List<Map<String,Object>> orders;
	private static final OrderDaoImp o = new OrderDaoImp();
	private static final CustomerDaoImp c = new CustomerDaoImp();
	
	public OrderWorker(List<Map<String,Object>> orders) {
		this.orders = orders;
	}
	
	@Override
	public void run() {
	    for(Map<String,Object> order : orders) {
	        try {
	            int customerId = (int)(double) order.get("customer_id");
	            if(c.customerExists(customerId)) {
	                System.out.println("Customer exists for id: " + customerId);
	                
	                // Handle the date conversion from String to java.sql.Date if necessary
	                Object dateObj = order.get("date");
	                java.sql.Date orderDate = null;
	                
	                if (dateObj instanceof String) {
	                    // If the date is a String, convert it
	                    orderDate = java.sql.Date.valueOf((String) dateObj);
	                } else if (dateObj instanceof java.sql.Date) {
	                    // If it's already a java.sql.Date, no conversion needed
	                    orderDate = (java.sql.Date) dateObj;
	                }
	                
	                // Proceed with inserting the order
	                o.insertOrder(orderDate, (double)order.get("amount"), customerId);
	                writeToFile("C:\\Users\\dadda\\Desktop\\eclipseprojects\\Devoir_threads\\src\\main\\java\\data\\output.json", order);
	            }
	            else {
	                writeToFile("C:\\Users\\dadda\\Desktop\\eclipseprojects\\Devoir_threads\\src\\main\\java\\data\\error.json", order);
	            }
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

	
	
	
	
	
	private synchronized void writeToFile(String filePath, Map<String,Object> order) {
	    try (FileWriter writer = new FileWriter(filePath, true)) { // 'true' for append mode
	        writer.write(order.toString() + System.lineSeparator());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	
	 public static void main(String[] args) {
	        // Create a test order to simulate processing
	        Map<String, Object> order1 = new HashMap<>();
	        order1.put("customer_id", 1);
	        order1.put("date", Date.valueOf("2024-12-11"));
	        order1.put("amount", 100.0);

	        Map<String, Object> order2 = new HashMap<>();
	        order2.put("customer_id", 2);
	        order2.put("date", Date.valueOf("2024-12-12"));
	        order2.put("amount", 200.0);

	        // Create a list of orders
	        List<Map<String, Object>> orders = List.of(order1, order2);

	        // Create and run the OrderWorker
	        OrderWorker worker = new OrderWorker(orders);
	        worker.run();  // Directly call run() for testing purposes
	    }

}
