package Clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 

@Table(name="Perfiles")
	public class Perfiles {
	
	@Id
	@Column(name="idperfil")
	 private int idperfil;
	 
	@Column(name="nombre")
	 private String nombre;
	 
	 
	 
	public int getIdperfil() {
		return idperfil;
	}
	public void setIdperfil(int idperfil) {
		this.idperfil = idperfil;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Perfiles [idperfil=" + idperfil + ", nombre=" + nombre + "]";
	}
	 
	 

}
