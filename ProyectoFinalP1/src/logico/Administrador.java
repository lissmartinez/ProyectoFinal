package logico;

public class Administrador extends Personal {
	private String cargo;

	@Override
	public float calculoSueldo() {
		// TODO Auto-generated method stub
		return 0;
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
