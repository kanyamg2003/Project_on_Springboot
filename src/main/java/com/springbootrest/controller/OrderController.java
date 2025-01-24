package com.springbootrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrest.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@PostMapping("/placeorder")
	public Object placeOrder(@RequestParam int pid,@RequestParam int qty) 
	{
		return orderService.placeOrder(pid,qty);
	}
	
	@DeleteMapping("/cancelorder/{oid}")
	public String cancelOrder(@PathVariable int oid) 
	{
		return orderService.cancelOrder(oid);
	}
}
