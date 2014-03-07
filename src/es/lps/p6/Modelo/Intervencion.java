package es.lps.p6.Modelo;


/**
 * 
 *  Clase que controla las cartas de tipo intervencion
 *  Los comportamientos de estas cartas se modelan en el paquete ComportamientosIntervencion.
 *  En esta clase hemos creado copias superficiales y profundas pra la copia de cartas.
 *  Guardamos todos los atributos necesarios para controlar la ejecucion de una intervencion.
 *  el jugador que lanza la intervencion,el jugador que recibe esta,las cartas a las que afecta
 *  y si esta es permanente o no.
 * 
 */


public class Intervencion{

	private boolean permanente;

	public boolean isPermanente() {
		return permanente;
	}

	public void setPermanente(boolean permanente) {
		this.permanente = permanente;
	}
	
	

}
