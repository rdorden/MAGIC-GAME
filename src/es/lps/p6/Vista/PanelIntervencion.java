package es.lps.p6.Vista;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.LineBorder;
import es.lps.p6.Controlador.Controlador;
import es.lps.p6.Modelo.Carta;
import es.lps.p6.Modelo.Cloro;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;


public class PanelIntervencion extends JPanel implements PanelCarta{

	/**
	 * Create the panel.
	 */
	private JLabel tipoClase,codigo,imagen,comportamiento,efecto,coste;
	
	public PanelIntervencion() {
		setBackground(new Color(173, 255, 47));
		setBorder(new LineBorder(new Color(0, 0, 0), 8));
		

		
			setLayout(new MigLayout("", "[]", "[][][][][][][][][]"));
			
			 codigo = new JLabel("Codigo: ");
			add(codigo, "cell 0 0");
			
			 tipoClase = new JLabel("Tipo/Clase: ");
			add(tipoClase, "cell 0 1");
			
			imagen = new JLabel("");
			add(imagen, "cell 0 2,alignx center,aligny center");

			
			coste = new JLabel("Coste");
			coste.setToolTipText("Tierra: "+"\n"+"Aire: "+"\n"+"Mar: "+"\n"+"Espiritu: "+"Generico: ");
			add(coste, "cell 0 3");
			
			

			
			comportamiento = new JLabel("Comportamiento");
			add(comportamiento, "cell 0 5");
			
			JLabel label_1 = new JLabel("       ");
			add(label_1, "cell 0 7");
			
			
			
			JLabel label = new JLabel("     ");
			add(label, "cell 0 8");

		}

	
	public PanelIntervencion(Carta c) {
		
		
		setBackground(new Color(173, 255, 47));
		setBorder(new LineBorder(new Color(0, 0, 0), 8));
		

		
			setLayout(new MigLayout("", "[]", "[][][][][][][][][]"));
			
			 codigo = new JLabel("Codigo: "+c.getCodigo());
			add(codigo, "cell 0 0");
			
			 tipoClase = new JLabel("Tipo/Clase: "+c.getTipo()+"/"+c.getClase());
			add(tipoClase, "cell 0 1");
			
			imagen = new JLabel("");
			imagen.setIcon(new ImageIcon(c.getImagen()));
			add(imagen, "cell 0 2");
			
			Cloro cl = c.getCoste();
			
			coste = new JLabel("Coste");
			coste.setToolTipText("Tierra: "+cl.getTierra()+"\n"+"Aire: "+cl.getAire()+"\n"+"Mar: "+cl.getMar()+"\n"+"Espiritu: "+cl.getEspiritu()+"Generico: "+cl.getGenerico());
			add(coste, "cell 0 3");
			
			

			
			comportamiento = new JLabel("Comportamiento");
			comportamiento.setToolTipText(c.getDescripcion());
			add(comportamiento, "cell 0 5");
			
			JLabel label_1 = new JLabel("       ");
			add(label_1, "cell 0 7");
			
			
			
			JLabel label = new JLabel("     ");
			add(label, "cell 0 8");
			


		
		}

	@Override
	public void aniadeOyente(MouseListener l) {
		
		tipoClase.addMouseListener(l);
		codigo.addMouseListener(l);
		imagen.addMouseListener(l);
		comportamiento.addMouseListener(l);
		addMouseListener(l);

		
	}
	
	
	@Override
	public void setAtaque_Defensa(String ataque, String defensa) {
		
		
	}




	@Override
	public void setCodigo(String codigo) {
		
		this.codigo.setText("Codigo: "+codigo);
		
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
