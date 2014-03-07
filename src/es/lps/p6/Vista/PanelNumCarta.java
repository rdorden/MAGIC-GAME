package es.lps.p6.Vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class PanelNumCarta extends JPanel{
	
	private JTextField textField;
	private JPanel panel;
	
	public PanelNumCarta() {
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GRAY));
		add(panel, BorderLayout.SOUTH);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
	}
	
	public void aniadeCarta(JPanel p){
		
		panel.add(p);
	}
	
	public void actualizaNum(int n){
		
		textField.setText(String.valueOf(n));
	}

}
