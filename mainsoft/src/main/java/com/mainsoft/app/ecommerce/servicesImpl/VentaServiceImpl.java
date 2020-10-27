package com.mainsoft.app.ecommerce.servicesImpl;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mainsoft.app.ecommerce.dao.IVentaDao;
import com.mainsoft.app.ecommerce.entity.DetalleVenta;
import com.mainsoft.app.ecommerce.entity.Venta;
import com.mainsoft.app.ecommerce.exception.ResourceNotFoundException;
import com.mainsoft.app.ecommerce.services.IVentaService;

import io.reactivex.Observable;

@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	private IVentaDao ventaDao;

	@Override
	public List<Venta> FindAll() {
		return ventaDao.findAll();
	}

	@Override
	public Venta findById(Long id) {

		return ventaDao.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("no se encontro la venta con ID:" + id + "no existe!"));

	}

	@Override
	public ResponseEntity<Venta> create(Venta venta) {
		Venta addVenta = ventaDao.save(venta);

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}")
				.buildAndExpand(addVenta.getIdVenta()).toUri();

		return ResponseEntity.created(location).build();

	}

	@Override
	public Observable<DetalleVenta> getDtlleVentaObs(Long id) {
		return findSaleDetails(id);

	}

	private Observable<DetalleVenta> findSaleDetails(Long id) {
		return Observable.fromIterable(ventaDao.getOne(id).getDetalles());

	}

}
