package es.lps.p6.Modelo;

import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LectorXML extends DefaultHandler{
	
	private String contenido;
	private Comportamiento c;
	private List<Comportamiento> l;
	
	public LectorXML(List<Comportamiento> l){
		
		this.l = l;
	}
	
	@Override
	public void startElement(String namespace, String sName,String qName, Attributes atrs) throws SAXException {
		
		if(qName.equalsIgnoreCase("Comportamiento"))
			c = new Comportamiento(null);
		
	
	}
	
	public void startDocument() throws SAXException {
		   System.out.println("Comienzo del documento");
		}

		public void endDocument() throws SAXException {
		  System.out.println("Final del documento");
		}

	@Override
	public void endElement(String namespace, String sName,String qName) throws SAXException {
		
		if(qName.equalsIgnoreCase("Codigo"))
			c.setCodigo(contenido);
		
		else if(qName.equalsIgnoreCase("Id"))
			c.setId((Integer.parseInt(contenido)));
		
		else if(qName.equalsIgnoreCase("Descripcion"))
			c.setDescripcion(contenido);
		
		else if(qName.equalsIgnoreCase("Comportamiento"))
			l.add(c);
		
		
	}
	
	  @Override  
	   public void characters(char[] ch, int start, int length)  throws SAXException { 
		  
		  
		  contenido = new String(ch, start, length);
	  }

}
