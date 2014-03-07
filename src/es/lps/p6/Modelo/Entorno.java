package es.lps.p6.Modelo;



/**
 *  Clase que controla las cartas de tipo entorno
 *  En esta clase hemos creado copias superficiales y profundas pra la copia de cartas.
 *
 */

public class Entorno{

	private Cloro cloro;

	public Entorno(){
		
		cloro = new Cloro("0","0","0","0","0");
	}
	
	public Cloro getCloro() {
		return cloro;
	}
	
	public void setCloro(Cloro cloro) {
		this.cloro = cloro;
	}



}
