package Model;

import java.util.Date;

public class Orders {

	int id;
	Date dateorder;
	double amount;
	Customer customer;
	
	
	public Orders(int i , Date d , double a , Customer c) {
	this.id=i;
	this.dateorder=d;
	this.amount=a;
	this.customer=c;
	}
	
	public Orders(int i , Date d , double a) {
		this.id=i;
		this.dateorder=d;
		this.amount=a;
		customer = new Customer();
		}
	
	
	public Orders() {
		
	}
	
	public int getId() {
		return this.id;
	}
	
	public Date getDateOrder() {
		return this.dateorder;
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	
	public Customer getCustomer() {
		return this.customer;
	}
	
}
