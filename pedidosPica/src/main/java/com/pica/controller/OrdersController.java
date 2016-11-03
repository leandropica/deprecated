package com.pica.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pica.beans.Order;
import com.pica.beans.Product;

@RestController
@RequestMapping(value = "/orders")
public class OrdersController {

	private static final List<Order> DUMMY_ORDERS = new ArrayList<Order>();
	
	static {
		DUMMY_ORDERS.add(new Order("Marian", new Product("1", "Sand. Mila","Sand. Mila","",35.00), 1));
		DUMMY_ORDERS.add(new Order("Jorgito", new Product("2", "Empanadas","Empanadas","",12.00), 3));
		DUMMY_ORDERS.add(new Order("Diegazo", new Product("3", "Ensalada","Ensalada","",35.50), 1));
		DUMMY_ORDERS.add(new Order("Pica", new Product("2", "Empanadas","Empanadas","",12.00), 3));
	}
	
	@RequestMapping(value="/get", method = RequestMethod.GET, produces="application/json; charset=UTF-8;")
	@ResponseBody
	public List<Order> getOrders() {
		return DUMMY_ORDERS;
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST, consumes="application/json; charset=UTF-8;")
	public void addOrder(HttpServletRequest request, HttpServletResponse response, @RequestBody Order order) {
		String userId = (String) request.getSession().getAttribute("USER");
		if (userId == null) userId = "anonimo";
		// saving ...
		order.setProduct(getProductById(order.getProduct().getId()));
		DUMMY_ORDERS.add(order);
		response.setStatus(HttpStatus.SC_OK);
	}
	
	private Product getProductById (String id){ //DUMMY
		if ("1".equals(id)) return new Product(id, "Sand. Mila","Sand. Mila","",35.00);
		return new Product(id, "Empanadas","Empanadas","",12.00); 
	}
}