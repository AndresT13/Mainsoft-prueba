package com.mainsoft.app.ecommerce.dao;

import com.mainsoft.app.ecommerce.entity.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDetalleVentaDao extends JpaRepository<DetalleVenta, Long> {

	// @Query(value = "SELECT v FROM detalle_ventas v WHERE
	// v.idVenta.idVenta=:idVenta")
	//List<DetalleVenta> findAllByIdVentaEquals(@Param("idVenta") Long idVenta);
	List<DetalleVenta> findByIdDetalleVentaOrderByIdVenta(Long id);

//  @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
//  List<Venta> getIdCategoria(Long id);

}
