package es.lps.p6.Vista;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import es.lps.p6.Controlador.Controlador;

public class InfoCloro extends JPanel {
	
	private JSlider sliderTierra,sliderMar,sliderAire,sliderEspiritu,sliderGenerico;
	private JTextField textTierra,textMar,textAire,textEspiritu,textGenerico;
	
	private Controlador c;
	
	public InfoCloro(){
		
		
		sliderTierra = new JSlider(0,20,0);
		sliderMar = new JSlider(0,20,0);
		sliderAire = new JSlider(0,20,0);
		sliderEspiritu = new JSlider(0,20,0);
		sliderGenerico = new JSlider(0,20,0);
		
		sliderTierra.setName("sliderTierra");
		sliderMar.setName("sliderMar");
		sliderAire.setName("sliderAire");
		sliderEspiritu.setName("sliderEspiritu");
		sliderGenerico.setName("sliderGenerico");
		
		OyenteSlider o = new OyenteSlider();
		
		sliderTierra.addChangeListener(o);
		sliderMar.addChangeListener(o);
		sliderAire.addChangeListener(o);
		sliderEspiritu.addChangeListener(o);
		sliderGenerico.addChangeListener(o);
		
		textTierra = new  JTextField("0",2);
		textTierra.setEditable(false);
		textMar = new JTextField("0",2);
		textMar.setEditable(false);
		textAire = new JTextField("0",2);
		textAire.setEditable(false);
		textEspiritu = new JTextField("0",2);
		textEspiritu.setEditable(false);
		textGenerico = new JTextField("0",2);
		textGenerico.setEditable(false);
		
		
		setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblTierra = new JLabel("Tierra:                          ");
		lblTierra.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblTierra);
		panel.add(sliderTierra);
		panel.add(textTierra);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		add(panel_1);
		
		JLabel lblMar = new JLabel("  Mar:                            ");
		lblMar.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lblMar);
		panel_1.add(sliderMar);
		panel_1.add(textMar);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		add(panel_2);
		
		JLabel lblAire = new JLabel("   Aire:                           ");
		panel_2.add(lblAire);
		panel_2.add(sliderAire);
		panel_2.add(textAire);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		add(panel_3);
		
		JLabel lblEspiritu = new JLabel("   Espiritu:                     ");
		panel_3.add(lblEspiritu);
		panel_3.add(sliderEspiritu);
		panel_3.add(textEspiritu);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_4.getLayout();
		add(panel_4);
		
		JLabel lblGenerico = new JLabel("    Generico:                  ");
		panel_4.add(lblGenerico);
		panel_4.add(sliderGenerico);
		panel_4.add(textGenerico);
		
		
	}
	
	public String numTierra(){
		
		return textTierra.getText();
	}
	
	public String numAire(){
		
		return textAire.getText();	
	}
	
	public String numMar(){
		
		return textMar.getText();
	}
	
	public String numEspiritu(){
		
		return textEspiritu.getText();
	}
	
	public String numGenerico(){
		
		return textGenerico.getText();
	}
	
	class OyenteSlider implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			
			JSlider j = (JSlider)e.getSource();
			
			if(j.getName().equalsIgnoreCase("sliderTierra"))
				textTierra.setText(String.valueOf(sliderTierra.getValue()));
			
			else if(j.getName().equalsIgnoreCase("sliderMar"))
				textMar.setText(String.valueOf(sliderMar.getValue()));
			
			else if(j.getName().equalsIgnoreCase("sliderAire"))
				textAire.setText(String.valueOf(sliderAire.getValue()));
			
			else if(j.getName().equalsIgnoreCase("sliderEspiritu"))
				textEspiritu.setText(String.valueOf(sliderEspiritu.getValue()));
			
			else if(j.getName().equalsIgnoreCase("sliderGenerico"))
				textGenerico.setText(String.valueOf(sliderGenerico.getValue()));
		}
		
		
	}

	public void aniadirControlador(Controlador controlador) {
		
		this.c = controlador;
		
	}

}
