package es.lps.p6.Vista;

import java.util.List;

import es.lps.p6.Modelo.Carta;

public interface UpdateListener2 {

	void actualizarPanel(List<Carta> listaCartas);

	void cambiaNumCarta(int pos, Integer integer);

	
}
