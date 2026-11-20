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
            Nodo nuevo = new Nodo(pDato);
            if (this.vacio()) {
                this.primero = nuevo;
                this.ultimo = nuevo;
                nuevo.siguiente = null;
            } else {
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
    
    public boolean agregarFinal(Object pDato) {
        boolean retorno = true;
        this.error = "";
        try {
            Nodo nuevo = new Nodo(pDato);
            if (this.vacio()) {
                this.primero = nuevo;
                this.ultimo = nuevo;
                nuevo.siguiente = null;
            } else {
                this.ultimo.siguiente = nuevo;
                this.ultimo = nuevo;
                this.ultimo.siguiente = null;
            }
            this.tamanno++;
        } catch (Exception e) {
            this.error = "Error agregando a la lista, detalle:" + e.getMessage();
            retorno = false;
        }
        return retorno;
    }

    public Object buscarIndice(int indice) {
        return bucarIndice(indice);
    }

    public Object bucarIndice(int indice) {
        if (indice < 0 || indice >= this.tamanno || this.vacio()) {
            return null;
        }
        Nodo temp = this.primero;
        for (int i = 0; i < indice; i++) {
            if (temp == null) return null;
            temp = temp.siguiente;
        }
        return temp != null ? temp.dato : null;
    }

    public boolean borrarXindice(int indice) {
        this.error = "";
        if (this.vacio() || indice < 0 || indice >= this.tamanno) {
            this.error = "Indice fuera de rango";
            return false;
        }
        if (indice == 0) {
            return this.borrarPrimero();
        }
        if (indice == this.tamanno - 1) {
            return this.borrar();
        }
        Nodo ant = this.primero;
        for (int i = 0; i < indice - 1; i++) {
            ant = ant.siguiente;
        }
        Nodo aux = ant.siguiente;
        ant.siguiente = aux.siguiente;
        this.tamanno--;
        return true;
    }
}
