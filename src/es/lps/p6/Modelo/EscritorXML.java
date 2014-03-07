package es.lps.p6.Modelo;

import java.io.FileOutputStream;
import java.util.List;

import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class EscritorXML {
	
	private String url;
	
	public EscritorXML(String url){
		
		this.url = url;
		
	}
	
	public void escribirXML(List<Carta> l){
		
		Element raiz = new Element("juego");
		
		raiz.setAttribute("titulo","Brujos y Trifulcas");
		raiz.setAttribute("autor","David Ateza Rubios, Jose Agustin Diaz Del Aguila Boquete, Rodrigo De La Orden");
		raiz.setAttribute("version","6.0");
		
		Element lista = new Element("lista_cartas");
		raiz.addContent(lista);
		
		
		
		for(Carta c:l){
			
			Element carta = aniadirAtributosComunes(c);
			Element comportamiento = aniadirAtributosComportamiento(c);
			
			if(c.getTipo().equals(Tipo.ENTORNO)){
	
				if(c.getComportamiento().getId()==2)
				
					comportamiento.setAttribute("variable3",c.getComportamiento().getVariable3());
	
			}
			
			if(c.getTipo().equals(Tipo.INTERVENCION)){
				
				comportamiento.setAttribute("variable1",c.getComportamiento().getVariable1());
				
				if(c.getComportamiento().getId()==2||c.getComportamiento().getId()==3)
					comportamiento.setAttribute("variable2",c.getComportamiento().getVariable2());
				
			}
			
			if(c.getTipo().equals(Tipo.SER)){
				
				carta.setAttribute("ataque",String.valueOf(c.getSer().getAtaque()));
				carta.setAttribute("defensa",String.valueOf(c.getSer().getDefensa()));
				
				if(c.getComportamiento().getId()==2)
					comportamiento.setAttribute("variable3",c.getComportamiento().getVariable3());
				
				else if(c.getComportamiento().getId()==3){
					
					if(c.getComportamiento().getVariable1()!=null)
						comportamiento.setAttribute("variable1",c.getComportamiento().getVariable1());
					else
						comportamiento.setAttribute("variable1","0");
					
					if(c.getComportamiento().getVariable2()!=null)
						comportamiento.setAttribute("variable2",c.getComportamiento().getVariable2());
					else
						comportamiento.setAttribute("variable2","0");
					
					comportamiento.setAttribute("variable3",c.getComportamiento().getVariable3());
				}
				
				else if(c.getComportamiento().getId()==4)
					comportamiento.setAttribute("variable1",c.getComportamiento().getVariable1());
				
	
			}
			
			carta.addContent(comportamiento);
			lista.addContent(carta);
	}
		
		Document doc = new Document(raiz);//Creamos el documento
		doc.setDocType(new DocType("juego","DTD2.dtd"));
		 
        try{
            XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
            FileOutputStream file = new FileOutputStream(url);
            out.output(doc,file);
            file.flush();
            file.close();
            out.output(doc,System.out);
        }catch(Exception e){e.printStackTrace();}
	}
	
	private Element aniadirAtributosComunes(Carta c){
		
		Element carta = null;
		
		if(c.getTipo().equals(Tipo.ENTORNO))
			carta = new Element("carta_entorno");
		
		if(c.getTipo().equals(Tipo.SER))
			carta = new Element("carta_ser");
		
		if(c.getTipo().equals(Tipo.INTERVENCION))
			carta = new Element("carta_intervencion");
					
		carta.setAttribute("codigo",c.getCodigo());
		carta.setAttribute("nombre",c.getNombre());
		carta.setAttribute("ejemplares", String.valueOf(c.getMaximo()));
		carta.setAttribute("tipo",String.valueOf(c.getTipo()));
		carta.setAttribute("clase",String.valueOf(c.getClase()));
		carta.setAttribute("imagen",c.getImagen());
		
		Element coste = new Element("coste");
		
		if(!String.valueOf(c.getCoste().getTierra()).equalsIgnoreCase("0"))
			coste.setAttribute("tierra",c.getCoste().getTierra());
		
		if(!c.getCoste().getMar().equalsIgnoreCase("0"))
			coste.setAttribute("mar",c.getCoste().getMar());
		
		if(!String.valueOf(c.getCoste().getAire()).equalsIgnoreCase("0"))
			coste.setAttribute("aire",c.getCoste().getAire());
		
		if(!String.valueOf(c.getCoste().getEspiritu()).equalsIgnoreCase("0"))
			coste.setAttribute("espiritu",c.getCoste().getEspiritu());
		
		if(!String.valueOf(c.getCoste().getGenerico()).equalsIgnoreCase("0"))
			coste.setAttribute("generico",c.getCoste().getGenerico());
		
		carta.addContent(coste);
		
		return carta;
		
	}
	
	public Element aniadirAtributosComportamiento(Carta c){
		
		Element comportamiento = new Element("comportamiento");
		comportamiento.setAttribute("descripcion", c.getComportamiento().getDescripcion());
		comportamiento.setAttribute("codigo", c.getComportamiento().getCodigo());
		
		return comportamiento;
	}

}
