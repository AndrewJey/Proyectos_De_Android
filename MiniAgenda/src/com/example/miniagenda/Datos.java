package com.example.miniagenda;

public class Datos {

	private String titulo;
	private String hora;
	private String lugar;
	private String descripcion;

	public Datos(String pTitulo, String pHora, String pLugar,String pDescripcion) {
		this.titulo = pTitulo;
		this.hora = pHora;
		this.lugar = pLugar;
		this.descripcion = pDescripcion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return this.titulo + ", " + this.hora + ", " + this.lugar + ", " + this.descripcion;
	}
}
