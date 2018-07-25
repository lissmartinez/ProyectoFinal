package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;
	private String telefono;
	//private boolean estado; //cancelado o habilitado
	//private float cuentaxpagar;
	ArrayList<Plan> misplanes;
	ArrayList<Factura>  misfacturas;
	private String cedula;
	private String direccion;
	private boolean activo;
	
	

	public Cliente(String codigo, String nombre, String telefono, String cedula, String direccion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.telefono = telefono;
		this.misplanes = new ArrayList<>();
		this.misfacturas = new ArrayList<>();
		this.cedula = cedula;
		this.direccion = direccion;
		this.activo = true;
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



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public ArrayList<Plan> getMisplanes() {
		return misplanes;
	}



	public void setMisplanes(ArrayList<Plan> misplanes) {
		this.misplanes = misplanes;
	}



	public ArrayList<Factura> getMisfacturas() {
		return misfacturas;
	}



	public void setMisfacturas(ArrayList<Factura> misfacturas) {
		this.misfacturas = misfacturas;
	}



	public String getCedula() {
		return cedula;
	}



	public void setCedula(String cedula) {
		this.cedula = cedula;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public boolean isActivo() {
		return activo;
	}



	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	
	

}
