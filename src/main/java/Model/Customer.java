package Model;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	int id;
	String nom;
	String email;
	String phone;
	List<Orders> orders;
	
	
	public Customer(int i , String n , String e , String p) {
		this.id=id;
		this.nom=n;
		this.email=e;
		this.phone=p;
		this.orders = new ArrayList<Orders>();
	}
	
	public Customer() {
		
	}
	
	public void setId(int i) {
		this.id=i;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setEmail(String e) {
		this.email = e;
	}
	
	
	public void setPhone(String p) {
		this.phone=p;
	}
	
	
	public int getId() {
		return this.id;
	}
	
	
	public String getNom() {
		return this.nom;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	
	public List<Orders> getOrders(){
		return this.orders;
	}
	
}
