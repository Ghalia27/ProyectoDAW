package Clases;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Vtacabecera")
public class Vtacabecera {
	
	@Id
	@Column(name="idvta")
	private int idvta;
	
	@Column(name="idusuario")
	private int idusuario;
	
	@Column(name="fecha_venta")
	private Date fecha_venta;
	
	@Column(name="total_venta")
	private double total_venta;

	public int getIdvta() {
		return idvta;
	}

	public void setIdvta(int idvta) {
		this.idvta = idvta;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public Date getFecha_venta() {
		return fecha_venta;
	}

	public void setFecha_venta(Date fecha_venta) {
		this.fecha_venta = fecha_venta;
	}

	public double getTotal_venta() {
		return total_venta;
	}

	public void setTotal_venta(double total_venta) {
		this.total_venta = total_venta;
	}

	
	
}
