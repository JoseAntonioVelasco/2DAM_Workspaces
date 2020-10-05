package academia.modelo;

public class UsuarioDTO {
	private String nombre;
	private String password;
	private int rol;
	/**
	 * Constructor de la clase UsuarioDTO
	 * @param nombre nombre del usuario
	 * @param password contraseña del usuario
	 * @param rol rol del usuario(profesor,persona...)
	 */
	public UsuarioDTO(String nombre, String password, int rol) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.rol = rol;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}
	
}
