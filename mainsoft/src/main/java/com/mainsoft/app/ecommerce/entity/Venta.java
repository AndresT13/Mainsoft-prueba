package com.mainsoft.app.ecommerce.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ventas")
public class Venta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVenta;

	@ManyToOne()
	@JoinColumn(referencedColumnName = "idCliente")
	private Cliente idCliente;

	@OneToMany()
	@JoinColumn(referencedColumnName = "idVenta")
	private List<DetalleVenta> detalles;

	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createAt;

	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}

	public Venta() {
		super();

	}

	public Venta(Long idVenta, Cliente idCliente, List<DetalleVenta> detalles, Date createAt) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

}
