package com.mainsoft.app.ecommerce.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mainsoft.app.ecommerce.entity.Cliente;
import com.mainsoft.app.ecommerce.services.IClienteService;

@RestController

@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	@GetMapping("/clientes")
	public List<Cliente> list() {
		return clienteService.list();
		
	}

	@PostMapping(value = "/clientes")
	@Valid
	public ResponseEntity<?> Crear(@RequestBody Cliente cliente) {
		ResponseEntity<?> clienteNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			clienteNew = clienteService.create(cliente);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la creación en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente ha sido creado con éxito!");
		response.put("cliente", clienteNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
		

	}

}
