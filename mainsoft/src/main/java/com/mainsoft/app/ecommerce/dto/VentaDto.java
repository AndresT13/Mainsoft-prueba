package com.mainsoft.app.ecommerce.dto;

import java.util.Date;
import java.util.List;

import com.mainsoft.app.ecommerce.entity.Cliente;
import com.mainsoft.app.ecommerce.entity.DetalleVenta;

public class VentaDto {

	private Long idVenta;

	private Cliente idCliente;

	private List<DetalleVenta> detalles;

	private Date createAt;

	public VentaDto() {
		super();

	}

	public VentaDto(Long idVenta, Cliente idCliente, List<DetalleVenta> detalles, Date createAt) {
		super();
		this.idVenta = idVenta;
		this.idCliente = idCliente;
		this.detalles = detalles;
		this.createAt = createAt;
	}

	public Long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	public List<DetalleVenta> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleVenta> detalles) {
		this.detalles = detalles;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

}
