package logico;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Factura implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private boolean estado; //pendiente o pagada
	private float precioTotal;
	private String nombre;
	private Date fechaEmision;
	
	ArrayList<Plan> misplanes;
	
	public Factura(String codigo,boolean estado, float precioTotal, String nombre, ArrayList<Plan> misplanes) {
		super();
		this.codigo = codigo;
		this.estado = estado;
		this.precioTotal = precioTotal;
		this.misplanes = new ArrayList<>();
		this.fechaEmision=new Date();
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	public ArrayList<Plan> getMisplanes() {
		return misplanes;
	}
	public void setMisplanes(ArrayList<Plan> misplanes) {
		this.misplanes = misplanes;
	}
	
	
	

}
