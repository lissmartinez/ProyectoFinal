package logico;


import java.util.ArrayList;
import java.util.Date;

public class Factura {
	
	private boolean estado; //pendiente o pagada
	private float precioTotal;
	private String nombre;
	//ArrayList<Cliente> misclientes;
	private Date fechaEmision;
	
	ArrayList<String> misplanes;
	
	public Factura(boolean estado, float precioTotal, String nombre, ArrayList<String> misplanes) {
		super();
		this.estado = estado;
		this.precioTotal = precioTotal;
		//this.misclientes = new ArrayList<>();
		this.misplanes = new ArrayList<>();
		this.fechaEmision=new Date();
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public float getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public ArrayList<String> getMisplanes() {
		return misplanes;
	}
	public void setMisplanes(ArrayList<String> misplanes) {
		this.misplanes = misplanes;
	}
	
	
	

}
