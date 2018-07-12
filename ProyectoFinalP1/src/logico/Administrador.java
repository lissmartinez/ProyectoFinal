package logico;

public class Administrador extends Personal {
	private String cargo;

	
	public float calculoSueldo() {
		float salario = 0;
		salario=sueldo+(pagoHoraExt*HoraExt);
		return salario;
	}

	
	public Administrador(String codigo, String nombre, float sueldo, String usuario, String contrasena,
			float pagoHoraExt, int horaExt) {
		super(codigo, nombre, sueldo, usuario, contrasena, pagoHoraExt, horaExt);
		// TODO Auto-generated constructor stub
	}


	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
