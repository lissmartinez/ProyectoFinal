package logico;

public class Administrador extends Personal {
	private String cargo;

	
	public float calculoSueldo() {
		float salario = 0;
		salario=sueldobase+(pagoHoraExt*HoraExt);
		return salario;
	}



	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}





	public Administrador(String codigo, String nombre, float sueldobase, String usuario, String contrasena,
			float pagoHoraExt, int horaExt, String cargo) {
		super(codigo, nombre, sueldobase, usuario, contrasena, pagoHoraExt, horaExt);
		this.cargo = cargo;
	}

}
