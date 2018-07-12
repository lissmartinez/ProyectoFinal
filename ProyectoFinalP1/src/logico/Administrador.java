package logico;

public class Administrador extends Personal {
	private String cargo;

	
	public float calculoSueldo() {
		float salario = 0;
		salario=sueldo;
		return salario;
	}

	public Administrador(String codigo, String nombre, float sueldo, String usuario, String contrasena, String cargo) {
		super(codigo, nombre, sueldo, usuario, contrasena);
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
