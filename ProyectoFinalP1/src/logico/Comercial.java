package logico;

public class Comercial extends Personal {
	float comision;

	public float calculoSueldo() {
		float salario=0;
		salario=sueldobase+comision+(pagoHoraExt*HoraExt);
		return salario;
	}

	public Comercial(String codigo, String nombre, float sueldobase, String usuario, String contrasena, float pagoHoraExt,
			int horaExt) {
		super(codigo, nombre, sueldobase, usuario, contrasena, pagoHoraExt, horaExt);
	
	}



	public float getComision() {
		return comision;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}

	/*public float comision(float a) {
		float comision=0;
		comision=(float) (0.1*a);
		return comision;
	}*/


}
