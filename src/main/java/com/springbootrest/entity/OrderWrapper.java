package com.springbootrest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderWrapper {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int oid;
	private int totalprice;
	private int qty;
	private String status;
	private String pname;
	
	public OrderWrapper() {}


	public OrderWrapper(int oid, int totalprice, int qty, String status, String pname) {
		super();
		this.oid = oid;
		this.totalprice = totalprice;
		this.qty = qty;
		this.status = status;
		this.pname = pname;
	}


	public int getOid() {
		return oid;
	}


	public void setOid(int oid) {
		this.oid = oid;
	}


	public int getTotalprice() {
		return totalprice;
	}


	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
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


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}



	
	
	

}
