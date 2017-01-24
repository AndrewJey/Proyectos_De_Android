package com.example.sqlexample;

public class Animal {
	
	private int id;
	private String nombre;
	private String color;
	
	public Animal(){}
	
	public Animal(int id, String nombre, String color) {
		this.id = id;
		this.nombre = nombre;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	

}
