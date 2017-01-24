/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applista;
import logica.*;
/**
 *
 * @author estudiante
 */
public class AppLista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lista objLista=new Lista();
       /* objLista.agregar(3);
        objLista.agregar("tristes");
        objLista.agregar("tigres");
        objLista.agregar("trigo");
        objLista.agregar("comieron");*/
        
        objLista.agregarFinal(3);
        objLista.agregarFinal("tristes");
        objLista.agregarFinal("tigres");
        objLista.agregarFinal("trigo");
        objLista.agregarFinal("comieron");
        
        
        System.out.println(objLista.toString());          
        System.out.println();
       // objLista.borrar();
        System.out.println(objLista.toString()); 
        System.out.println();
       // objLista.borrarPrimero();
        System.out.println(objLista.toString()); 
        
        System.out.println(objLista.bucarIndice(2));
        System.out.println();
        objLista.borrarXindice(1);
        System.out.println(objLista.toString());      
        
    }
}
