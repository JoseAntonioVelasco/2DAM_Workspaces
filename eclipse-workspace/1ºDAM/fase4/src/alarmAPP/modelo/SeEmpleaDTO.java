package alarmAPP.modelo;
/**
 * 
 * Esta es la clase para transportar datos del tipo SeEmpleaDTO, de momento no es utilizado en el codigo en ningun momento.
 * 
 *
 */
public class SeEmpleaDTO {
	/**
	 * @version 1.0
	 * clase no usada
	 */
	private Integer codigoMaterial;
	private Integer codigoInstalacion;
	public SeEmpleaDTO(Integer codigoMaterial, Integer codigoInstalacion) {
		this.codigoMaterial = codigoMaterial;
		this.codigoInstalacion = codigoInstalacion;
	}
	public Integer getCodigoMaterial() {
		return codigoMaterial;
	}
	public void setCodigoMaterial(Integer codigoMaterial) {
		this.codigoMaterial = codigoMaterial;
	}
	public Integer getCodigoInstalacion() {
		return codigoInstalacion;
	}
	public void setCodigoInstalacion(Integer codigoInstalacion) {
		this.codigoInstalacion = codigoInstalacion;
	}
	
}
