package com.mainsoft.app.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mainsoft.app.ecommerce.entity.Cliente;

@Repository
public interface IClienteDao extends JpaRepository<Cliente, Long> {
	
}
