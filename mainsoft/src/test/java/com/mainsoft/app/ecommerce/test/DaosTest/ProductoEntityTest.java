package com.mainsoft.app.ecommerce.test.DaosTest;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;

import com.mainsoft.app.ecommerce.entity.Producto;
import com.mainsoft.app.ecommerce.services.IProductoService;

import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class ProductoEntityTest {

	@Autowired
	private IProductoService productoService;

	@Test
	@Transactional
	@Rollback(true)
	void contextLoads() {

		Producto productoTest = new Producto();
		productoTest.setIdProducto(11L);
		productoTest.setNombre("Harley Davinson Fat bot");
		productoTest.setPrecio("50000000");

		ResponseEntity<Producto> productoEntity = productoService.create(productoTest);
		System.out.println(productoEntity.getStatusCodeValue());
		Assert.assertTrue(productoEntity.getStatusCode() == HttpStatus.CREATED);

	}

}
