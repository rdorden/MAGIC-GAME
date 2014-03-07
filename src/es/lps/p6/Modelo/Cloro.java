package es.lps.p6.Modelo;




/**
 *  Clase que almacena los tipos de cloro.
 * 
 */

public class Cloro{
	
	private String tierra;
	private String mar;
	private String aire;
	private String espiritu;
	private String generico;
	
	
	public Cloro(String tierra, String mar, String aire, String espiritu,
			String generico) {
		
		this.generico = generico;
		this.tierra = tierra;
		this.mar = mar;
		this.aire = aire;
		this.espiritu = espiritu;
	}

	public String getTierra() {
		return tierra;
	}
	
	public void setTierra(String tierra) {
		this.tierra = tierra;
	}
	
	public String getMar() {
		return mar;
	}
	
	public void setMar(String mar) {
		this.mar = mar;
	}
	
	public String getAire() {
		return aire;
	}
	
	public void setAire(String aire) {
		this.aire = aire;
	}
	
	public String getEspiritu() {
		return espiritu;
	}
	
	public void setEspiritu(String espiritu) {
		this.espiritu = espiritu;
	}
	
	public String getGenerico() {
		return generico;
	}
	
	public void setGenerico(String generico) {
		this.generico = generico;
	}
	
	
	

	
	
}


