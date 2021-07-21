package com.company.products.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.company.products.model.Price;

/**
 * Prueba Tecnica . Price Repository
 * @author lpicareli
 */
public interface PriceRepository extends JpaRepository<Price, Long> {

	List<Price> findByProductId(Long productId);
	
	@Query("select a from Price a where a.productId = :productId and a.brandId = :brandId and a.startDate <= :date and a.endDate >= :date order by a.priority desc")
    List<Price> findWithSpecificDate (
    	@Param("productId") Long productId,
    	@Param("brandId") Long brandId,
    	@Param("date") Date date);

}
