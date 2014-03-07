package es.lps.p6.Modelo;

import java.io.Serializable;

/**
 * 
 * Interface para controlar la salida por teclado.
 *
 */
public interface Salida extends  Serializable {

	public void imprimir(String s);
	public void imprimirS(String s);
	public void borrar();
	public void cerrar();
	
}
