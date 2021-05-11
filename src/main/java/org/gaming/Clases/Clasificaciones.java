package Clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Clasificaciones")
public class Clasificaciones {
	
	
		@Id
		@Column(name="idclasificacion")
		private int idclasificacion;
		
		@Column(name="Nombre")
		private String Nombre;
		
		@Column(name="descripcion")
		private String descripcion;

		public int getIdclasificacion() {
			return idclasificacion;
		}

		public void setIdclasificacion(int idclasificacion) {
			this.idclasificacion = idclasificacion;
		}

		public String getNombre() {
			return Nombre;
		}

		public void setNombre(String nombre) {
			Nombre = nombre;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
			
		
}
