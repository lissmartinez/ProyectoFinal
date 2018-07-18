package logico;

public class Administrador extends Personal {
	private String cargo;

	
	public float calculoSueldo() {
		float salario = 0;
		salario=sueldobase;
		return salario;
	}



	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}





	public Administrador(String codigo, String nombre, float sueldobase, String usuario, char[] contrasena,
			float pagoHoraExt, String cargo) {
		super(codigo, nombre, sueldobase, usuario, contrasena, pagoHoraExt);
		this.cargo = cargo;
	}

}
