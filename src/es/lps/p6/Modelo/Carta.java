package es.lps.p6.Modelo;



/**
 * 
 * Clase que guarda todos los datos de una carta de juego y el tipo de carta que es.
 * En esta clase hemos creado copias superficiales y profundas pra la copia de cartas.
 *
 */

public class Carta{

	private String codigo;
	private String nombre;
	private Cloro coste;
	private int maximo;
	private Clase clase;
	private Tipo tipo;
	private String descripcion;
	private String imagen;
	private Entorno entorno;
	private Intervencion intervencion;
	private Ser ser;
	private Comportamiento comportamiento;
	
	public Carta(){
		
		maximo = 1;
		coste = new Cloro("0","0","0","0","0");
	
	}
	
	public Carta(String codigo, String nombre, Cloro coste, int max,
			Clase clase, Tipo tipo, String descripcion,
			String imagen) {
		
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.coste = coste;
		this.maximo = max;
		this.tipo = tipo;
		this.clase = clase;
		this.descripcion = descripcion;
		this.imagen = imagen;
		
		
	}

	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Cloro getCoste() {
		return coste;
	}
	
	public void setCoste(Cloro coste) {
		this.coste = coste;
	}
	
	public int getMaximo() {
		return maximo;
	}
	
	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}
	
	public Clase getClase() {
		return clase;
	}
	
	public void setClase(Clase clase) {
		this.clase = clase;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public Entorno getEntorno() {
		return entorno;
	}
	
	public void setEntorno(Entorno entorno) {
		this.entorno = entorno;
	}
	
	public Intervencion getIntervencion() {
		return intervencion;
	}
	
	public void setIntervencion(Intervencion intervencion) {
		this.intervencion = intervencion;
	}
	
	public Ser getSer() {
		return ser;
	}
	
	public void setSer(Ser ser) {
		this.ser = ser;
	}

	public Comportamiento getComportamiento() {
		return comportamiento;
	}

	public void setComportamiento(Comportamiento comportamiento) {
		this.comportamiento = comportamiento;
	}
	
	
	

}
