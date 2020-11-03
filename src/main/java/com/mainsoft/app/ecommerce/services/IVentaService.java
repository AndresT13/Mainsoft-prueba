package com.mainsoft.app.ecommerce.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mainsoft.app.ecommerce.entity.DetalleVenta;
import com.mainsoft.app.ecommerce.entity.Venta;

import io.reactivex.Observable;

public interface IVentaService {

	public ResponseEntity<List<Venta>> FindAll();

	public Venta findById(Long id);

	public ResponseEntity<Venta> create(Venta venta);

	Observable<DetalleVenta> getDtlleVentaObs(Long id);

}
