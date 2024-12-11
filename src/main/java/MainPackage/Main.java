package MainPackage;

import ThreadManager.OrderWorker;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Main {

	
	
	public static void main(String[] args) {
	List<Map<String,Object>> Orders = readOrdersFromFile("C:\\Users\\dadda\\Desktop\\eclipseprojects\\Devoir_threads\\src\\main\\java\\data\\input.json");
	
	//for(Map<String,Object> o : Orders) {
		//System.out.println(o.get("customer_id"));
	//}
	
	int num_threads=5;
	ExecutorService executor = Executors.newFixedThreadPool(num_threads);
	
	
	// ici , on divise les ordres sur les 5 threads d'une manière égale
	int order_per_thread = (int) Math.ceil(Orders.size()/(double) num_threads);
	
	
    for (int i = 0; i < Orders.size(); i += order_per_thread) {
        List<Map<String, Object>> batch = Orders.subList(i, Math.min(i + order_per_thread, Orders.size()));
        OrderWorker worker = new OrderWorker(batch);
        System.out.println("Submitting task for orders: " + i + " to " + (i + order_per_thread)); // Log task submission
        executor.submit(worker);
    }
    
    executor.shutdown();
    try {
        if (!executor.awaitTermination(60, TimeUnit.SECONDS)) { // Wait for tasks to finish
            executor.shutdownNow();
        }
    } catch (InterruptedException e) {
        executor.shutdownNow();
    }
	
	}
	
	
	private static List<Map<String, Object>> readOrdersFromFile(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, new TypeToken<List<Map<String, Object>>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
	
	
	
	

}
	




