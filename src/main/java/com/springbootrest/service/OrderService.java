package com.springbootrest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springbootrest.entity.Order1;
import com.springbootrest.entity.OrderWrapper;
import com.springbootrest.entity.Product;
import com.springbootrest.repository.OrderRepository;
import com.springbootrest.repository.ProductRepository;

@Service
public class OrderService {
@Autowired
	private OrderRepository orderRepository;

@Autowired
	private ProductRepository productRepository;

	public ResponseEntity<OrderWrapper> placeOrder(int pid, int qty) {
		//check product is available
		Optional<Product> p1= productRepository.findById(pid);
		if(p1.isPresent()) 
		{
			//check the quantity in the product
			Product p=p1.get();
			if(p.getQty()>=qty)
			{

			
			//create a new order and set the values
			//product,qty,total_price,status
				Order1 o=new Order1();
				o.setProduct(p);
				o.setQty(qty);
				o.setStatus("placed");
				o.setTotalPrice(p.getPrice()*qty);
				p.setQty(p.getQty()-qty);
				
				orderRepository.save(o);
OrderWrapper ow=new OrderWrapper(o.getOid(), o.getTotalPrice(),o.getQty(),o.getStatus(),o.getProduct().getPname());
			//return the String that order is placed.
				
				return ResponseEntity.ok(ow);
			}
			else 
			{
				throw new RuntimeException("Stock unavailable");
			}
		}
		
		else 
		{
			throw new RuntimeException("Product is not available");
		}
	}

	public String cancelOrder(int oid) 
	{
		Optional<Order1> existingOrder= orderRepository.findById(oid);
		if(existingOrder.isPresent()) 
		{
			//i want reverse the product quantity
			Product p= existingOrder.get().getProduct();
			
			p.setQty(p.getQty()+existingOrder.get().getQty());
			productRepository.save(p);
		    orderRepository.deleteById(oid);
		    
		    return "Order Cancelled Successfully";
		}
		else
		{
			return "Invalid order Id";
		}
			
		
	}
}
