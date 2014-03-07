package es.lps.p6.Vista;

import java.awt.event.MouseListener;

import es.lps.p6.Modelo.Cloro;

public interface PanelCarta {

	
	public void setAtaque_Defensa(String ataque,String defensa);
	
	public void setCodigo(String codigo);
	
	public void setCoste(Cloro c);

	public void setTipoClase(String clase,String tipo);

	public void setImagen(String imagen);
	
	public void aniadeOyente(MouseListener l);
}
