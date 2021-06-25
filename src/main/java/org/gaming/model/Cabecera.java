package org.gaming.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vtacabecera")
public class Cabecera {
	
	@Id
	@Column(name="idvta")
	private int idboleta;
	
	@Column(name="idusuario")
	private String idusuario;
	
	@Column(name="fecha_venta")
	private String fechaboleta;
	
	@Column(name="total_venta")
	private double totalventa;

	public int getIdboleta() {
		return idboleta;
	}

	public void setIdboleta(int idboleta) {
		this.idboleta = idboleta;
	}

	public String getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getFechaboleta() {
		return fechaboleta;
	}

	public void setFechaboleta(String fechaboleta) {
		this.fechaboleta = fechaboleta;
	}

	public double getTotalventa() {
		return totalventa;
	}

	public void setTotalventa(double totalventa) {
		this.totalventa = totalventa;
	}

	@Override
	public String toString() {
		return "Cabecera [idboleta=" + idboleta + ", idusuario=" + idusuario + ", fechaboleta=" + fechaboleta
				+ ", totalventa=" + totalventa + "]";
	}
	
	
}
