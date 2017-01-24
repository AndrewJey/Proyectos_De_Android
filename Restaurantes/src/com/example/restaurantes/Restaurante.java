package com.example.restaurantes;

public class Restaurante {

	private String nombre;
	private String direccion;
	private String tipo;
	
	public Restaurante (String pNombre, String pDireccion, String pTipo) {
		this.nombre=pNombre;
		this.direccion=pDireccion;
		this.tipo=pTipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return this.nombre + ", " + this.direccion + ", " + this.tipo;
	}
}