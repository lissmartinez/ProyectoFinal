package logico;

import java.util.ArrayList;

public class Cliente {
	private String codigo;
	private String nombre;
	private String telefono;
	//private boolean estado; //cancelado o habilitado
	//private float cuentaxpagar;
	ArrayList<Plan> misplanes;
	
	public Cliente(String nombre, String telefono, String codigo, ArrayList<Plan> misplanes) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.telefono = telefono;
	//	this.estado = estado;
	//	this.cuentaxpagar = cuentaxpagar;
		this.misplanes = new ArrayList<>();
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
	
	

}
