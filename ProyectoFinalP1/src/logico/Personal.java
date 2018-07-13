package logico;

public abstract class Personal {
	private String codigo;
	private String nombre;
	protected float sueldobase;
	private String usuario;
	private String contrasena;
	protected float pagoHoraExt;
	protected int HoraExt;
	
	public Personal(String codigo, String nombre, float sueldobase, String usuario, String contrasena, float pagoHoraExt,
			int horaExt) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.sueldobase = sueldobase;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.pagoHoraExt = pagoHoraExt;
		HoraExt = horaExt;
	}


	public abstract float calculoSueldo();
	
	
	public float getPagoHoraExt() {
		return pagoHoraExt;
	}


	public void setPagoHoraExt(float pagoHoraExt) {
		this.pagoHoraExt = pagoHoraExt;
	}


	public int getHoraExt() {
		return HoraExt;
	}


	public void setHoraExt(int horaExt) {
		HoraExt = horaExt;
	}


	public String getCodigo() {
		return codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getSueldobase() {
		return sueldobase;
	}
	public void setSueldobase(float sueldobase) {
		this.sueldobase = sueldobase;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}
