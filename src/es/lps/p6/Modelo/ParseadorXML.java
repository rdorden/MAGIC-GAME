package es.lps.p6.Modelo;

import java.io.Serializable;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class ParseadorXML  extends DefaultHandler implements  Serializable{
	private static List<Carta> aux;
	private static String codigo;
	private static String nombre;
	private static String max;
	private static String clase;
	private static String tipo;
	private static String imagen;
	private static String ataque;
	private static String defensa;
	private static String aire;
	private static String mar;
	private static String tierra;
	private static String espiritu;
	private static String generico;
	private static String descripcion;
	private static String codigo2;
	private static String var1;
	private static String var2;
	private static String var3;
	

	public ParseadorXML(List<Carta> l){
		aux=l;
	}
	
	public void startDocument() throws SAXException {
		   System.out.println("Comienzo del documento");
		}

		public void endDocument() throws SAXException {
		  System.out.println("Final del documento");
		}

		public void startElement(String namespace, String sName,String qName, Attributes atrs) throws SAXException {
			
			if(qName == "carta_entorno"){
				  if (atrs != null) {
					    for(int i=0; i < atrs.getLength(); i++) {
					    	if(atrs.getQName(i)=="codigo"){
					    		codigo=atrs.getValue(i);
					    	}
					    	else if (atrs.getQName(i)=="nombre"){
					    		nombre=atrs.getValue(i);
					    	}
					    	else if (atrs.getQName(i)=="ejemplares"){
					    		max=atrs.getValue(i);
					    	}
					    	else if (atrs.getQName(i)=="clase"){
					    		clase=atrs.getValue(i);
					    	}
					    	else if (atrs.getQName(i)=="tipo"){
					    		tipo=atrs.getValue(i);
					    	}
					    	else if (atrs.getQName(i)=="imagen"){
					    		imagen=atrs.getValue(i);
					    	}
					    	
					    }
				
				  }
			}
			else if(qName == "carta_ser"){
				  if (atrs != null) {
					    for(int i=0; i < atrs.getLength(); i++) {
					    	if(atrs.getQName(i)=="codigo"){
					    		codigo=atrs.getValue(i);
					    	}
					    	else if (atrs.getQName(i)=="nombre"){
					    		nombre=atrs.getValue(i);
					    	}
					    	else if (atrs.getQName(i)=="ejemplares"){
					    		max=atrs.getValue(i);
					    	}
					    	else if (atrs.getQName(i)=="clase"){
					    		clase=atrs.getValue(i);
					    	}
					    	else if (atrs.getQName(i)=="tipo"){
					    		tipo=atrs.getValue(i);
					    	}
					    	else if (atrs.getQName(i)=="imagen"){
					    		imagen=atrs.getValue(i);
					    	}
					    	else if (atrs.getQName(i)=="ataque"){
					    		ataque=atrs.getValue(i);
					    	}
					    	else if (atrs.getQName(i)=="defensa"){
					    		defensa=atrs.getValue(i);
					    	}
					    	
					    }
				
				  }
			}
			if(qName == "carta_intervencion"){
				  if (atrs != null) {
					    for(int i=0; i < atrs.getLength(); i++) {
					    	if(atrs.getQName(i)=="codigo"){
					    		codigo=atrs.getValue(i);
					    	}
					    	else if (atrs.getQName(i)=="nombre"){
					    		nombre=atrs.getValue(i);
					    	}
					    	else if (atrs.getQName(i)=="ejemplares"){
					    		max=atrs.getValue(i);
					    	}
					    	else if (atrs.getQName(i)=="clase"){
					    		clase=atrs.getValue(i);
					    	}
					    	else if (atrs.getQName(i)=="tipo"){
					    		tipo=atrs.getValue(i);
					    	}
					    	else if (atrs.getQName(i)=="imagen"){
					    		imagen=atrs.getValue(i);
					    	}
					    	
					    }
				
				  }
			}
			else  if (qName == "coste"){
					  aire="0";
					  mar="0";
					  tierra="0";
					  espiritu="0";
					  generico="0";
					  if (atrs != null) {
						    for(int i=0; i < atrs.getLength(); i++) {
						    	if(atrs.getQName(i)=="aire"){
						    		aire=atrs.getValue(i);
						    	}
						    	else if (atrs.getQName(i)=="mar"){
						    		mar=atrs.getValue(i);
						    	}
						    	else if (atrs.getQName(i)=="tierra"){
						    		tierra=atrs.getValue(i);
						    	}
						    	else if (atrs.getQName(i)=="espiritu"){
						    		espiritu=atrs.getValue(i);
						    	}
						    	else if (atrs.getQName(i)=="generico"){
						    		generico=atrs.getValue(i);
						    	}
						    	
						    }
					  	}
				  }
			else  if (qName == "comportamiento"){
					  if (atrs != null) {
						    for(int i=0; i < atrs.getLength(); i++) {
						    	if(atrs.getQName(i)=="descripcion"){
						    		descripcion=atrs.getValue(i);
						    	}
						    	else if (atrs.getQName(i)=="codigo"){
						    		codigo2=atrs.getValue(i);
						    	}
						    	else if (atrs.getQName(i)=="variable1"){
						    		var1=atrs.getValue(i);
						    	}
						    	else if (atrs.getQName(i)=="variable2"){
						    		var2=atrs.getValue(i);
						    	}
						    	else if (atrs.getQName(i)=="variable3"){
						    		var3=atrs.getValue(i);
						    	}
						    }
					  }
				  }
				 
			
		/* System.out.println("Elemento: " + qName);
		  if (atrs != null) {
			    for(int i=0; i < atrs.getLength(); i++) {
			        System.out.println("Atributo: " + atrs.getQName(i)		    + " = " + atrs.getValue(i));}
			}*/
		}
		private boolean ParserBoolean(String s){
			if (s.equalsIgnoreCase("false")) return false;
			else return true;
		}
		private int numElementos(int i){
			if (i != -1) return i;
			else return Integer.MAX_VALUE;
		}
		
		private void limpiar(){
			codigo=nombre=max=clase=tipo=imagen=aire=tierra=mar=espiritu=generico=ataque=defensa=codigo2=var1=var2=var3="";
		}
		
		public void endElement(String namespace, String sName,String qName) throws SAXException {
			
			Carta c;
			
			if (qName=="carta_entorno"){
				
				
				c = new Carta(codigo,nombre,new Cloro(tierra,mar,aire,espiritu,generico),numElementos(Integer.parseInt(max)),Clase.ParserString(clase),Tipo.parserString(tipo),descripcion,imagen);
			
				Entorno e = new Entorno();
				e.setCloro(new Cloro("0", "0", "0", "0", "0"));
				c.setEntorno(e);
				aux.add(c);
				limpiar();
			}
			else if(qName=="carta_ser"){
				
				c = new Carta(codigo,nombre,new Cloro(tierra,mar,aire,espiritu,generico),numElementos(Integer.parseInt(max)),Clase.ParserString(clase),Tipo.parserString(tipo),descripcion,imagen);
				c.setSer(new Ser(Integer.parseInt(ataque),Integer.parseInt(defensa)));
				aux.add(c);
				limpiar();
			}
				
			
			else if(qName=="carta_intervencion"){
				
				c = new Carta(codigo,nombre,new Cloro(tierra,mar,aire,espiritu,generico),numElementos(Integer.parseInt(max)),Clase.ParserString(clase),Tipo.parserString(tipo),descripcion,imagen);
				c.setIntervencion(new Intervencion());
				aux.add(c);
				limpiar();
			}
			
			
		}
		public void characters(char buf[], int offset, int len) {
			String aux = new String(buf, offset, len);
			System.out.println("Texto: " + aux);
		}

}
