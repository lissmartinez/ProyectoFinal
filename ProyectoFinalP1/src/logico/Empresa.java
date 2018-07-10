package logico;


import java.util.ArrayList;



public class Empresa {
	ArrayList<Cliente> clientes;
	ArrayList<Personal> mistrabajadores;
	ArrayList<Plan> planes;
	ArrayList<Factura> misfacturas;
	private static Empresa emp;
	
	public Empresa(ArrayList<Cliente> clientes, ArrayList<Personal> mistrabajadores, ArrayList<Plan> planes,
			ArrayList<Factura> misfacturas) {
		super();
		this.clientes = new ArrayList<>();
		this.mistrabajadores = new ArrayList<>();
		this.planes = new ArrayList<>();
		this.misfacturas = new ArrayList<>();
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Personal> getMistrabajadores() {
		return mistrabajadores;
	}

	public void setMistrabajadores(ArrayList<Personal> mistrabajadores) {
		this.mistrabajadores = mistrabajadores;
	}

	public ArrayList<Plan> getPlanes() {
		return planes;
	}

	public void setPlanes(ArrayList<Plan> planes) {
		this.planes = planes;
	}

	public ArrayList<Factura> getMisfacturas() {
		return misfacturas;
	}

	public void setMisfacturas(ArrayList<Factura> misfacturas) {
		this.misfacturas = misfacturas;
	}

	public static Empresa getEmp() {
		return emp;
	}

	public static void setEmp(Empresa emp) {
		Empresa.emp = emp;
	} 

}
