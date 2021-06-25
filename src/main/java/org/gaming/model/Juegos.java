package org.gaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="juegos")
public class Juegos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idjuego")
	private int idjuego;
	
	@Column(name="idgenerojuego")
	private int idgenerojuego;
	
	@Column(name="idplataforma")
	private int idplataforma;
	
	@Column(name="idclasificacion")
	private int idclasificacion;
	
	@Column(name="idedicion")
	private int idedicion;
	
	@Column(name="titulo")
	private String titulo;
	
	/*@Column(name="imagen")
private String imagen;*/
	
	@Column(name="descripcion")
private String descripcion;
	
	@Column(name="fecha_publicacion")
private String anio;
	
	@Column(name="stock")
private String stock;
	
	@Column(name="precio")
private double precio;
	
	@Column(name="idestado")
private int estado;

	public int getIdjuego() {
		return idjuego;
	}

	public void setIdjuego(int idjuego) {
		this.idjuego = idjuego;
	}

	

	public int getIdgenerojuego() {
		return idgenerojuego;
	}

	public void setIdgenerojuego(int idgenerojuego) {
		this.idgenerojuego = idgenerojuego;
	}

	public int getIdplataforma() {
		return idplataforma;
	}

	public void setIdplataforma(int idplataforma) {
		this.idplataforma = idplataforma;
	}

	public int getIdclasificacion() {
		return idclasificacion;
	}

	public void setIdclasificacion(int idclasificacion) {
		this.idclasificacion = idclasificacion;
	}

	public int getIdedicion() {
		return idedicion;
	}

	public void setIdedicion(int idedicion) {
		this.idedicion = idedicion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/*public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}*/

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	
}
