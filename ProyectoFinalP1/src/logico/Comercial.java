package logico;

public class Comercial extends Personal {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	float comision;

	public float calculoSueldo() {
		float salario=0;
		salario=sueldobase+comision;
		return salario;
	}

	public Comercial(String codigo, String nombre, float sueldobase, String usuario, String contrasena, float pagoHoraExt
			) {
		super(codigo, nombre, sueldobase, usuario, contrasena, pagoHoraExt);
	
	}



	public float getComision() {
		return comision;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}

}
