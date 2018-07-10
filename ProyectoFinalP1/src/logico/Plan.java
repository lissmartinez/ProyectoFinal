package logico;

public class Plan {
	private String codigo;
	private String nombre;
	private String servicio;
	private float precio;
	
	public Plan(String codigo, String nombre, String servicio, float precio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.servicio = servicio;
		this.precio = precio;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}

}
