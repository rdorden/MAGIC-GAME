package es.lps.p6.Modelo;


/**
  * 
  *  Clase que controla las cartas de tipo ser.
  *  Los comportamientos de estas cartas se modelan en la clase Habilidad.
  *  En esta clase tambien tenemos metodos de copia superficial y profunda.
  *  Todas las caracteristicas que puede tener un ser se modelan en esta clase, su habilidad, su ataque, su defensa
  *  tambien guardamos si hay algun ser que la defienda durante una trifulca.
  *
  */

public class Ser{
	
	private int ataque;
	private int defensa;
	private int vida;
	
	
	public Ser(int ataque2, int defensa2) {
		
		ataque = ataque2;
		defensa = defensa2;
		
	}

	public Ser(){
		
	}
	public int getAtaque() {
		return ataque;
	}
	
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	
	public int getDefensa() {
		return defensa;
	}
	
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	
	public int getVida() {
		return vida;
	}
	
	public void setVida(int vida) {
		this.vida = vida;
	}

	
		
}
