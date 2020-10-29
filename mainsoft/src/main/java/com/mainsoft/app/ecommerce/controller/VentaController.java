package com.mainsoft.app.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mainsoft.app.ecommerce.entity.DetalleVenta;
import com.mainsoft.app.ecommerce.entity.Venta;
import com.mainsoft.app.ecommerce.services.IVentaService;

import io.reactivex.Observable;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class VentaController {

	@Autowired
	private IVentaService ventaService;

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/ventas")
	public List<Venta> list() {
		return (List<Venta>) ventaService.FindAll();

	}

	@GetMapping(value = "/ventas/{id}")
	public Venta list(@PathVariable Long id) {
		return ventaService.findById(id);

	}

	@PostMapping("/ventas")
	public ResponseEntity<Venta> CrearVenta(@RequestBody Venta venta) {
		return ventaService.create(venta);

	}

	@GetMapping(value = "/ventas/detalleventa/{id}", produces = { "application/json" }, consumes = {
			"application/json" })
	public Observable<DetalleVenta> getDetalleVenta(@PathVariable("id") Long id) {
		return ventaService.getDtlleVentaObs(id);

	}

}
