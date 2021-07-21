package com.company.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Prueba Tecnica . Application
 * @author lpicareli
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.company.products"})
@EntityScan("com.company.products.model")
@EnableJpaRepositories("com.company.products.repository")
public class PruebaTecnicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaTecnicaApplication.class, args);
	}

}
