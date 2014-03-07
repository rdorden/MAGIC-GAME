package es.lps.p6.Vista;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import es.lps.p6.Controlador.Controlador;
import es.lps.p6.Modelo.Cloro;

public class InfoEntorno extends JPanel{

	private JButton Cloros;
	private JTextField tierra,generico,espiritu,mar,aire;
	private Controlador c;


	public InfoEntorno(){
		
			setLayout(new GridLayout(1,2,0,0));
			JPanel panel_11 = new JPanel();
		 
		    FlowLayout flowLayout_4 = (FlowLayout) panel_11.getLayout();
		    flowLayout_4.setVgap(60);
		    add(panel_11);
		    
		    Cloros = new JButton("Cloros");
		    Cloros.setName("coste");
		    Cloros.addActionListener(new OyenteBoton());
		    panel_11.add(Cloros);
		    
		    JPanel panel_12 = new JPanel();
		    add(panel_12);
		    panel_12.setLayout(new GridLayout(5, 2));
		    
		    JLabel l = new JLabel("Tierra: ");
		    tierra = new JTextField(2);
		    tierra.setEditable(false);
		    JLabel l2 = new JLabel("Aire: ");
		    aire = new JTextField(2);
		    aire.setEditable(false);
		    JLabel l4 = new JLabel("Mar");
		    mar = new JTextField(2);
		    mar.setEditable(false);
		    JLabel l5 = new JLabel("Espiritu: ");
		    espiritu = new JTextField(2);
		    espiritu.setEditable(false);;
		    JLabel l6 = new JLabel("Generico: ");
		    generico = new JTextField(2);
		    generico.setEditable(false);
		    
		    panel_12.add(l);
		    panel_12.add(tierra);
		    panel_12.add(l2);
		    panel_12.add(aire);
		    panel_12.add(l4);
		    panel_12.add(mar);
		    panel_12.add(l5);
		    panel_12.add(espiritu);
		    panel_12.add(l6);
		    panel_12.add(generico);
	}
	
	

	public void setCloro(Cloro cloro) {
		
		tierra.setText(cloro.getTierra());
		mar.setText(cloro.getMar());
		aire.setText(cloro.getAire());
		espiritu.setText(cloro.getEspiritu());
		generico.setText(cloro.getGenerico());
		
	}

	public void aniairControlador(Controlador controlador) {
		
		c = controlador;
		
	}
	
	
	class OyenteBoton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			InfoCloro p = new InfoCloro();
			int aux = JOptionPane.showConfirmDialog(null, p, "Elige los cloros de este Entorno", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
			
				if(aux==JOptionPane.OK_OPTION)
					c.cambiaCloro(p.numTierra(),p.numMar(),p.numAire(),p.numEspiritu(),p.numGenerico());
			
		}
		
		
	}


}
