package es.lps.p6.Modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import es.lps.p6.Controlador.AccionNoPermitidaException;
import es.lps.p6.Vista.UpdateListener2;


public class Modelo {
	
	private List<Carta> listaCartas = new ArrayList<Carta>();
	private List<Integer> numCartas;
	private static List<Comportamiento> comportamientosSeres = new ArrayList<Comportamiento>();
	private static List<Comportamiento> comportamientosEntornos = new ArrayList<Comportamiento>();
	private static List<Comportamiento> comportamientosIntervenciones = new ArrayList<Comportamiento>();
	public static final String[] clases = {"CLASE",String.valueOf(Clase.TIERRA),String.valueOf(Clase.MAR),String.valueOf(Clase.AIRE),String.valueOf(Clase.ESPIRITU)};
	public static final String[] tipos = {"TIPO",String.valueOf(Tipo.SER),String.valueOf(Tipo.ENTORNO),String.valueOf(Tipo.INTERVENCION)};
	
	private Carta cartaActual;
	private List<UpdateListener> listeners;
	private List<UpdateListener2> listeners2;
	private List<Carta> cartas;
	
	public static void leerComportamientos() {
		
		
		File XMLSeres = new File("Comportamientos_Ser.xml");
		File XMLEntornos = new File("Comportamientos_entornos.xml");
		File XMLIntervenciones = new File("Comportamientos_intervenciones.xml");
		
		SAXParserFactory factory = SAXParserFactory.newInstance(); 
		factory.setValidating(true);
		SAXParser parser;
		
		try {
			parser = factory.newSAXParser();
			// Nuestro oyente heredará de DefaultHandler
			DefaultHandler parseador = new LectorXML(comportamientosSeres);
			// Lanzamos el proceso de parseo, siendo   nuestro oyente uno de los argumentos
			parser.parse(XMLSeres, parseador);
			
			parseador = new LectorXML(comportamientosEntornos);
			parser.parse(XMLEntornos, parseador);
			
			parseador = new LectorXML(comportamientosIntervenciones);
			parser.parse(XMLIntervenciones, parseador);
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public  void leerCartas(String url){
		
		File XMLCartas = new File(url);
		
		SAXParserFactory factory = SAXParserFactory.newInstance(); 
		factory.setValidating(true);
		SAXParser parser;
		
		try {
			parser = factory.newSAXParser();
			
			// Nuestro oyente heredará de DefaultHandler
			DefaultHandler parseador = new ParseadorXML(listaCartas);
			// Lanzamos el proceso de parseo, siendo   nuestro oyente uno de los argumentos
			parser.parse(XMLCartas, parseador);
			
			numCartas = new ArrayList<Integer>();
			
			for(int i =0;i<listaCartas.size();i++){
				
				numCartas.add(0);
			}
			
		} catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		notificarNuevasCartas();
	}
	
	

	public Modelo(){
		
		numCartas = new ArrayList<Integer>();
		listaCartas = new ArrayList<Carta>();
		listeners = new LinkedList<UpdateListener>();
		listeners2 = new LinkedList<UpdateListener2>();
		cartaActual = new Carta();
		cartas = new ArrayList<Carta>();
	}
	
	
	
	public Carta getCartaActual() {
		return cartaActual;
	}

	public void setCartaActual(Carta cartaActual) {
		this.cartaActual = cartaActual;
	}

	public void aniadeOyente(UpdateListener l){
		
		listeners.add(l);
	}
	
	
	public void cambiaNombreCarta(String texto) {
		
		cartaActual.setNombre(texto);
		
	}




	public void cambiaCodigoCarta(String texto) {
		
		cartaActual.setCodigo(texto);
		notificarCambioCodigo(texto);
		
	}
	
	public void cambiaClaseCarta(String texto) {
		
		cartaActual.setClase(Clase.ParserString(texto));
		notificarCambioClase();
		
		
	}
	
	
	public void cambiaTipoCarta(String texto) {
		
		cartaActual.setTipo(Tipo.parserString(texto));
		notificarCambioTipo();
	}
	


	public void cambiaCoste(Cloro c) {
		
		cartaActual.setCoste(c);
		notificarCambioCoste();
		
	}
	
	public void cambiaImagenCarta(String imagen) {
		
		cartaActual.setImagen(imagen);
		notificarCambioImagen();
	}
	
	public void cambiaMaximoCarta(int maximo) {
		
		cartaActual.setMaximo(maximo);
		notificarCambioMaximo();
		
	}
	
	public void creaCartaSer() {
		
		cartaActual = new Carta();
		cartaActual.setSer(new Ser());
		cartaActual.setTipo(Tipo.SER);
		cartaActual.setComportamiento(new Comportamiento("habilidad"));
		notificarNuevoSer();
		notificarComportamientosSer();
		notificarCambioTipo();
		
	}


	public void creaCartaEntorno() {
		
		cartaActual = new Carta();
		cartaActual.setEntorno(new Entorno());
		cartaActual.setTipo(Tipo.ENTORNO);
		cartaActual.setComportamiento(new Comportamiento("ComportamientoEntorno"));
		notificarNuevoEntorno();
		notificarComportamientosEntorno();
		notificarCambioTipo();
		
	}
	


	public void creaCartaIntervencion() {
		
		cartaActual = new Carta();
		cartaActual.setIntervencion(new Intervencion());
		cartaActual.setTipo(Tipo.INTERVENCION);
		cartaActual.setComportamiento(new Comportamiento(null));
		cartaActual.getComportamiento().setVariable1("false");
		notificarNuevaIntervencion();
		notificarComportamientosIntervencion();
		notificarCambioTipo();
		
		
	}
	

	public void cambiaAtaqueSer(int valor) {
		
		cartaActual.getSer().setAtaque(valor);
		notificarCambioataque();
		
	}
	
	public void cambiaDefensa(int valor) {
		
		cartaActual.getSer().setDefensa(valor);
		notificarCambioDefensa();
		
	}
	
	public void cambiaCloroEntorno(Cloro c) {
		
		cartaActual.getEntorno().setCloro(c);
		notificarCambioCloro();
		
	}
	
	public void cambiaTipoIntervencion(boolean selected) {
	
		cartaActual.getIntervencion().setPermanente(selected);
	}
	
	public void guardaCarta() {
		
		cartas.add(cartaActual);
		notificarCartaGuardada();
	}
	
	public int getIdComportamiento(String codigo) {
		
		if(cartaActual.getTipo().equals(Tipo.SER)){
			
			for(Comportamiento c:comportamientosSeres){
				
				if(c.getCodigo().equalsIgnoreCase(codigo))
					return c.getId();
			}
				
		}
		
		if(cartaActual.getTipo().equals(Tipo.ENTORNO)){
			
			for(Comportamiento c:comportamientosEntornos){
				
				if(c.getCodigo().equalsIgnoreCase(codigo))
					return c.getId();
			}
				
		}

		if(cartaActual.getTipo().equals(Tipo.INTERVENCION)){
	
			for(Comportamiento c:comportamientosIntervenciones){
		
				if(c.getCodigo().equalsIgnoreCase(codigo))
					return c.getId();
			}
		
		}
		
		return -1;
			
	}
	
	public String getDescripcion(String codigo) {
		
		if(cartaActual.getTipo().equals(Tipo.SER)){
			
			for(Comportamiento c:comportamientosSeres){
				
				if(c.getCodigo().equalsIgnoreCase(codigo))
					return c.getDescripcion();
			}
				
		}
		
		if(cartaActual.getTipo().equals(Tipo.ENTORNO)){
			
			for(Comportamiento c:comportamientosEntornos){
				
				if(c.getCodigo().equalsIgnoreCase(codigo))
					return c.getDescripcion();
			}
				
		}

		if(cartaActual.getTipo().equals(Tipo.INTERVENCION)){
	
			for(Comportamiento c:comportamientosIntervenciones){
		
				if(c.getCodigo().equalsIgnoreCase(codigo))
					return c.getDescripcion();
			}
		
		}
		
		return null;
		
		
	}
	
	public boolean esNuevaCartaActual() {
		
		return !cartas.contains(cartaActual);
	}
	
	
	public void cambiaIdComportamiento(int id) {
		
		cartaActual.getComportamiento().setId(id);
		
	}
	
	public void cambiaVariable3Comportamiento(String s) {
		
		cartaActual.getComportamiento().setVariable3(s);
		
	}
	
	public void cambiaVariable2Comportamiento(String s) {
		
		cartaActual.getComportamiento().setVariable2(s);
		
	}
	
	public void cambiaVariable1Comportamiento(String s) {
		
		cartaActual.getComportamiento().setVariable1(s);
		
	}

	public void cambiaCodigoComportamiento(String codigo) {
		
		cartaActual.getComportamiento().setCodigo(codigo);
		notificarComportamientoModificado();
		
	}



	public void cambiaNombreComportamiento(String codigo) {
		
		cartaActual.getComportamiento().setNombre(codigo);
		
	}
	
	public void cambiaDescripcion(String descripcion) {
		
		cartaActual.getComportamiento().setDescripcion(descripcion);
		
	}
	
	public void borraComportamientoCarta() {
		
		if(cartaActual.getTipo().equals(Tipo.SER))
			cartaActual.setComportamiento(new Comportamiento("habilidad"));
		
		if(cartaActual.getTipo().equals(Tipo.ENTORNO))
			cartaActual.setComportamiento(new Comportamiento("ComportamientoEntorno"));
		
		if(cartaActual.getTipo().equals(Tipo.INTERVENCION)){
			
			cartaActual.setComportamiento(new Comportamiento("vacio"));
			cartaActual.getComportamiento().setVariable1("false");
		}
			
		
		notificarComportamientoVacio();
		
	}
	
	public void muestraDescripcion(String codigo) {
		
		notificarDescripcion(getDescripcion(codigo));
	}
	
	public List<Carta> getListaCartas() {
		
		return cartas;
	}
	
	public void aniadeOyente(UpdateListener2 oyenteModelo) {
		
		listeners2.add(oyenteModelo);
		
	}
	
	public void aumentaCarta(int pos)throws AccionNoPermitidaException {
		
		if(numCartas.get(pos)<listaCartas.get(pos).getMaximo()){
			
			numCartas.set(pos,numCartas.get(pos)+1);
			notificarCambioNumCarta(pos);
		}
		
		else throw new AccionNoPermitidaException("El numero maximo para esta carta es: "+listaCartas.get(pos).getMaximo());
		
	}
	
	public void restaCarta(int pos)throws AccionNoPermitidaException {
		
		if(numCartas.get(pos)>0){
			
			numCartas.set(pos,numCartas.get(pos)-1);
			notificarCambioNumCarta(pos);
		}
		
		else throw new AccionNoPermitidaException("El numero minimo de carta es cero");
		
	}
	
	public void guardaMazo(String url,String nombre,String lema) {
		
		EscritorFichero esc = new EscritorFichero(url);
		esc.imprimir("Brujos&Trifulcas 2");
		esc.imprimir("");
		esc.imprimir(nombre);
		esc.imprimir("");
		esc.imprimir(lema);
		esc.imprimir("");
		
		for(int i =0;i<listaCartas.size();i++){
			
			if(numCartas.get(i)>0){
				
				String codigo = listaCartas.get(i).getCodigo();
				String num = String.valueOf(numCartas.get(i));
			
				esc.imprimir(codigo+" "+num);
			}
			
		}
		
		esc.cerrar();
		
	}
	
	
	private void notificarCambioNumCarta(int pos) {
		
		for(UpdateListener2 o:listeners2){
			
			o.cambiaNumCarta(pos,numCartas.get(pos));
		}
		
	}

	private void notificarDescripcion(String descripcion) {
		
		String s;
		
		if(descripcion==null)
			s = "Sin descripcion";
		else
			s = descripcion;
		
		for(UpdateListener o:listeners)
			o.actualizarDescripcion(s);
		
	}

	private void notificarComportamientoVacio() {
		
		for(UpdateListener o:listeners)
			o.borraComportamiento();
	}

	private void notificarComportamientoModificado() {
		
		for(UpdateListener o:listeners)
			o.actualizarComportamientoActual(cartaActual.getComportamiento());
		
	}
	
	private void notificarCartaGuardada() {
		
		for(UpdateListener o:listeners)
			o.cartaGuardada();
		
	}

	private void notificarComportamientosIntervencion() {
		
		for(UpdateListener o:listeners)
			o.actualizaComportamientos(comportamientosIntervenciones);
		
	}
	
	private void notificarComportamientosEntorno() {
		
		for(UpdateListener o:listeners)
			o.actualizaComportamientos(comportamientosEntornos);
		
	}
	
	private void notificarComportamientosSer() {
		
		for(UpdateListener o:listeners)
			o.actualizaComportamientos(comportamientosSeres);
		
	}
	
	private void notificarCambioCloro() {
		
		for(UpdateListener o:listeners)
			o.cambiarCloro(cartaActual.getEntorno().getCloro());
		
	}


	private void notificarCambioDefensa() {
		
		for(UpdateListener o:listeners)
			o.cambiarAtaqueDefensa(String.valueOf(cartaActual.getSer().getAtaque()),String.valueOf(cartaActual.getSer().getDefensa()));
	}


	private void notificarCambioataque() {
		
		for(UpdateListener o:listeners)
			o.cambiarAtaqueDefensa(String.valueOf(cartaActual.getSer().getAtaque()),String.valueOf(cartaActual.getSer().getDefensa()));
		
	}


	private void notificarCambioTipo() {
		
		for(UpdateListener o:listeners)
			
			if(cartaActual.getClase()!=null)
				o.cambiarTipoClaseCarta(String.valueOf(cartaActual.getTipo()),String.valueOf(cartaActual.getClase()));
			else
				o.cambiarTipoClaseCarta(String.valueOf(cartaActual.getTipo()),"");
		
	}
	
	private void notificarNuevaIntervencion() {
		
		for(UpdateListener o:listeners)
			o.nuevaIntervencion();
		
	}


	private void notificarNuevoEntorno() {
		
		for(UpdateListener o:listeners)
			o.nuevoEntorno();
	}


	private void notificarNuevoSer() {
		
		for(UpdateListener o:listeners)
			o.nuevoSer();
		
	}


	private void notificarCambioMaximo() {
		
		for(UpdateListener o:listeners)
			o.cambiarMaximoCarta(cartaActual.getMaximo());
		
	}


	private void notificarCambioImagen() {
		
		for(UpdateListener o:listeners)
			o.cambiarImagenCarta(cartaActual.getImagen());
		
	}


	private void notificarCambioCoste() {
		
		for(UpdateListener o:listeners)
			o.cambiarCosteCarta(cartaActual.getCoste());
		
	}


	private void notificarCambioClase() {
		
		for(UpdateListener o:listeners)
			
			if(cartaActual.getTipo()!=null)
				o.cambiarTipoClaseCarta(String.valueOf(cartaActual.getTipo()),String.valueOf(cartaActual.getClase()));
			else
				o.cambiarTipoClaseCarta("",String.valueOf(cartaActual.getClase()));

	
	}


	private void notificarCambioCodigo(String codigo){
		
		for(UpdateListener o:listeners){
			o.cambiarCodigoCarta(codigo);

		}
			
	}
	
	private  void notificarNuevasCartas() {
		
		for(UpdateListener2 o:listeners2){
			
			o.actualizarPanel(listaCartas);
		}
		
	}



	



	

	



}
