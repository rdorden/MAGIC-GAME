package es.lps.p6.Modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

public class EscritorFichero implements Salida{

	private FileWriter fichero;
	private PrintWriter pw;
	
	/**
	 * 
	 * @param ruta
	 */
	public EscritorFichero(String ruta){
		
		fichero = null;
		pw = null;
		
		try {
			fichero = new FileWriter(ruta);
			pw = new PrintWriter(fichero);
	
		} catch (IOException e) {
			
		}
		
		
	}
	/**
	 * 
	 */
	@Override
	public void imprimir(String s) {
		
		pw.println(s);
		
	}

	/**
	 * 
	 */
	@Override
	public void imprimirS(String s) {
		
		pw.print(s);
	}

	/**
	 * 
	 */
	@Override
	public void borrar() {
		
		for(int i=0;i<40;i++){
			pw.println("\n");
		}
		
	}
	/**
	 * 
	 */
	@Override
	public void cerrar() {
		
		try {
			fichero.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
