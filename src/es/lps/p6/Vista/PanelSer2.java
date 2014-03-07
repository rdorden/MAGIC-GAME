package es.lps.p6.Vista;



import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;



import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.*;

import es.lps.p6.Modelo.Carta;
import es.lps.p6.Modelo.Cloro;

import java.awt.Color;

public class PanelSer2 extends JPanel implements PanelCarta{

	/**
	 * Create the panel.
	 */
	
	JLabel tipoClase,codigo,atqDef,imagen,comportamiento,efecto,coste;
	
	public PanelSer2() {
		
		setBackground(new Color(184, 134, 11));
		

			setBorder(new LineBorder(new Color(0, 0, 0), 8));
		
		setLayout(new MigLayout("", "[][]", "[][][][][][][]"));
		
		 codigo = new JLabel("Codigo: ");
		add(codigo, "cell 0 0");
		
		 tipoClase = new JLabel("Tipo/Clase: ");
		add(tipoClase, "cell 0 1");
		 
		 imagen = new JLabel("");
		 imagen.setIcon(new ImageIcon("C:\\Users\\rodrigo\\Desktop\\workspace\\Practica5\\res\\imagenes\\lobo.jpg"));
		 add(imagen, "cell 0 2 2 1,alignx center,aligny center");
		
		 atqDef = new JLabel("Atq/Def");
		 add(atqDef, "cell 0 3");
		
		coste = new JLabel("Coste");
		add(coste, "cell 0 4");
		
		
		coste.setToolTipText("Tierra: "+"\n"+"Aire: "+"\n"+"Mar: "+"\n"+"Espiritu: "+"Generico: ");
		
		comportamiento = new JLabel("Comportamiento");
	//	comportamiento.setToolTipText(c.getDescripcion());
		add(comportamiento, "cell 0 5");
		
		efecto = new JLabel("Efecto");
		add(efecto, "cell 0 6");

	}
	
	public PanelSer2(Carta c) {
		
		setBackground(new Color(184, 134, 11));
		

		setBorder(new LineBorder(new Color(0, 0, 0), 8));
		
		setLayout(new MigLayout("", "[]", "[][][][][][][]"));
		
		 codigo = new JLabel("Codigo: "+c.getCodigo());
		add(codigo, "cell 0 0");
		
		 tipoClase = new JLabel("Tipo/Clase: "+c.getTipo()+"/"+c.getClase());
		add(tipoClase, "cell 0 1");
		
		imagen = new JLabel("");
		imagen.setIcon(new ImageIcon(c.getImagen()));
		add(imagen, "cell 0 2");
		
		 atqDef = new JLabel("Atq/Def"+c.getSer().getAtaque()+"/"+c.getSer().getDefensa());
		add(atqDef, "cell 0 3");
		
		coste = new JLabel("Coste");
		add(coste, "cell 0 4");
		
		Cloro cl = c.getCoste();
		coste.setToolTipText("Tierra: "+cl.getTierra()+"\n"+"Aire: "+cl.getAire()+"\n"+"Mar: "+cl.getMar()+"\n"+"Espiritu: "+cl.getEspiritu()+"Generico: "+cl.getGenerico());
		
		comportamiento = new JLabel("Comportamiento");
		comportamiento.setToolTipText(c.getDescripcion());
		add(comportamiento, "cell 0 5");
		
		efecto = new JLabel("Efecto");
		add(efecto, "cell 0 6");

	}

	public void aniadeOyente(MouseListener oyente) {
		
		tipoClase.addMouseListener(oyente);
		codigo.addMouseListener(oyente);
		atqDef.addMouseListener(oyente);
		imagen.addMouseListener(oyente);
		comportamiento.addMouseListener(oyente);
		efecto.addMouseListener(oyente);
		addMouseListener(oyente);
	}


	@Override
	public void setAtaque_Defensa(String ataque, String defensa) {
		
		atqDef.setText("Atq/Def: "+ataque+"/"+defensa);
	}


	@Override
	public void setCodigo(String codigo) {
		
		this.codigo.setText("Codigo: "+codigo);
		validate();
		
	}

	@Override
	public void setCoste(Cloro c) {
		
		coste.setToolTipText("Tierra: "+c.getTierra()+"\n"+"Aire: "+c.getAire()+"\n"+"Mar: "+c.getMar()+"\n"+"Espiritu: "+c.getEspiritu()+"Generico: "+c.getGenerico());
		
	}


	@Override
	public void setTipoClase(String tipo, String clase) {
		
		tipoClase.setText("Tipo/Clase: "+tipo+"/"+clase);
		
	}

	@Override
	public void setImagen(String imagen) {
		
		this.imagen.setIcon(new ImageIcon(imagen));
		
	}

}
