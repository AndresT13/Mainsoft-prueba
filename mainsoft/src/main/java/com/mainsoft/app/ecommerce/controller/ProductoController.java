package com.mainsoft.app.ecommerce.controller;

import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mainsoft.app.ecommerce.entity.Producto;
import com.mainsoft.app.ecommerce.services.IProductoService;

@RestController
@RequestMapping("/api")
@Validated
public class ProductoController {

	@Autowired
	private IProductoService ProductoService;

	@GetMapping("/productos")
	public List<Producto> list() {
		return ProductoService.FindAll();
	}

	@GetMapping(value = "/productos/{id}")
	public Producto Mostrar(@PathVariable Long id) {
		return ProductoService.FindById(id);
	}

	@PostMapping("/productos")
	public ResponseEntity<?> Crear(@RequestBody Producto producto) {
		return ProductoService.create(producto);
	}

	@PutMapping(value = "/productos/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> Update(@RequestBody Producto producto, @PathVariable("id") @Min(1) Long id) {
		return ProductoService.update(producto, id);

	}

	@DeleteMapping("/productos/{id}")
	public ResponseEntity<String> Delete(@PathVariable Long id) {
		return ProductoService.delete(id);
	}

}
