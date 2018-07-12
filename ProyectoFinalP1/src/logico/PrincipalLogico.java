package logico;

import java.util.ArrayList;






public class PrincipalLogico {
	
	public static void main(String[] args) {
	
			
			
		
		Plan plan1= new Plan("1", "triple play", "internet", 1500);
		ArrayList<Plan> misplanes = new ArrayList<Plan>();
		misplanes.add(plan1);
		
		Cliente cli1= new Cliente("1", "Tania", "8095700981", true, 1500, misplanes);
		ArrayList<Cliente> misclientes = new ArrayList<Cliente>();
		misclientes.add(cli1);
		
		/*Comercial cm= new Comercial("123", "Daniel Bodden", 5000, "dbodden", "dbodden", 500);
			Administrador adm=new Administrador("147", "Lissette Martinez", 15000, "lmartinez", "lmartinez", "rrhh");
		 
		 ArrayList<Personal> mistrabajadores = new ArrayList<Personal>();
		 mistrabajadores.add(cm);
		 mistrabajadores.add(adm);

		 Empresa.getInstance().setClientes(misclientes);
		 Empresa.getInstance().setMistrabajadores(mistrabajadores);
		 Empresa.getInstance().setPlanes(misplanes);
		
		 System.out.println(plan1.getNombre());
		 System.out.println(cli1.getCodigo());
		 System.out.println(cm.getSueldo());
		 System.out.println(adm.getNombre());*/
		 
		 
		 
		 
		 
		 
		
	}

}
