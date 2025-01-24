package com.springbootrest.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;
	private String pname;
	private int price;
	private int qty;
	
	@OneToMany(mappedBy="product")
	private List<Order1> orders;
	
	
	public Product() {
		super();
	}

	
	public Product(int pid, String pname, int price, int qty, List<Order1> orders) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.qty = qty;
		this.orders = orders;
	}


	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}


	public List<Order1> getOrders() {
		return orders;
	}


	public void setOrders(List<Order1> orders) {
		this.orders = orders;
	}
	

}
