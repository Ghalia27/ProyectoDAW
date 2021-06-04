package org.gaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Generos")
public class Generos {
	
	@Id
	@Column(name="idgenero")
	private int idgenero;
	
	@Column(name="nombre")
	private String nombre;

	public int getIdgenero() {
		return idgenero;
	}

	public void setIdgenero(int idgenero) {
		this.idgenero = idgenero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Generos [idgenero=" + idgenero + ", nombre=" + nombre + "]";
	}
	

}
