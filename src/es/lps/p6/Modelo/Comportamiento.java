package es.lps.p6.Modelo;

public class Comportamiento {
	
	private int id;
	private String codigo;
	private String descripcion;
	private String nombre;
	
	private String variable1;
	private String variable2;
	private String variable3;
	
	public Comportamiento(String s){
		
		id = 1;
		codigo = s;
		descripcion = "Sin comportamiento";
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getVariable1() {
		return variable1;
	}

	public void setVariable1(String variable1) {
		this.variable1 = variable1;
	}

	public String getVariable2() {
		return variable2;
	}

	public void setVariable2(String variable2) {
		this.variable2 = variable2;
	}

	public String getVariable3() {
		return variable3;
	}

	public void setVariable3(String variable3) {
		this.variable3 = variable3;
	}

	
	
}
