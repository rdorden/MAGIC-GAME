package es.lps.p6.Controlador;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import es.lps.p6.Modelo.Carta;
import es.lps.p6.Modelo.Cloro;
import es.lps.p6.Modelo.EscritorXML;
import es.lps.p6.Modelo.Modelo;
import es.lps.p6.Modelo.Tipo;
import es.lps.p6.Vista.InfoSer;
import es.lps.p6.Vista.PanelClase;

public class Controlador {
	
	private Modelo modelo;
	
	
	public Controlador(Modelo m){
		
		modelo = m;
	}
	
	
	public void cambiaTexto(String nombre,String texto){
		

		if(nombre.equalsIgnoreCase("Nombre"))
			modelo.cambiaNombreCarta(texto);
		
		else if(nombre.equalsIgnoreCase("Codigo"))
			modelo.cambiaCodigoCarta(texto);
		
	}


	public void cambiaTipoClase(String nombre,String texto) {
		
		if(!(texto.equalsIgnoreCase("Tipo")||texto.equalsIgnoreCase("Clase"))){
			
			if(nombre.equalsIgnoreCase("Clases"))
				modelo.cambiaClaseCarta(texto);
			
			else if(nombre.equalsIgnoreCase("Tipos"))
				modelo.cambiaTipoCarta(texto);
			
		}
		
		
	}


	public void cambiaCoste(String tierra, String mar, String aire,
			String espiritu, String generico) {
		
		Cloro c = new Cloro(tierra,mar,aire,espiritu,generico);
		
		modelo.cambiaCoste(c);
		
	}


	public void cambiaImagen(String imagen) {
		
		
		modelo.cambiaImagenCarta(imagen);
	}


	public void cambiaMaximo(int maximo) {
		
		modelo.cambiaMaximoCarta(maximo);
		
	}


	public void empieza(String tipoCarta) {
		
		
		if(tipoCarta.equalsIgnoreCase("Ser"))
			modelo.creaCartaSer();
		else if(tipoCarta.equalsIgnoreCase("Entorno"))
			modelo.creaCartaEntorno();
		else
			modelo.creaCartaIntervencion();
		
		
		
	}


	public void cambiaAtaqueDefensa(String nombre, int valor) {
		
		if(nombre.equalsIgnoreCase("Ataque"))
			modelo.cambiaAtaqueSer(valor);
		else if(nombre.equalsIgnoreCase("Defensa"))
			modelo.cambiaDefensa(valor);
		
	}


	public void cambiaCloro(String tierra, String mar, String aire,
			String espiritu, String generico) {
		
		Cloro c = new Cloro(tierra,mar,aire,espiritu,generico);
		modelo.cambiaCloroEntorno(c);
		
		
	}


	public void cambiaTipoIntervencion(boolean selected) {
		
		modelo.cambiaTipoIntervencion(selected);
		
	}


	public void guardaCarta() throws AccionNoPermitidaException {
		
		if(modelo.getCartaActual().getTipo()==null)
			throw new AccionNoPermitidaException("Falta por elegir el tipo");
		
		if(modelo.getCartaActual().getClase()==null)
			throw new AccionNoPermitidaException("Falta por elegir la clase");
		
		if(modelo.getCartaActual().getImagen()==null)
			throw new AccionNoPermitidaException("Falta por elegir la imagen");
		
		if(modelo.getCartaActual().getCodigo()==null||modelo.getCartaActual().getCodigo()=="")
			throw new AccionNoPermitidaException("Falta por elegir el codigo");
		
		if(modelo.getCartaActual().getNombre()==null||modelo.getCartaActual().getNombre()=="")
			throw new AccionNoPermitidaException("Falta por elegir el nombre");
		
		if(!modelo.esNuevaCartaActual())
			throw new AccionNoPermitidaException("Esta carta ya esta guardada, pulsa el boton nueva para crear otra carta");
		
		modelo.guardaCarta();
		
		
	}


	public void aniadeComportamiento(String codigo) {
		
		
		
		int id = modelo.getIdComportamiento(codigo);
		String descripcion = modelo.getDescripcion(codigo);
		
		
		if(modelo.getCartaActual().getTipo().equals(Tipo.ENTORNO)){
			
			
			if(id==1){
				
				modelo.cambiaIdComportamiento(id);
				modelo.cambiaDescripcion(descripcion);
				modelo.cambiaCodigoComportamiento(codigo);
				modelo.cambiaNombreComportamiento(codigo);
				
				
			}


			if(id==2){
				
				PanelClase p = new PanelClase();
				JOptionPane.showMessageDialog(null, p, "Elige la clase", JOptionPane.PLAIN_MESSAGE);
			
				
				modelo.cambiaVariable3Comportamiento(p.getClase());	
				modelo.cambiaIdComportamiento(id);
				modelo.cambiaDescripcion(descripcion);
				modelo.cambiaCodigoComportamiento(codigo);
				modelo.cambiaNombreComportamiento(codigo);
					
				
					
			}

			
		}
		
		if(modelo.getCartaActual().getTipo().equals(Tipo.INTERVENCION)){
			
			
			if(id==1){
				
				modelo.cambiaIdComportamiento(id);
				modelo.cambiaDescripcion(descripcion);
				modelo.cambiaCodigoComportamiento(codigo);
				modelo.cambiaNombreComportamiento(codigo);
				
				
			}
			
			if(id==3){
				
				InfoSer p1 = new InfoSer(true,false);
				JOptionPane.showMessageDialog(null, p1, "Elige el ataque", JOptionPane.PLAIN_MESSAGE);

						
				modelo.cambiaIdComportamiento(id);
				modelo.cambiaDescripcion(descripcion);
				modelo.cambiaCodigoComportamiento(codigo);
				modelo.cambiaNombreComportamiento(codigo);
				modelo.cambiaVariable2Comportamiento(p1.getAtaque());
					
					
					
			}
			
			if(id==2){
				
				InfoSer p2 = new InfoSer(false,true);
				JOptionPane.showMessageDialog(null, p2, "Elige la defensa", JOptionPane.PLAIN_MESSAGE);
	
						
				modelo.cambiaIdComportamiento(id);
				modelo.cambiaDescripcion(descripcion);
				modelo.cambiaCodigoComportamiento(codigo);
				modelo.cambiaNombreComportamiento(codigo);
				modelo.cambiaVariable2Comportamiento(p2.getDefensa());		
					
			}
			
			
		}
		
		if(modelo.getCartaActual().getTipo().equals(Tipo.SER)){
			
			if(id==1){
				
				modelo.cambiaIdComportamiento(id);
				modelo.cambiaDescripcion(descripcion);
				modelo.cambiaCodigoComportamiento(codigo);
				modelo.cambiaNombreComportamiento(codigo);
				
			}
			
			if(id==2){
				
				PanelClase p3 = new PanelClase();
				JOptionPane.showMessageDialog(null, p3, "Elige la clase", JOptionPane.PLAIN_MESSAGE);
				
				
					
					modelo.cambiaIdComportamiento(id);
					modelo.cambiaDescripcion(descripcion);
					modelo.cambiaCodigoComportamiento(codigo);
					modelo.cambiaNombreComportamiento(codigo);
					modelo.cambiaVariable3Comportamiento(p3.getClase());
	
			}
			
			if(id==3){
				
				PanelClase p4 = new PanelClase();
				JOptionPane.showMessageDialog(null, p4, "Elige la clase", JOptionPane.PLAIN_MESSAGE);
					
				modelo.cambiaVariable3Comportamiento(p4.getClase());
					
				
				
				InfoSer p5 = new InfoSer(false,true);
				JOptionPane.showMessageDialog(null, p5, "Elige la defensa", JOptionPane.PLAIN_MESSAGE);
		
				modelo.cambiaIdComportamiento(id);
				modelo.cambiaDescripcion(descripcion);
				modelo.cambiaCodigoComportamiento(codigo);
				modelo.cambiaNombreComportamiento(codigo);
				
				modelo.cambiaVariable2Comportamiento(p5.getDefensa());
				modelo.cambiaVariable1Comportamiento(p5.getAtaque());
				
			}
			
			if(id==4){
				
				InfoSer p6 = new InfoSer(true,false);
				JOptionPane.showMessageDialog(null, p6, "Elige el ataque", JOptionPane.PLAIN_MESSAGE);
				
				modelo.cambiaIdComportamiento(id);
				modelo.cambiaDescripcion(descripcion);
				modelo.cambiaCodigoComportamiento(codigo);
				modelo.cambiaNombreComportamiento(codigo);
				modelo.cambiaVariable1Comportamiento(p6.getAtaque());
				
			}
		}
		
	}


	public void borraComportamientoActual() {
		
		modelo.borraComportamientoCarta();
		
	}


	public void visualizaDescripcion(String codigo) {
		
		modelo.muestraDescripcion(codigo);
		
		
	}


	public void guardaXML(String url) {
		
		List<Carta> l = modelo.getListaCartas();
		
		EscritorXML escritor = new EscritorXML(url);
		escritor.escribirXML(l);
		
	}


	public void empiezaMazo(String url) {
		
		modelo.leerCartas(url);
		
	}


	public void aumentaNumCarta(int pos)throws AccionNoPermitidaException {
		
		modelo.aumentaCarta(pos);
		
	}


	public void restaNumCarta(int pos)throws AccionNoPermitidaException {
		
		modelo.restaCarta(pos);
		
	}


	public void guarda(String url,String nombre,String lema) {
		
		modelo.guardaMazo(url,nombre,lema);
		
	}

}
