package logico;

public class Comercial extends Personal {
	float comision;

	@Override
	public float calculoSueldo() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Comercial(String codigo, String nombre, float sueldo, String usuario, String contrasena, float comision) {
		super(codigo, nombre, sueldo, usuario, contrasena);
		this.comision = comision;
	}

	public float getComision() {
		return comision;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}

}
