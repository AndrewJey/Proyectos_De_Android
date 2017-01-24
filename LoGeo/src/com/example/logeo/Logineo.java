package com.example.logeo;

public class Logineo {

	private String mail;
	private String password;
	
	public Logineo (String pMail, String pContrasena) {
		this.mail=pMail;
		this.password=pContrasena;
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
	
}