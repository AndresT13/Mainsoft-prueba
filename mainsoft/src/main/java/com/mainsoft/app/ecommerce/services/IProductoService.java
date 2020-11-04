package com.mainsoft.app.ecommerce.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mainsoft.app.ecommerce.entity.Producto;

public interface IProductoService {

	public List<Producto> FindAll();

	public Producto FindById(Long id);

	public ResponseEntity <Producto> create(Producto producto);
	
	public ResponseEntity<Producto> update(Producto producto, Long id);

	public ResponseEntity<String> delete(Long id);

	
}
