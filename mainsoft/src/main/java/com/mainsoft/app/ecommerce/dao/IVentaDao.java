package com.mainsoft.app.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mainsoft.app.ecommerce.entity.Venta;

@Repository
public interface IVentaDao extends JpaRepository<Venta, Long> {

}
