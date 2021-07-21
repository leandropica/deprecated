package com.company.products.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.products.model.Price;
import com.company.products.service.PriceService;

/**
 * Prueba Tecnica . REST Controller
 * @author lpicareli
 */
@RestController
@RequestMapping("/api/prices")
@Component
public class PriceController {

    @Autowired
    PriceService priceService;
    
    /**
     * Endpoint que devuelve el registro de precio correspondiente a los parametros recibidos.
     * 
     * @param productId (path)
     * @param date (query)
     * @param brandId (query)
     * 
     * @return Price (filtered with JsonIgnore)
     */
	@GetMapping("/{productId}")
	public ResponseEntity<Price> find(@PathVariable long productId,
			@RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") Date date,
			@RequestParam(name = "brandId") long brandId) {

		try {
			Price price = priceService.getPrice(productId, brandId, date);
			if (price == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(price, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}