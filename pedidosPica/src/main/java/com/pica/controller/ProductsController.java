package com.pica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pica.beans.Product;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {

	private static final List<Product> DUMMY_PRODUCTS = new ArrayList<Product>();
	
	static {
		DUMMY_PRODUCTS.add(new Product("1", "Sandwich de milanesa", "Milanesa de carne, lechuga, tomate, jamon, queso", "milanesa.jpg", 40.00));
		DUMMY_PRODUCTS.add(new Product("2", "Sandwich de suprema", "Milanesa de pollo, lechuga, tomate, jamon, queso", "milanesa.jpg", 40.00));
		DUMMY_PRODUCTS.add(new Product("3", "Ensalada", "espinaca, zanahoria, huevo, lechuga, tomate, jamon, queso", "ensalada.jpg", 40.00));
		DUMMY_PRODUCTS.add(new Product("4", "Empanada", "carne, pollo, humita, caprese, jamon/queso", "empanadas.jpg", 12.00));
	}
	
	@RequestMapping(value="/get", method = RequestMethod.GET, produces="application/json; charset=UTF-8;")
	@ResponseBody
	public List<Product> getOrders() {
		return DUMMY_PRODUCTS;
	}
	
}