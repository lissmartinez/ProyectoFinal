package logico;

import java.util.ArrayList;






public class PrincipalLogico {
	
	public static void main(String[] args) {
	
	
		/*	
		
		Plan plan1= new Plan("1", "triple play", "internet", 1500);
		ArrayList<Plan> misplanes = new ArrayList<Plan>();
		misplanes.add(plan1);
		
		Cliente cli1= new Cliente("1", "Tania", "8095700981", true, 1500, misplanes);
		ArrayList<Cliente> misclientes = new ArrayList<Cliente>();
		misclientes.add(cli1);
		
		Comercial cm= new Comercial("1", "Daniel bodden", 15000, "dbodden", "dbodden", 100, 2);
		Administrador adm= new Administrador("1", "Lissette Martinez", 20000, "lmartinez", "lmartinez", 200, 2, "rrhh");
		 
		 ArrayList<Personal> mistrabajadores = new ArrayList<Personal>();
		 mistrabajadores.add(cm);
		 mistrabajadores.add(adm);
		 
		 Venta v1= new Venta("1", cli1, misplanes, 1000, cm);
		 Venta v2= new Venta("2", cli1, misplanes, 3200, cm);
		 ArrayList<Venta> misventas = new ArrayList<Venta>();
		 misventas.add(v1);
		 misventas.add(v2);

		 Empresa.getInstance().setClientes(misclientes);
		 Empresa.getInstance().setMistrabajadores(mistrabajadores);
		 Empresa.getInstance().setPlanes(misplanes);
		 Empresa.getInstance().setMisventas(misventas);
		
		 System.out.println(plan1.getNombre());
		 System.out.println(cli1.getCodigo());
		 System.out.println(cm.calculoSueldo());
		 System.out.println(adm.calculoSueldo());
		 System.out.println(adm.getNombre());
		 System.out.println(cm.getComision());
		 
		 
		 
		 
		 
		 
		
	}
/*
 * 
 */
}}
