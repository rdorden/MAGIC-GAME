package es.lps.p6.Vista;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;


public class PanelInicio extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JRadioButton radioButtonMazo,radioButtonCarta;
	/**
	 * Create the panel.
	 */
	public PanelInicio() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		radioButtonMazo = new JRadioButton("  Crear Mazo");
		radioButtonMazo.setSelected(true);
		radioButtonMazo.setHorizontalAlignment(SwingConstants.CENTER);
		radioButtonMazo.setVerticalAlignment(SwingConstants.CENTER);
		add(radioButtonMazo);
		
		radioButtonCarta = new JRadioButton("Crear Cartas");
		radioButtonCarta.setHorizontalAlignment(SwingConstants.CENTER);
		add(radioButtonCarta);
		
		ButtonGroup b = new ButtonGroup();
		
		b.add(radioButtonCarta);
		b.add(radioButtonMazo);

	}
	
	public boolean nuevoMazo(){
		
		return radioButtonMazo.isSelected();
	}
	
	public boolean nuevaCarta(){
		
		return radioButtonCarta.isSelected();
	}

}