package com.mainsoft.app.ecommerce.test;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.mainsoft.app.ecommerce.dao.IClienteDao;

@RunWith(SpringRunner.class)
@DataJpaTest
class EntitiesTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private IClienteDao clienteRepository;

	@Test

	public void creacionCliente() {

	}

}
