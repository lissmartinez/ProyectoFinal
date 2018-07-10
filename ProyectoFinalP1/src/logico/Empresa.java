package logico;


import java.util.ArrayList;



public class Empresa {
	ArrayList<Cliente> clientes;
	ArrayList<Personal> mistrabajadores;
	ArrayList<Plan> planes;
	ArrayList<Factura> misfacturas;
	private static Empresa emp;
	
	public Empresa() {
		super();
		this.clientes = new ArrayList<>();
		this.mistrabajadores = new ArrayList<>();
		this.planes = new ArrayList<>();
		this.misfacturas = new ArrayList<>();
	}
	
	public static Empresa getInstance(){
		 if( emp== null){
			 emp = new Empresa();
		 }
		 
		 return emp;
	} 


public Cliente findclientbycode (String code) {
	// TODO Auto-generated method stub
	 Cliente aux = null;
	 boolean find = false;
	 int i = 0;
	 while( i < clientes.size() && !find){
		 if(clientes.get(i).getCodigo().equalsIgnoreCase(code))
		 {
			 find = true;
			 aux = clientes.get(i);
		  }
		 i++;
		 }
	 return aux;
 }
	
public Plan findplanbycode (String code) {
	// TODO Auto-generated method stub
	 Plan aux = null;
	 boolean find = false;
	 int i = 0;
	 while( i < planes.size() && !find){
		 if(planes.get(i).getCodigo().equalsIgnoreCase(code))
		 {
			 find = true;
			 aux = planes.get(i);
		  }
		 i++;
		 }
	 return aux;
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
