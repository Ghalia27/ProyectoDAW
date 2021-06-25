package org.gaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="genero_juego")
public class Generos_juegos {
	
	@Id
	@Column(name="idgenerojuego")
	private int idgenerojuego;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;

	

	public int getIdgenerojuego() {
		return idgenerojuego;
	}

	public void setIdgenerojuego(int idgenerojuego) {
		this.idgenerojuego = idgenerojuego;
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
