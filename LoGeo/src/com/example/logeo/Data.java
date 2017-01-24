package com.example.logeo;

public class Data {

	private String nombre;
	private String mail;
	private String password;
	
	public Data (String pNombre, String pMail, String pContrasena) {
		this.nombre=pNombre;
		this.mail=pMail;
		this.password=pContrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	/*
	@Override
	public String toString() {
		return this.nombre + ", " + this.mail + ", " + this.password;
	}
	*/	
}