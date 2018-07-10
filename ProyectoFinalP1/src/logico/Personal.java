package logico;

public abstract class Personal {
	private String codigo;
	private String nombre;
	protected float sueldo;
	private String usuario;
	private String contrasena;
	
	public abstract float calculoSueldo();
	
	public Personal(String codigo, String nombre, float sueldo, String usuario, String contrasena) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.usuario = usuario;
		this.contrasena = contrasena;
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
	public float getSueldo() {
		return sueldo;
	}
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
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
