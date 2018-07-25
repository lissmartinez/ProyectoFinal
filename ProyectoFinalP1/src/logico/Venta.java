package logico;

import java.io.Serializable;
import java.util.ArrayList;


public class Venta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private Cliente cli;
    ArrayList<Plan> planes;
	private float montoTotal;
	private float comision;
	private Comercial comerciante;
	
	public Venta(String codigo, Cliente cli, ArrayList<Plan> planes, float montoTotal, Comercial comerciante) {
		super();
		this.codigo = codigo;
		this.cli = cli;
		this.planes = planes;
		this.montoTotal = montoTotal;
		this.comision = (float) (Pago()*0.02);
		this.comerciante = comerciante;
		//this.comerciante.setComision(this.comerciante.getComision()+this.comision);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Cliente getCli() {
		return cli;
	}

	public void setCli(Cliente cli) {
		this.cli = cli;
	}

	public ArrayList<Plan> getPlanes() {
		return planes;
	}

	public void setPlanes(ArrayList<Plan> planes) {
		this.planes = planes;
	}

	public float getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}

	public float getComision() {
		return comision;
	}

	public Comercial getComerciante() {
		return comerciante;
	}

	public void setComerciante(Comercial comerciante) {
		this.comerciante = comerciante;
	}
	
	public float Pago(){
		float precioPagar=0;
		
		for (Plan plan : planes) {
			precioPagar+=plan.getPrecio();
		}
		
		return precioPagar;
	}
	

}
