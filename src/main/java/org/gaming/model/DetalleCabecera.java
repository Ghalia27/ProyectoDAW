package org.gaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vtadetalle")
public class DetalleCabecera {
	@Id
	@Column(name="idvta")
	private int idboleta;
	
	@Column(name="idjuego")
	private String idjuego;
	
	@Column(name="cantidad")
	private int cantidad;
	
	@Column(name="precio_unitario")
	private double preciouni;
	
	@Column(name="monto")
	private double monto;

	
	public DetalleCabecera(int idboleta, String idjuego, int cantidad, double preciouni, double monto) {
		this.idboleta = idboleta;
		this.idjuego = idjuego;
		this.cantidad = cantidad;
		this.preciouni = preciouni;
		this.monto = monto;
		
	}
	
	public DetalleCabecera() {
		
	}
	
	public int getIdboleta() {
		return idboleta;
	}

	public void setIdboleta(int idboleta) {
		this.idboleta = idboleta;
	}

	public String getIdjuego() {
		return idjuego;
	}

	public void setIdjuego(String idjuego) {
		this.idjuego = idjuego;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPreciouni() {
		return preciouni;
	}

	public void setPreciouni(double preciouni) {
		this.preciouni = preciouni;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "DetalleCabecera [idboleta=" + idboleta + ", idjuego=" + idjuego + ", cantidad=" + cantidad
				+ ", preciouni=" + preciouni + ", monto=" + monto + "]";
	}
	
}
