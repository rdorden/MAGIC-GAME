package es.lps.p6.Vista;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.UIManager;

import es.lps.p6.Controlador.Controlador;

import java.awt.Color;

public class InfoSer extends JPanel{
	
	private JSlider sliderAtaque,sliderDefensa;
	private JTextField textVida,textDefensa,textAtaque;
	private Controlador c;
	
	public InfoSer(boolean atq,boolean def){
		setBorder(new TitledBorder(null, "Ataque/Defensa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		sliderAtaque = new JSlider();
		sliderDefensa = new JSlider();
	

		textDefensa = new JTextField(5);
		textDefensa.setEditable(false);
		textAtaque = new JTextField(5);
		textAtaque.setEditable(false);
		
		JPanel p1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) p1.getLayout();
		flowLayout.setVgap(60);
		JPanel p2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) p2.getLayout();
		flowLayout_1.setVgap(0);
	
		sliderAtaque.setMinimum(0);
		sliderAtaque.setMaximum(20);
		sliderAtaque.setValue(0);
		sliderAtaque.setName("Ataque");
		sliderAtaque.addChangeListener(new OyenteSlider());
		
		sliderDefensa.setMinimum(0);
		sliderDefensa.setMaximum(20);
		sliderDefensa.setValue(0);
		sliderDefensa.setName("Defensa");
		sliderDefensa.addChangeListener(new OyenteSlider());
		
		textDefensa.setText("0");
		textAtaque.setText("0");

		JLabel labelAtaque = new JLabel("Atq: ");
		JLabel labelDefensa = new JLabel("Def: ");
		
		setLayout(new GridLayout(2,1));

		sliderAtaque.setVisible(atq);
		textAtaque.setVisible(atq);
		labelAtaque.setVisible(atq);
		
		sliderDefensa.setVisible(def);
		textDefensa.setVisible(def);
		labelDefensa.setVisible(def);

		p1.add(labelAtaque);
		p1.add(sliderAtaque);
		p1.add(textAtaque);
		
		
		p2.add(labelDefensa);
		p2.add(sliderDefensa);
		p2.add(textDefensa);
		
		add(p1);
		add(p2);

	}
	
	public void aniadirControlador(Controlador c){
		
		
		this.c = c;
	}
	
	public void setAtaque(String ataque) {
		
		textAtaque.setText(ataque);
		
	}

	public void setDefensa(String defensa) {
		
		textDefensa.setText(defensa);
		
	}
	
	public String getAtaque(){
		
		return textAtaque.getText();
	}
	
	
	public String getDefensa(){
		
		return textDefensa.getText();
	}
	
	class OyenteSlider implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			
			JSlider j = (JSlider)e.getSource();
			
			if(c!=null)
				c.cambiaAtaqueDefensa(j.getName(),j.getValue());
			
			else{
				
				if(j.getName().equalsIgnoreCase("Ataque"))
					textAtaque.setText(String.valueOf(sliderAtaque.getValue()));
				
				if(j.getName().equalsIgnoreCase("Defensa"))
					textDefensa.setText(String.valueOf(sliderDefensa.getValue()));
			}
			
		}
		
		
	}



}
