package com.springbootrest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Order1 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int oid;
	private int qty;
	private String status;
	private int totalPrice;
	
	@ManyToOne
	//if we use below annotation then only tables are joined otherwise separate table are created for product_id 
	@JoinColumn(name="product_id")
	@JsonIgnore
	
	private Product product;
	
	public Order1() {}

	public Order1(int oid, int qty, String status, int totalPrice, Product product) {
		super();
		this.oid = oid;
		this.qty = qty;
		this.status = status;
		this.totalPrice = totalPrice;
		this.product = product;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
			
   
}
