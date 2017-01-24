package logica;

public class Lista {

    private Nodo primero;
    private Nodo ultimo;
    private int tamanno;
    private String error;

    public Lista() {
        this.primero = null;
        this.ultimo = null;
        this.tamanno = 0;
    }

    public boolean vacio() {
        return (this.primero == null);
    }

    public boolean agregar(Object pDato) {
        boolean retorno = true;
        this.error = "";
        try {
            if (this.vacio()) {
                Nodo nuevo = new Nodo(pDato);
                this.primero = nuevo;
                this.ultimo = nuevo;
                nuevo.siguiente = nuevo;
            } else {
                Nodo nuevo = new Nodo(pDato);
                nuevo.siguiente = this.primero;
                this.primero = nuevo;
            }
            this.tamanno++;
        } catch (Exception e) {
            this.error = "Error agregando a la lista, detalle:" + e.getMessage();
            retorno = false;
        }
        return retorno;
    }

    public boolean borrar() {
        boolean retorno = true;
        this.error = "";
        if (this.vacio()) {
            this.error = "La lista se encuentra vacia";
            retorno = false;
            return retorno;
        }
        try {
            if (this.primero == this.ultimo) {
                this.primero = null;
                this.ultimo = null;
            } else {
                Nodo actual = this.primero;
                while (actual.siguiente != ultimo) {
                    actual = actual.siguiente;
                }
                actual.siguiente = null;
                this.ultimo = actual;
            }
            this.tamanno--;
        } catch (Exception e) {
            this.error = "Error borrando de la lista, detalle:" + e.getMessage();
            retorno = false;
        }
        return retorno;
    }

    public int getTamanno() {
        return this.tamanno;
    }

    public String getError() {
        return this.error;
    }
    @Override
    public String toString() {
        String retorno = "";
        if (!this.vacio()) {
            Nodo temp = this.primero;
            for (int i = 0; i < this.tamanno; i++) {
                retorno = retorno + String.valueOf(temp.dato) + "\n";
                temp = temp.siguiente;
            }
        }
        return retorno;
    }
    
    public boolean borrarPrimero() {
        boolean retorno = true;
        this.error = "";
        if (this.vacio()) {
            this.error = "La lista se encuentra vacia";
            retorno = false;
            return retorno;
        }
        try {
            if (this.primero == this.ultimo) {
                this.primero = null;
                this.ultimo = null;
            } else {
                Nodo actual = this.primero;
                this.primero=actual.siguiente;
                actual=null;
            }
            this.tamanno--;
        } catch (Exception e) {
            this.error = "Error borrando de la lista, detalle:" + e.getMessage();
            retorno = false;
        }
        return retorno;
    }
    
   public boolean agregarFinal(Object pDato){
       boolean retorno = true;
        this.error = "";
        try {
            if (this.vacio()) {
                Nodo nuevo = new Nodo(pDato);
                this.primero = nuevo;
                this.ultimo = nuevo;
                nuevo.siguiente = nuevo;
            } else {
                Nodo nuevo = new Nodo(pDato);
                this.ultimo.siguiente=nuevo;
                this.ultimo=this.ultimo.siguiente;
                this.ultimo.siguiente=null;
            }
            this.tamanno++;
        } catch (Exception e) {
            this.error = "Error agregando a la lista, detalle:" + e.getMessage();
            retorno = false;
        }
        return retorno;
   }
   public Object bucarIndice(int indice){
       Object retorno=null;
       
        if (indice<this.tamanno) {
            int i;
            Nodo temp=this.primero;
            for (i = 0; i <indice ; i++) { 
                temp=temp.siguiente;
            }
           retorno=temp.dato; 
       }      
       return retorno;
   }
   
   public boolean borrarXindice(int indice){
       boolean retorno=true;
       if (!this.vacio()) {
           if ((indice>=0)&&indice<=this.tamanno-1) {
               if (indice==0) {
                   retorno=this.borrarPrimero();
               }
               else if (indice==this.tamanno-1) {
                   retorno=this.borrar();
               }
               else{
                   Nodo ant=this.primero;
                   Nodo aux=ant.siguiente;
                   for (int i = 0; i < 10; i++) {
                       ant=ant.siguiente;
                       aux=aux.siguiente;
                   }
                   ant.siguiente=aux.siguiente;
                   this.tamanno--;
                   retorno=true;
               }
           }
       } 
       return retorno;
   }
}
