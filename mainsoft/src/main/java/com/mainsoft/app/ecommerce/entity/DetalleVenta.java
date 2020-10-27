package com.mainsoft.app.ecommerce.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_ventas")
public class DetalleVenta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDetalleVenta;

	@Column(name = "id_venta")
	private Long idVenta;

	@JoinColumn(referencedColumnName = "idProducto")
	@ManyToOne()
	private Producto idProducto;
	
	
	public DetalleVenta() {
		super();

	}

	public DetalleVenta(Long idDetalleVenta, Long idVenta, Producto idProducto) {
		super();
		this.idDetalleVenta = idDetalleVenta;
		this.idVenta = idVenta;
		this.idProducto = idProducto;
	}

	public Long getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(Long idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public Long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
	}

	public Producto getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Producto idProducto) {
		this.idProducto = idProducto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

}
