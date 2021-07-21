package com.company.products.service;

import java.util.Date;
import java.util.List;

import com.company.products.model.Price;

/**
 * Prueba Tecnica . Price Service
 * @author lpicareli
 */
public interface PriceService  {

	/**
	 * Servicio que devuelve los productos correspondientes a los parametros recibidos.
	 * @param productId
	 * @param brandId
	 * @param date
	 * @return
	 */
	public List<Price> getPrices(long productId, long brandId, Date date);
	
	/**
	 * Servicio que devuelve el producto de mayor prioridad, correspondiente a los parametros recibidos.
	 * @param productId
	 * @param brandId
	 * @param date
	 * @return
	 */
	public Price getPrice(long productId, long brandId, Date date); 
	
}
