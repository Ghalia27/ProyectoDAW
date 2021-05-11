package Clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Juegos")
public class Juegos {
	
	@Id
	@Column(name="idjuego")
	private int idjuego;
	
	@Column(name="idgenero")
	private int idgenero;
	
	@Column(name="idplataforma")
	private int idplataforma;
	
	@Column(name="idclasificacion")
	private int idclasificacion;
	
	@Column(name="idedicion")
	private int idedicion;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="imagen")
private String imagen;
	
	@Column(name="descripcion")
private String descripcion;
	
	@Column(name="año")
private String año;
	
	@Column(name="stock")
private String stock;
	
	@Column(name="precio")
private double precio;
	
	@Column(name="estado")
private String estado;

	public int getIdjuego() {
		return idjuego;
	}

	public void setIdjuego(int idjuego) {
		this.idjuego = idjuego;
	}

	public int getIdgenero() {
		return idgenero;
	}

	public void setIdgenero(int idgenero) {
		this.idgenero = idgenero;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}
