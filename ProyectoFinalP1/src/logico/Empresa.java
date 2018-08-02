package logico;


import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JPasswordField;

import logico.Plan;
import logico.Cliente;



public class Empresa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Cliente> clientes;
	private ArrayList<Personal> mistrabajadores;
	private ArrayList<Plan> planes;
	private ArrayList<Factura> misfacturas;
	private ArrayList<Venta> misventas;
	private static Empresa emp;
	private static Personal loginUser;
	private static boolean firstTime;
	
	
	public Empresa() {
		super();
		this.clientes = new ArrayList<>();
		this.mistrabajadores = new ArrayList<>();
		this.planes = new ArrayList<>();
		this.misfacturas = new ArrayList<>();
		this.misventas = new ArrayList<>();

	}
	
	public static Empresa getInstance(){
		 if( emp== null){
			 emp = new Empresa();
		 }
		 
		 return emp;
	} 
	
	public void insertCliente(Cliente aux){
		clientes.add(aux);
	}
	public void insertPlan(Plan aux){
		planes.add(aux);
	}



public Cliente findclientbycode(String code) {
	// TODO Auto-generated method stub
	 Cliente aux = null;
	 boolean find = false;
	 int i = 0;
	 while( i < clientes.size() && !find){
		 if(clientes.get(i).getCodigo().equalsIgnoreCase(code))
		 {
			 aux = clientes.get(i);
			 find = true;
			 
		  }
		 i++;
		 }
	 return aux;
 }

public Cliente findclientbycedula(String cedula) {
	// TODO Auto-generated method stub
	 Cliente aux = null;
	 boolean find = false;
	 int i = 0;
	 while( i < clientes.size() && !find){
		 if(clientes.get(i).getCedula().equalsIgnoreCase(cedula))
		 {
			 aux = clientes.get(i);
			 find = true;
			 
		  }
		 i++;
		 }
	 return aux;
 }

public Personal findpersonalbycode (String code) {
	// TODO Auto-generated method stub
	 Personal aux = null;
	 boolean find = false;
	 int i = 0;
	 while( i < mistrabajadores.size() && !find){
		 if(mistrabajadores.get(i).getCodigo().equalsIgnoreCase(code))
		 {
			 find = true;
			 aux = mistrabajadores.get(i);
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
	
public void insertpersonal(Personal personal) {
	// TODO Auto-generated method stub
	mistrabajadores.add(personal);
	
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
	public ArrayList<Venta> getMisventas() {
		return misventas;
	}

	public void setMisventas(ArrayList<Venta> misventas) {
		this.misventas = misventas;
	}

	public static Empresa getEmp() {
		return emp;
	}

	public static void setEmp(Empresa emp) {
		Empresa.emp = emp;
	}
	


	public static Personal getLoginUser() {
		return loginUser;
	}

	public static void setLoginUser(Personal loginUser) {
		Empresa.loginUser = loginUser;
	}

	public static boolean isFirstTime() {
		return firstTime;
	}

	public static void setFirstTime(boolean firstTime) {
		Empresa.firstTime = firstTime;
	}

	public int getCantClienteActivos() {
		int cant = 0;
		for (Cliente cliente : clientes) {
			if(cliente.isActivo()){
				cant++;
			}
		}
		return cant;
	}

	public void updatePersonal(Personal aux1) {
		int index = 0;
		int i=0;
		boolean find = false;
		while (!find && i<mistrabajadores.size()) {
			if(mistrabajadores.get(i).getCodigo().equalsIgnoreCase(aux1.getCodigo())){
				find = true;
				index = i;
			}
		}
		mistrabajadores.set(index,aux1);
	} 
	
	

	public void updateclient(Cliente aux1) {
		int index = 0;
		int i=0;
		boolean find = false;
		while (!find && i<clientes.size()) {
			if(clientes.get(i).getCodigo().equalsIgnoreCase(aux1.getCodigo())){
				find = true;
				index = i;
			}
		}
		clientes.set(index,aux1);
	}
	public boolean confirmLogin(String text, JPasswordField passwordField) {
		boolean login = false;
		for (Personal personal : mistrabajadores) {
			if(personal.getUsuario().equals(text)){
				loginUser = personal;
				login = true;
			}
		}
		return login;
	}
	

	public void updatePlan(Plan plan) {
		int index = 0;
		int i=0;
		boolean find = false;
		while (!find && i<planes.size()) {
			if(planes.get(i).getCodigo().equalsIgnoreCase(plan.getCodigo())){
				find = true;
				index = i;
			}
		}
		planes.set(index,plan);
	}

	public void sorting() {
		
		
	}

}
