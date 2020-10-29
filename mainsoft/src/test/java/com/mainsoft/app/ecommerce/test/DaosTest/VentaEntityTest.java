package com.mainsoft.app.ecommerce.test.DaosTest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.mainsoft.app.ecommerce.entity.Venta;
import com.mainsoft.app.ecommerce.services.IVentaService;

@SpringBootTest
class VentaEntityTest {

	@Autowired
	private IVentaService ventaService;

	@Test
	@Transactional
	@Rollback(value = true)
	void test() {

		Venta ventaTest = ventaService.findById(1L);
		Assert.assertTrue(ventaTest.getIdVenta() == 1L);

	}

}
