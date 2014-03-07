package es.lps.p6.Vista;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.LineBorder;

import es.lps.p6.Modelo.Carta;
import es.lps.p6.Modelo.Cloro;
import java.awt.Color;
import java.awt.event.MouseListener;

public class PanelEntorno extends JPanel implements PanelCarta{

	private JLabel tipoClase,codigo,imagen,comportamiento,efecto;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel label_1;
	
	public PanelEntorno() {
		
		setBackground(new Color(0, 255, 255));

			setBorder(new LineBorder(new Color(0, 0, 0), 8));
		
		setLayout(new MigLayout("", "[]", "[][][][][][][]"));
		
		 codigo = new JLabel("Codigo: ");
		add(codigo, "cell 0 0");
		
		 tipoClase = new JLabel("Tipo/Clase: ");
		add(tipoClase, "cell 0 1");
		
		imagen = new JLabel("");

		add(imagen, "cell 0 2");
		
		

		
		comportamiento = new JLabel("Comportamiento");
		add(comportamiento, "cell 0 3");
		
		lblNewLabel = new JLabel("         ");
		add(lblNewLabel, "cell 0 4");
		
		label = new JLabel("          ");
		add(label, "cell 0 5");
		
		label_1 = new JLabel("       ");
		add(label_1, "cell 0 6");
		
		

	
	}
	
	public PanelEntorno(Carta c) {
		
		setBackground(new Color(0, 255, 255));
	
			setBorder(new LineBorder(new Color(0, 0, 0), 8));
		
		setLayout(new MigLayout("", "[]", "[][][][][][][]"));
		
		 codigo = new JLabel("Codigo: "+c.getCodigo());
		add(codigo, "cell 0 0");
		
		 tipoClase = new JLabel("Tipo/Clase: "+c.getTipo()+"/"+c.getClase());
		add(tipoClase, "cell 0 1");
		
		imagen = new JLabel("");
		imagen.setIcon(new ImageIcon(c.getImagen()));
		add(imagen, "cell 0 2");
		
		
		Cloro cl = c.getEntorno().getCloro();
		
		comportamiento = new JLabel("Comportamiento");
		comportamiento.setToolTipText(c.getDescripcion());
		add(comportamiento, "cell 0 3");
		
		lblNewLabel = new JLabel("         ");
		add(lblNewLabel, "cell 0 4");
		
		label = new JLabel("          ");
		add(label, "cell 0 5");
		
		label_1 = new JLabel("       ");
		add(label_1, "cell 0 6");
		
		

	
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
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setCodigo(String codigo) {
		
		this.codigo.setText("Codigo: "+codigo);
		
		
	}

	@Override
	public void setCoste(Cloro c) {
		
		
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
