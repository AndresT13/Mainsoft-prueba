package com.mainsoft.app.ecommerce.servicesImpl;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mainsoft.app.ecommerce.dao.IProductoDao;
import com.mainsoft.app.ecommerce.entity.Producto;
import com.mainsoft.app.ecommerce.exception.ResourceNotFoundException;
import com.mainsoft.app.ecommerce.services.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoDao productoDao;

	@Override
	public List<Producto> FindAll() {
		return productoDao.findAll();
	}

	@Override
	@Transactional
	public Producto FindById(Long id) {
		return productoDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Producto con ID: " + id + " no existe!"));

	}

	@Override
	public ResponseEntity<Producto> create(Producto producto) {

		Producto addProducto = productoDao.save(producto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(addProducto.getIdProducto()).toUri();

		return ResponseEntity.created(location).build();

	}

	@Override
	public ResponseEntity<Producto> update(Producto producto, Long id) {
		Producto prod = productoDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Producto con ID: " + id + " no existe!"));

		return ResponseEntity.ok().body(prod);

	}

	@Override
	public ResponseEntity<String> delete(Long id) {

		Producto prod = productoDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Producto con ID: " + id + " no existe!"));

		productoDao.deleteById(prod.getIdProducto());
		return ResponseEntity.ok().body("Usuario Borrado exitosamente!");

	}

}
