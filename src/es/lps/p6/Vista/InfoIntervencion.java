package es.lps.p6.Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

import es.lps.p6.Controlador.Controlador;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoIntervencion extends JPanel{
	
	private Controlador c;
	private JCheckBox checkPermanente;
	
	public InfoIntervencion() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setVgap(50);
		
		JLabel lblPermanente = new JLabel("Permanente");
		add(lblPermanente);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		add(chckbxNewCheckBox);
	}

	public void aniadirControlador(Controlador controlador) {
		
		this.c = controlador;
		
	}
	

	
	class OyenteCheck implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
			c.cambiaTipoIntervencion(checkPermanente.isSelected());
			
		}

		
	}
}
