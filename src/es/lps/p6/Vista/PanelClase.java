package es.lps.p6.Vista;

import javax.swing.JPanel;
import javax.swing.JComboBox;

import es.lps.p6.Modelo.Modelo;

public class PanelClase extends JPanel{
	
	JComboBox<String> clase;
	
	public PanelClase() {
		
		clase = new JComboBox<String>(Modelo.clases);
		add(clase);
	}
	
	public String getClase(){
		
		return (String)clase.getSelectedItem();
	}

}
