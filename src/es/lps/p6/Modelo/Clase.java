package es.lps.p6.Modelo;


public enum Clase{
	
	TIERRA, AIRE, MAR, ESPIRITU;



	/**
	 * 
	 */
public static Clase ParserString(String s){
	if (s.equalsIgnoreCase("tierra")) return Clase.TIERRA;
	else if (s.equalsIgnoreCase("aire")) return Clase.AIRE;
	else if (s.equalsIgnoreCase("mar")) return Clase.MAR;
	else if (s.equalsIgnoreCase("espiritu")) return Clase.ESPIRITU;
	else return null;
	
	
}



}
