package logica;

public class Nodo {
	public Object dato;
	public Nodo siguiente;
	
	public Nodo(Object pDato)
	{
		this.dato = pDato;
		this.siguiente = null;
	}
}
