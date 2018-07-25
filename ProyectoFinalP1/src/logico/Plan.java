package logico;

import java.io.Serializable;

public class Plan implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;
	private boolean internet;
	private boolean telefono;
	private boolean cable;
	private int cantData;
	private int cantMinutos;
	private int cantCanales;
	private float precio;
	
	public Plan(String codigo, String nombre, boolean internet, boolean telefono, boolean cable, float precio, int cantData, int cantMinutos, int cantCanales) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.internet = internet;
		this.telefono = telefono;
		this.cable =cable;
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

	public boolean getInternet() {
		return internet;
	}

	public void setInternet(boolean internet) {
		this.internet = internet;
	}

	public boolean getTelefono() {
		return telefono;
	}

	public void setTelefono(boolean telefono) {
		this.telefono = telefono;
	}

	public boolean getCable() {
		return cable;
	}

	public void setCable(boolean cable) {
		this.cable = cable;
	}

}
