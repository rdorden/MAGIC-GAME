package es.lps.p6.Vista;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class CajaTexto extends JPanel{
	
	private JTextField textField;
	
	public CajaTexto() {
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
	}
	
	public String getTexto(){
		
		return textField.getText();
	}

}
