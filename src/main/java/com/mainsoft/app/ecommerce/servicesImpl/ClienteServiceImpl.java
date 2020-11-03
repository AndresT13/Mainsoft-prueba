package com.mainsoft.app.ecommerce.servicesImpl;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mainsoft.app.ecommerce.dao.IClienteDao;
import com.mainsoft.app.ecommerce.entity.Cliente;
import com.mainsoft.app.ecommerce.exception.ResourceNotFoundException;
import com.mainsoft.app.ecommerce.services.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;

	@Override
	public List<Cliente> list() {
		return clienteDao.findAll();
	}

	@Override
	public ResponseEntity<Cliente> findById(long id) {
		Cliente cliente = clienteDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El cliente con número de ID: " + id + " no existe!"));
		return ResponseEntity.ok().body(cliente);
	}

	@Override
	public ResponseEntity<?> create(Cliente cliente) {
		Cliente addCliente = clienteDao.save(cliente);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/{id}")
				.buildAndExpand(addCliente.getIdCliente())
				.toUri();
		return ResponseEntity.created(location).build();
	}

}
