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


	public Comercial(String codigo, String nombre, float sueldobase, String usuario, String contrasena,
			float pagoHoraExt) {
		super(codigo, nombre, sueldobase, usuario, contrasena, pagoHoraExt, ventas);
		this.comision = comision;
		ventas=0;
	}


	public float getComision() {
		return comision;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}


	@Override
	public int compareTo(Personal o) {
	 if(o.getVentas()>ventas){
		            return -1;
		        }else if(o.getVentas()>ventas){
		            return 0;
		        }else{
		            return 1;
		        }
	}


}
