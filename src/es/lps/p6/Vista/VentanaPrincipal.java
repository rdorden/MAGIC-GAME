package es.lps.p6.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import es.lps.p6.Controlador.AccionNoPermitidaException;
import es.lps.p6.Controlador.Controlador;
import es.lps.p6.Modelo.Cloro;
import es.lps.p6.Modelo.Comportamiento;
import es.lps.p6.Modelo.Modelo;
import es.lps.p6.Modelo.UpdateListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.SliderUI;
import javax.swing.JSlider;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JTextPane;
import java.awt.Panel;





public class VentanaPrincipal extends JFrame {

	private JPanel contentPane,panelEspecifico,panelImagenCarta,panel_21;
	private JTextField nombre,codigo;
	private JTextField tierra,aire,mar,espiritu,generico;
	private JTextField textRuta;
	private JTextField maximoText;
	private JSlider sliderMaximo;
	
	private JComboBox<String> clases,boxComportamientos;
	private JButton coste, imagen,botonGuardar,botonAgregar,botonNueva,botonGuardarLista,botonBorrar ;	
	private PanelCarta carta;
	private InfoSer infoSer;
	private InfoEntorno infoEntorno;
	private InfoIntervencion infoIntervencion;
	
	private Controlador controlador;
	private UpdateListener oyenteModelo;
	private JTextArea textArea;
	

	

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(Controlador c) {
		
		
		controlador = c;
		oyenteModelo = new OyenteModelo();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelCaracteristicas = new JPanel();
		panelCaracteristicas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panelCaracteristicas);
		panelCaracteristicas.setLayout(new GridLayout(0, 1, 0, 0));
	
		JPanel p2 = new JPanel();
	    panelCaracteristicas.add(p2,BorderLayout.NORTH);
	    p2.setLayout(new GridLayout(2, 1, 0, 0));
	    
	    JPanel p1 = new JPanel();
		panelCaracteristicas.add(p1,BorderLayout.SOUTH);
		p1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_15 = new JPanel();
		p1.add(panel_15, BorderLayout.CENTER);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_17 = new JPanel();
		panel_15.add(panel_17, BorderLayout.SOUTH);
		panel_17.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_17.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_18 = new JPanel();
		panel_17.add(panel_18);
		
		imagen = new JButton("Imagen...");
		imagen.setName("Imagen");
		imagen.addActionListener(new OyenteBoton());
		panel_18.add(imagen);
		
		JPanel panel_19 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_19.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		panel_17.add(panel_19);
		
		JLabel lblNewLabel = new JLabel("Ruta:  ");
		panel_19.add(lblNewLabel);
		
		textRuta = new JTextField();
		textRuta.setName("Ruta");
		panel_19.add(textRuta);
		textRuta.setColumns(10);
		
		panel_21 = new JPanel();
		panel_15.add(panel_21, BorderLayout.CENTER);
		panel_21.setLayout(new GridLayout(1, 2, 0, 0));
		
		panelEspecifico = new JPanel();
		panel_21.add(panelEspecifico);
		panelEspecifico.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_23 = new JPanel();
		panel_21.add(panel_23);
		panel_23.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GRAY));
		panel_23.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		botonAgregar = new JButton("Agregar Comportamiento");
		botonAgregar.setName("botonAgregar");
		botonAgregar.addActionListener(new OyenteBoton());
		panel.add(botonAgregar);
		
		botonBorrar = new JButton("BorrarComportamiento");
		botonBorrar.setName("botonBorrar");
		botonBorrar.addActionListener(new OyenteBoton());
		panel.add(botonBorrar);
		
		JPanel panel_22 = new JPanel();
		panel_23.add(panel_22, BorderLayout.CENTER);
		panel_22.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_24 = new JPanel();
		panel_24.setBorder(new TitledBorder(null, "Comportamiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		FlowLayout flowLayout_5 = (FlowLayout) panel_24.getLayout();
		flowLayout_5.setVgap(30);
		panel_22.add(panel_24);
		
		boxComportamientos = new JComboBox<String>();
		boxComportamientos.addItem("Comportamiento");
		boxComportamientos.addActionListener(new OyenteBox());
		boxComportamientos.setName("boxComportamientos");
		panel_24.add(boxComportamientos);
		
		JPanel panel_25 = new JPanel();
		panel_25.setBorder(new LineBorder(Color.GRAY));
		panel_22.add(panel_25);
		panel_25.setLayout(new GridLayout(0, 1, 0, 0));
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		panel_25.add(textArea);
		
		JPanel panel_16 = new JPanel();
		p1.add(panel_16, BorderLayout.SOUTH);
		panel_16.setLayout(new GridLayout(1, 3, 0, 0));
		
		botonGuardar = new JButton("Guardar Carta");
		botonGuardar.setName("botonGuardar");
		botonGuardar.addActionListener(new OyenteBoton());
		panel_16.add(botonGuardar);
		
		botonNueva = new JButton("Nueva Carta");
		botonNueva.setName("botonNueva");
		botonNueva.addActionListener(new OyenteBoton());
		panel_16.add(botonNueva);
		
		botonGuardarLista = new JButton("Guardar Lista");
		botonGuardarLista.setName("botonGuardarLista");
		botonGuardarLista.addActionListener(new OyenteBoton());
		panel_16.add(botonGuardarLista);
	    
	    JPanel panel_2 = new JPanel();
	    panel_2.setBorder(null);
	    p2.add(panel_2);
	    panel_2.setLayout(new GridLayout(2, 1, 0, 0));
	    
	    
	    
	    JPanel panel_3 = new JPanel();
	    panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
	    panel_2.add(panel_3);
	    panel_3.setLayout(new GridLayout(1, 2, 0, 0));
	    
	    JPanel panel_1 = new JPanel();
	    FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
	    flowLayout.setVgap(20);
	    panel_3.add(panel_1);
	    
	    JLabel label = new JLabel("Nombre: ");
	    nombre = new JTextField(10);
	    nombre.setName("Nombre");
	    nombre.addKeyListener(new OyenteTexto());
	    label.setHorizontalAlignment(SwingConstants.CENTER);
	    panel_1.add(label);
	    panel_1.add(nombre);
	    
	    JPanel panel_4 = new JPanel();
	    FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
	    flowLayout_1.setVgap(20);
	    panel_3.add(panel_4);
	    
	    JLabel label_1 = new JLabel("Codigo: ");
	    codigo = new JTextField(10);
	    codigo.setName("Codigo");
	    codigo.addKeyListener(new OyenteTexto());
	    label_1.setHorizontalAlignment(SwingConstants.CENTER);
	    panel_4.add(label_1);
	    panel_4.add(codigo);
	    
	    JPanel panel_5 = new JPanel();
	    panel_2.add(panel_5);
	    panel_5.setLayout(new GridLayout(1, 2, 0, 0));
	    
	    JPanel panel_6 = new JPanel();
	    FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
	    flowLayout_2.setVgap(25);
	    panel_5.add(panel_6);
	    
	    
	    clases = new JComboBox<String>(Modelo.clases);
	    clases.setName("Clases");
	    clases.addActionListener(new OyenteBox());
	    panel_6.add(clases);
	    
	    JPanel panel_7 = new JPanel();
	    FlowLayout flowLayout_3 = (FlowLayout) panel_7.getLayout();
	    flowLayout_3.setVgap(25);
	    panel_5.add(panel_7);
	    
	    JPanel panel_8 = new JPanel();
	    panel_8.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
	    p2.add(panel_8);
	    panel_8.setLayout(new GridLayout(1, 2, 0, 0));
	    
	    JPanel panel_9 = new JPanel();
	    panel_9.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(128, 128, 128)));
	    panel_8.add(panel_9);
	    panel_9.setLayout(new GridLayout(1, 2, 0, 0));
	    
	    JPanel panel_11 = new JPanel();
	    FlowLayout flowLayout_4 = (FlowLayout) panel_11.getLayout();
	    flowLayout_4.setVgap(60);
	    panel_9.add(panel_11);
	    
	    coste = new JButton("Coste");
	    coste.setName("coste");
	    coste.addActionListener(new OyenteBoton());
	    panel_11.add(coste);
	    
	    JPanel panel_12 = new JPanel();
	    panel_9.add(panel_12);
	    panel_12.setLayout(new GridLayout(5, 2));
	    
	    JLabel l = new JLabel("Tierra: ");
	    tierra = new JTextField(2);
	    tierra.setText("0");
	    tierra.setEditable(false);
	    JLabel l2 = new JLabel("Aire: ");
	    aire = new JTextField(2);
	    aire.setText("0");
	    aire.setEditable(false);
	    JLabel l4 = new JLabel("Mar");
	    mar = new JTextField(2);
	    mar.setText("0");
	    mar.setEditable(false);
	    JLabel l5 = new JLabel("Espiritu: ");
	    espiritu = new JTextField(2);
	    espiritu.setText("0");
	    espiritu.setEditable(false);;
	    JLabel l6 = new JLabel("Generico: ");
	    generico = new JTextField(2);
	    generico.setText("0");
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

	    
	    
	    JPanel panel_10 = new JPanel();
	    panel_8.add(panel_10);
	    panel_10.setLayout(new GridLayout(3, 1, 0, 0));
	    
	    JPanel panel_13 = new JPanel();
	    panel_10.add(panel_13);
	    
	    JLabel lblMaximo = new JLabel("Maximo");
	    panel_13.add(lblMaximo);
	    
	    JPanel panel_14 = new JPanel();
	    panel_10.add(panel_14);
	    
	    maximoText = new JTextField();
	    maximoText.setText("1");
	    panel_14.add(maximoText);
	    maximoText.setColumns(10);
	    maximoText.setEditable(false);
	    
	    JPanel panel_20 = new JPanel();
	    panel_10.add(panel_20);
	    
	    sliderMaximo = new JSlider();
	    sliderMaximo.setValue(1);
	    sliderMaximo.setMaximum(30);
	    sliderMaximo.setMinimum(1);
	    sliderMaximo.addChangeListener(new OyenteSlider());
	    panel_20.add(sliderMaximo);


		JPanel panelCarta = new JPanel();
		contentPane.add(panelCarta);
		panelCarta.setLayout(new BorderLayout());
		
		FlowLayout fl_panel = new FlowLayout();
		fl_panel.setVgap(200);
		panelImagenCarta = new JPanel(fl_panel);
		panelCarta.add(panelImagenCarta,BorderLayout.CENTER);
		
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Opciones");
		menuBar.add(menu);
		//setJMenuBar(menuBar);
		JMenuItem i = new JMenuItem("Salir");
		i.addActionListener(new OyenteMenu());
		i.setName("Salir");
		menu.add(i);
	
		
		JMenu menu2 = new JMenu("¿Como funciona?");
		menuBar.add(menu2);
		setJMenuBar(menuBar);
		JMenuItem j = new JMenuItem("Ayuda");
		j.addActionListener(new OyenteMenu());
		j.setName("Ayuda");
		menu2.add(j);

	}
	
	
	public UpdateListener getOyenteModelo(){
		
		return oyenteModelo;
	}
	
	private void reiniciarValores(){
		
		nombre.setText("");
		codigo.setText("");
		clases.setSelectedIndex(0);
		sliderMaximo.setValue(1);
		maximoText.setText(String.valueOf(sliderMaximo.getValue()));
		
		tierra.setText("0");
		mar.setText("0");
		aire.setText("0");
		espiritu.setText("0");
		generico.setText("0");
		textRuta.setText("");
		textArea.setText("Sin comportamiento");
	}
	
	
	private void rellenarComportamientos(List<Comportamiento> l){
		
		boxComportamientos.removeAllItems();
		boxComportamientos.addItem("Comportamiento");
		
		for(Comportamiento c:l)
			boxComportamientos.addItem(c.getCodigo());
		
	}
	class OyenteTexto extends KeyAdapter{

		@Override
		public void keyReleased(KeyEvent e) {
			
			JTextField c = (JTextField)e.getComponent();
			String s = c.getText();
			controlador.cambiaTexto(c.getName(),c.getText());
		}

	
	}
	

	
	class OyenteBox implements ActionListener{

		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			JComboBox<String> j = (JComboBox<String>)e.getSource();

			if(!j.getName().equalsIgnoreCase("boxComportamientos"))
				controlador.cambiaTipoClase(j.getName(),(String)j.getSelectedItem());
			
			else
				controlador.visualizaDescripcion((String)j.getSelectedItem());
		
		}
		
		
	}
	
	class OyenteBoton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JButton b = (JButton)e.getSource();
			
			if(b.getName().equalsIgnoreCase("Coste")){
				
				InfoCloro p = new InfoCloro();
				int aux = JOptionPane.showConfirmDialog(null, p, "Eleccion de coste", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				
				if(aux==JOptionPane.OK_OPTION)
					controlador.cambiaCoste(p.numTierra(),p.numMar(),p.numAire(),p.numEspiritu(),p.numGenerico());
			}
			
			else if(b.getName().equalsIgnoreCase("Imagen")){
				
				
				JFileChooser chooser = new JFileChooser();
				
				int aux = chooser.showOpenDialog(null);
				
				if(aux==JFileChooser.APPROVE_OPTION){
					
					controlador.cambiaImagen(chooser.getSelectedFile().getAbsolutePath());
					
				}
			}
				
			else if(b.getName().equalsIgnoreCase("botonNueva")){
				
				PanelTipoCarta p = new PanelTipoCarta();
				int aux = JOptionPane.showConfirmDialog(null, p, "Tipo Carta", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				
				if(aux==JOptionPane.OK_OPTION)
					controlador.empieza(p.tipoCarta());
			}
			
			else if(b.getName().equalsIgnoreCase("botonGuardar")){
				
				try {
					controlador.guardaCarta();
				} catch (AccionNoPermitidaException e1) {
					
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
			
			else if(b.getName().equalsIgnoreCase("botonAgregar"))
				controlador.aniadeComportamiento((String)boxComportamientos.getSelectedItem());
			
			else if(b.getName().equalsIgnoreCase("botonBorrar")){
				
				controlador.borraComportamientoActual();
			}
			
			else if(b.getName().equalsIgnoreCase("botonGuardarLista")){
				
				JFileChooser chooser1 = new JFileChooser();
				
				int aux = chooser1.showOpenDialog(null);
				
				if(aux==JFileChooser.APPROVE_OPTION){
					
					controlador.guardaXML(chooser1.getSelectedFile().getAbsolutePath());
					
				}
			}
			
				
		}
		
		
	}
	
	class OyenteMenu implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JMenuItem i = (JMenuItem)e.getSource();
			
			if(i.getName().equalsIgnoreCase("Salir"))
				System.exit(0);
			
			if(i.getName().equalsIgnoreCase("Ayuda")){
				  
				  JOptionPane.showMessageDialog(null," Hola!!!\n Bienvenido a nuestro editor de cartas y mazos.\n " +
				  		"Esta es la ventana de editor de cartas.\n Recuerda que el xml y el dtd tienen " +
				  		"que estar en el mismo directorio\n","ESPECIFICACIONES:",JOptionPane.INFORMATION_MESSAGE);
				  

				   
			   }
			
		}
		
		 
		
		
	}
	class OyenteSlider implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			
			JSlider j = (JSlider)e.getSource();
			controlador.cambiaMaximo(j.getValue());
			
		}
		
		
	}
	
	
	class OyenteModelo implements UpdateListener{


		@Override
		public void cambiarCodigoCarta(String codigo) {
			
			carta.setCodigo(codigo);
			
		}

		@Override
		public void cambiarTipoClaseCarta(String tipo, String clase) {
			
			carta.setTipoClase(tipo,clase);
			
		}

		@Override
		public void cambiarCosteCarta(Cloro coste) {
			
			carta.setCoste(coste);
			
			tierra.setText(coste.getTierra());
			mar.setText(coste.getMar());
			aire.setText(coste.getAire());
			espiritu.setText(coste.getEspiritu());
			generico.setText(coste.getGenerico());
			
			
		}

		@Override
		public void cambiarImagenCarta(String imagen) {
			
			carta.setImagen(imagen);
			textRuta.setText(imagen);
		}

		@Override
		public void cambiarMaximoCarta(int maximo) {
			
			maximoText.setText(String.valueOf(maximo));
			
		}

		@Override
		public void nuevoSer() {
			
			panelEspecifico.removeAll();
			infoSer = new InfoSer(true,true);
			infoSer.aniadirControlador(controlador);
			panelEspecifico.add(infoSer);
			panelEspecifico.validate();
			pack();
			
			carta = new PanelSer2();
			panelImagenCarta.removeAll();
			panelImagenCarta.add((JPanel)carta);
			
			panelImagenCarta.validate();
			reiniciarValores();
			
		}

		@Override
		public void nuevoEntorno() {
			
			panelEspecifico.removeAll();
			infoEntorno = new InfoEntorno();
			infoEntorno.aniairControlador(controlador);
			panelEspecifico.add(infoEntorno);
			panelEspecifico.validate();
			pack();
			
			carta = new PanelEntorno();
			panelImagenCarta.removeAll();
			panelImagenCarta.add((JPanel)carta);
			
			panelImagenCarta.validate();
			reiniciarValores();
			
		}

		@Override
		public void nuevaIntervencion() {
			
			panelEspecifico.removeAll();
			infoIntervencion = new InfoIntervencion();
			infoIntervencion.aniadirControlador(controlador);
			panelEspecifico.add(infoIntervencion);
			panelEspecifico.validate();
			pack();
			
			carta = new PanelIntervencion();
			panelImagenCarta.removeAll();
			panelImagenCarta.add((JPanel)carta);
			
			panelImagenCarta.validate();
			reiniciarValores();
			
			
		}

		@Override
		public void cambiarAtaqueDefensa(String ataque,String defensa) {
			
			infoSer.setAtaque(ataque);
			infoSer.setDefensa(defensa);
			carta.setAtaque_Defensa(ataque, defensa);
			
		}


		@Override
		public void cambiarCloro(Cloro cloro) {
			
			infoEntorno.setCloro(cloro);
			
		}

		@Override
		public void actualizaComportamientos(List<Comportamiento> l) {
			
			rellenarComportamientos(l);
			
		}

		@Override
		public void cartaGuardada() {
			
			JOptionPane.showMessageDialog(null, "La carta ha sido guardada, pulsa el boton nueva \n para crear otra carta");
			
		}

		@Override
		public void actualizarComportamientoActual(Comportamiento c) {
			
			textArea.setText("Comportamiento: "+c.getCodigo()+"\nDescripcion: "+c.getDescripcion());
				
			
		}

		@Override
		public void borraComportamiento() {
			
			textArea.setText("Sin comportamiento");
			
		}

		@Override
		public void actualizarDescripcion(String descripcion) {
			
			textArea.setText("Descripcion:" +descripcion);
			
		}

	}

}
