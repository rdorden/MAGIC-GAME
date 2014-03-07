import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import es.lps.p6.Controlador.Controlador;
import es.lps.p6.Modelo.EscritorXML;
import es.lps.p6.Modelo.Modelo;
import es.lps.p6.Vista.PanelInicio;
import es.lps.p6.Vista.PanelTipoCarta;
import es.lps.p6.Vista.VentanaConfiguracionMazo;
import es.lps.p6.Vista.VentanaPrincipal;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Modelo m = new Modelo();
		Controlador c = new Controlador(m);
		
		
		
		PanelInicio p1 = new PanelInicio();
		
		int aux1 = JOptionPane.showConfirmDialog(null, p1, "Tipo Aplicacion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		if(aux1==JOptionPane.OK_OPTION){
			
			if(p1.nuevoMazo()){
				
				JOptionPane.showMessageDialog(null,"Elige el fichero XML donde esten las cartas");
				
				JFileChooser chooser = new JFileChooser();
				int aux = chooser.showOpenDialog(null);
				
				if(aux==JFileChooser.APPROVE_OPTION){
					
					VentanaConfiguracionMazo v1 = new VentanaConfiguracionMazo(c);
					m.aniadeOyente(v1.getOyenteModelo());
					c.empiezaMazo(chooser.getSelectedFile().getAbsolutePath());
					
					v1.setVisible(true);
				}
				
				
				
			}
			
			else{
				
				
				VentanaPrincipal v = new VentanaPrincipal(c);
				m.aniadeOyente(v.getOyenteModelo());
				
				PanelTipoCarta p = new PanelTipoCarta();
				int aux = JOptionPane.showConfirmDialog(null, p, "Tipo Carta", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				
				Modelo.leerComportamientos();
				
				if(aux==JOptionPane.OK_OPTION){
					
					c.empieza(p.tipoCarta());
					v.setVisible(true);
				}
				
				else
					System.exit(0);
			}
			
		}
		
		else
			System.exit(0);
			
		
		
	}

}
