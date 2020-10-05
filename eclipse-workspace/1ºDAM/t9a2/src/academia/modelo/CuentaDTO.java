package academia.modelo;

public class CuentaDTO {
	private String entidad;
	private String oficina;
	private String control;
	private String numero;
	/**
	 * Constructor de la clase Cuenta
	 * 
	 * @param entidad entidad bancaria a la que corresponde el numero de cuenta
	 * @param oficina oficina bancaria a la que corresponde el numero de cuenta
	 * @param control digito de control del numero de cuenta bancaria
	 * @param numero numero de cuenta propiamente
	 */
	public CuentaDTO(String entidad, String oficina, String control, String numero) {
		super();
		this.entidad = entidad;
		this.oficina = oficina;
		this.control = control;
		this.numero = numero;
	}
	public String getEntidad() {
		return entidad;
	}
	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}
	public String getOficina() {
		return oficina;
	}
	public void setOficina(String oficina) {
		this.oficina = oficina;
	}
	public String getControl() {
		return control;
	}
	public void setControl(String control) {
		this.control = control;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
