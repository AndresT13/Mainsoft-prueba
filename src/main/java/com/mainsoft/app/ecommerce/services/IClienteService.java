package com.mainsoft.app.ecommerce.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.mainsoft.app.ecommerce.entity.Cliente;

public interface IClienteService {

	public List<Cliente> list();
	
	public ResponseEntity<Cliente> findById(long id);

	public ResponseEntity<?> create(Cliente cliente);

}
