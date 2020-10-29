package com.mainsoft.app.ecommerce.dao;

import com.mainsoft.app.ecommerce.entity.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDetalleVentaDao extends JpaRepository<DetalleVenta, Long> {

	List<DetalleVenta> findByIdDetalleVentaOrderByIdVenta(Long id);

}
