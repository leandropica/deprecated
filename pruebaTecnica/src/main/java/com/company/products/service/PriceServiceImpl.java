package com.company.products.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.products.model.Price;
import com.company.products.repository.PriceRepository;

/**
 * Prueba Tecnica . Price Service Implementation
 * @author lpicareli
 */
@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    PriceRepository repository;

	@Override
	public List<Price> getPrices(long productId, long brandId, Date date) {
		return repository.findWithSpecificDate(productId, brandId, date);
	}
	
	@Override
	public Price getPrice(long productId, long brandId, Date date) {
		List<Price> prices = repository.findWithSpecificDate(productId, brandId, date);
		if (prices != null && !prices.isEmpty()) return prices.get(0);
		return null;
	}
	
}
