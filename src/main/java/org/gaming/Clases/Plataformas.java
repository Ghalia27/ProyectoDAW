package Clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Plataformas")
public class Plataformas {

	@Id
	@Column(name="idplataforma")
	private int idplataforma;
	
	
	@Column(name="nombre")
	private String nombre;
	
	
	@Column(name="descripcion")
	private String descripcion;


	public int getIdplataforma() {
		return idplataforma;
	}


	public void setIdplataforma(int idplataforma) {
		this.idplataforma = idplataforma;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
