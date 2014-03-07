package es.lps.p6.Modelo;



public enum Tipo{
	
	ENTORNO, SER, INTERVENCION;
	


	public static Tipo parserString(String s){
		
		if(s.equalsIgnoreCase("Ser"))
			return Tipo.SER;
		
		else if(s.equalsIgnoreCase("Entorno"))
			return Tipo.ENTORNO;
		
		else if(s.equalsIgnoreCase("Intervencion"))
			return Tipo.INTERVENCION;
		
		return null;
	}
}
