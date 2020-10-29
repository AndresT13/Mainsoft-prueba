package com.mainsoft.app.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mainsoft.app.ecommerce.entity.Cliente;
import com.mainsoft.app.ecommerce.services.IClienteService;

@RestController
@Validated
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
	public ResponseEntity<?> Crear(@Valid @RequestBody Cliente cliente) {
		return clienteService.create(cliente);

	}

}
