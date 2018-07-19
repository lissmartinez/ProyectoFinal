package logico;

public class Plan {
	private String codigo;
	private String nombre;
	//private String servicio;
	private int cantData;
	private int cantMinutos;
	private int cantCanales;
	private float precio;
	
	public Plan(String codigo, String nombre, float precio, int cantData, int cantMinutos, int cantCanales) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		//this.servicio = servicio;
		this.cantData = cantData;
		this.cantMinutos = cantMinutos;
		this.cantCanales = cantCanales;
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
	/*public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}*/
	public int getCantData() {
		return cantData;
	}

	public void setCantData(int cantData) {
		this.cantData = cantData;
	}

	public int getCantMinutos() {
		return cantMinutos;
	}

	public void setCantMinutos(int cantMinutos) {
		this.cantMinutos = cantMinutos;
	}

	public int getCantCanales() {
		return cantCanales;
	}

	public void setCantCanales(int cantCanales) {
		this.cantCanales = cantCanales;
	}

	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}

}
