package logico;

import java.util.ArrayList;

public class Factura {
	private boolean estado; //pendiente o pagada
	private float precioTotal;
	ArrayList<Cliente> misclientes;
	ArrayList<Plan> misplanes;
	public Factura(boolean estado, float precioTotal, ArrayList<Cliente> misclientes, ArrayList<Plan> misplanes) {
		super();
		this.estado = estado;
		this.precioTotal = precioTotal;
		this.misclientes = new ArrayList<>();
		this.misplanes = new ArrayList<>();
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
	public ArrayList<Cliente> getMisclientes() {
		return misclientes;
	}
	public void setMisclientes(ArrayList<Cliente> misclientes) {
		this.misclientes = misclientes;
	}
	public ArrayList<Plan> getMisplanes() {
		return misplanes;
	}
	public void setMisplanes(ArrayList<Plan> misplanes) {
		this.misplanes = misplanes;
	}
	

}
