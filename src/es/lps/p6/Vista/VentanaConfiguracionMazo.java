package es.lps.p6.Vista;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ScrollPaneConstants;

import es.lps.p6.Controlador.AccionNoPermitidaException;
import es.lps.p6.Controlador.Controlador;
import es.lps.p6.Modelo.Carta;
import es.lps.p6.Modelo.Entorno;
import es.lps.p6.Modelo.Tipo;
import es.lps.p6.Modelo.UpdateListener;

import java.util.ArrayList;
import java.util.List;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;

public class VentanaConfiguracionMazo extends JFrame{
	
	
	JPanel panel;
	Controlador c;
	List<OyenteCarta> oyentes;
	private UpdateListener2 oyenteModelo;
	private List<PanelNumCarta> listaCartas;
	
	public VentanaConfiguracionMazo(Controlador c) {
		
		oyenteModelo = new OyenteModelo();
		listaCartas = new ArrayList<PanelNumCarta>();
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		panel = new JPanel();
		
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 4));
		this.c = c;
		
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("Opciones");
		JMenuItem i = new JMenuItem("Guardar");	
		i.setName("Guardar");
		i.addActionListener(new OyenteMenu());
		menu.add(i);	
		i = new JMenuItem("Salir");
		i.setName("Salir");
		i.addActionListener(new OyenteMenu());
		menu.add(i);
		bar.add(menu);
		//setJMenuBar(bar);	
		
		JMenu menu2 = new JMenu("¿Como funciona?");
		bar.add(menu2);
		setJMenuBar(bar);
		JMenuItem j = new JMenuItem("Ayuda");
		j.addActionListener(new OyenteMenu());
		j.setName("Ayuda");
		menu2.add(j);
			
		setSize(1000,800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	private void rellenarCartas(List<Carta> l){
		
		
		int i = 0;
		
		for(Carta c:l){
			
			PanelNumCarta num = new PanelNumCarta();
			
			OyenteCarta o = new OyenteCarta(i);
			
			if(c.getTipo().equals(Tipo.SER)){
				
				PanelSer2 ser = new PanelSer2(c);
				ser.aniadeOyente(o);
				
				num.add(ser);			
				
				
				
			}
			
			if(c.getTipo().equals(Tipo.ENTORNO)){
				
				PanelEntorno entorno = new PanelEntorno(c);
				entorno.aniadeOyente(o);

				num.add(entorno);

			}
			if(c.getTipo().equals(Tipo.INTERVENCION)){
	
				PanelIntervencion intervencion = new PanelIntervencion(c);
				intervencion.aniadeOyente(o);
				num.add(intervencion);
				
			}
			
			JPanel aux = new JPanel(new FlowLayout(FlowLayout.CENTER));
			aux.add(num);
			panel.add(aux);
			listaCartas.add(num);			
			num.actualizaNum(0);
			
			i++;
		}
		
	
		
	}
	
	class OyenteCarta extends MouseAdapter{
		
		int pos;
		
		public OyenteCarta(int i){
			
			pos = i;
		}
		
		
		@Override
		public void mouseClicked(MouseEvent e){
			
			
				
				
					try {
						if(e.getButton()==MouseEvent.BUTTON1)
							c.aumentaNumCarta(pos);
						else
							c.restaNumCarta(pos);
						
					} catch (AccionNoPermitidaException e1) {
						
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}

		}
	}
	
	

	public UpdateListener2 getOyenteModelo() {
		
		return oyenteModelo;
	}
	
	
	class OyenteMenu implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JMenuItem i = (JMenuItem)e.getSource();
			
			if(i.getName().equalsIgnoreCase("Salir"))
				System.exit(0);
			
			else if(i.getName().equalsIgnoreCase("Guardar")){
				
				
				CajaTexto caja = new CajaTexto();
				JOptionPane.showMessageDialog(null,caja,"Introduce tu nombre",JOptionPane.PLAIN_MESSAGE);
				
				String nombre = caja.getTexto();
				
				caja = new CajaTexto();
				JOptionPane.showMessageDialog(null,caja,"Introduce tu lema",JOptionPane.PLAIN_MESSAGE);
				
				String lema = caja.getTexto();
				
				JFileChooser chooser = new JFileChooser();
				int aux = chooser.showOpenDialog(null);
				
				if(aux==JFileChooser.APPROVE_OPTION){
					
					c.guarda(chooser.getSelectedFile().getAbsolutePath(),nombre,lema);
				}
				
			}
			
			if(i.getName().equalsIgnoreCase("Ayuda")){
				  
				JOptionPane.showMessageDialog(null," Hola!!!\n Bienvenido a nuestro editor de cartas y mazos.\n Esta es " +
						"la ventana de edicion de mazos.\n Recuerda que el xml y el dtd tienen que estar en el mismo directorio.\n Para coger/añadir una " +
						"carta se hace con el boton primario del raton. \n Para quitarla utilizad el boton secundario" +
						" del raton ","ESPECIFICACIONES:",JOptionPane.INFORMATION_MESSAGE);
				  

				    }
	
			
		}
		
		
	}
	class OyenteModelo implements UpdateListener2{

		@Override
		public void actualizarPanel(List<Carta> listaCartas) {
			
			rellenarCartas(listaCartas);
			
		}

		@Override
		public void cambiaNumCarta(int pos, Integer n) {
			
			listaCartas.get(pos).actualizaNum(n);
			
		}
		
		
	}
}
