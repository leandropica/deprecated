package com.company.products;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Prueba Tecnica . Test cases
 * @author lpicareli
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PruebaTecnicaApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
  locations = "classpath:application.properties")
class PriceTest {

	@Autowired
	private MockMvc mvc;

	/**
	 * Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (Tienda)
	 */
	@Test
	public void test1() throws Exception 
	{
	  mvc.perform(get("/api/prices/{productId}", 35455)
	      .param("date", "2020-06-14-10.00.00")
	      .param("brandId", "1")
	      .accept(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(status().isOk())
	  	  .andExpect(jsonPath("$.priceList").value(1));
	}

	/**
	 * Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (Tienda)
	 */
	@Test
	public void test2() throws Exception 
	{
	  mvc.perform(get("/api/prices/{productId}", 35455)
	      .param("date", "2020-06-14-16.00.00")
	      .param("brandId", "1")
	      .accept(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$.priceList").value(2));
	}
	
	/**
	 * Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (Tienda)
	 */
	@Test
	public void test3() throws Exception 
	{
	  mvc.perform(MockMvcRequestBuilders
	      .get("/api/prices/{productId}", 35455)
	      .param("date", "2020-06-14-21.00.00")
	      .param("brandId", "1")
	      .accept(MediaType.APPLICATION_JSON))
      	  .andDo(print())
      	  .andExpect(status().isOk())
      	  .andExpect(jsonPath("$.priceList").value(1));
	}
	
	/**
	 * Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (Tienda)
	 */
	@Test
	public void test4() throws Exception 
	{
	  mvc.perform(MockMvcRequestBuilders
	      .get("/api/prices/{productId}", 35455)
	      .param("date", "2020-06-15-10.00.00")
	      .param("brandId", "1")
	      .accept(MediaType.APPLICATION_JSON))
          .andDo(print())
          .andExpect(status().isOk())
	      .andExpect(jsonPath("$.priceList").value(3));
	}

	/**
	 * Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (Tienda)
	 */
	@Test
	public void test5() throws Exception 
	{
	  mvc.perform(MockMvcRequestBuilders
	      .get("/api/prices/{productId}", 35455)
	      .param("date", "2020-06-16-21.00.00")
	      .param("brandId", "1")
	      .accept(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$.priceList").value(4));
	}
}
