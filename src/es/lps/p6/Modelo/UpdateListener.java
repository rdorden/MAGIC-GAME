package es.lps.p6.Modelo;

import java.util.List;

public interface UpdateListener {


	void cambiarCodigoCarta(String codigo);

	void cambiarTipoClaseCarta(String tipo,String clase);

	void cambiarCosteCarta(Cloro coste);

	void cambiarImagenCarta(String imagen);

	void cambiarMaximoCarta(int maximo);

	void nuevoSer();

	void nuevoEntorno();

	void nuevaIntervencion();

	void cambiarCloro(Cloro cloro);

	void actualizaComportamientos(List<Comportamiento> l);

	void cambiarAtaqueDefensa(String ataque, String defensa);

	void cartaGuardada();

	void actualizarComportamientoActual(Comportamiento comportamiento);

	void borraComportamiento();

	void actualizarDescripcion(String descripcion);


}
