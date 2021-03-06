package org.gaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idusuario")
	private int idusuario;
	
	@Column(name="nombres")
	private String nombres;
	
	@Column(name="apellidos")
	private String apellidos;
	
	@Column(name="edad")
	private int edad;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="email")
	private String email;
	
	@Column(name="contrasenia")
	private String contrasenia;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="idperfil")
	private int idperfil;
	
	@Column(name="idgenero")
	private int idgenero;
	
	@Column(name="dni")
	private int dni;
	
	@Column(name="nro_cuenta")
	private int nrocuenta;

	public Usuarios() {
	}

	public Usuarios(int idusuario, String nombres, String apellidos, int edad, String direccion, String email,
			String contrasenia, String estado, int idperfil, int idgenero, int dni, int nrocuenta) {
		this.idusuario = idusuario;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.edad = edad;
		this.direccion = direccion;
		this.email = email;
		this.contrasenia = contrasenia;
		this.estado = estado;
		this.idperfil = idperfil;
		this.idgenero = idgenero;
		this.dni = dni;
		this.nrocuenta = nrocuenta;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIdperfil() {
		return idperfil;
	}

	public void setIdperfil(int idperfil) {
		this.idperfil = idperfil;
	}

	public int getIdgenero() {
		return idgenero;
	}

	public void setIdgenero(int idgenero) {
		this.idgenero = idgenero;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public int getNrocuenta() {
		return nrocuenta;
	}

	public void setNrocuenta(int nrocuenta) {
		this.nrocuenta = nrocuenta;
	}
	
	
}
