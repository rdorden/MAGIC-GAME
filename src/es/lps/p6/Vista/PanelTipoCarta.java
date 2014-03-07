package es.lps.p6.Vista;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.plaf.SliderUI;


public class PanelTipoCarta extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JRadioButton radioSer;
	private JRadioButton radioEntorno;
	private JRadioButton radioIntervencion;
	/**
	 * Create the panel.
	 */
	public PanelTipoCarta() {
		setLayout(new GridLayout(3, 1, 0, 0));
		
		radioSer = new JRadioButton("SER                  ");
		radioSer.setHorizontalAlignment(SwingConstants.CENTER);
		add(radioSer);
		
		radioEntorno = new JRadioButton("ENTORNO        ");
		radioEntorno.setHorizontalAlignment(SwingConstants.CENTER);
		add(radioEntorno);
		
		radioIntervencion = new JRadioButton("INTERVENCION");
		radioIntervencion.setHorizontalAlignment(SwingConstants.CENTER);
		add(radioIntervencion);
		
		ButtonGroup b = new ButtonGroup();
		
		b.add(radioEntorno);
		b.add(radioIntervencion);
		b.add(radioSer);
		
		radioSer.setSelected(true);

	}
	
	public String tipoCarta(){
		
		if(radioSer.isSelected())
			return "SER";
		
		else if(radioEntorno.isSelected())
			return "Entorno";
		
		else
			return "Intervencion";
	}
	

}
