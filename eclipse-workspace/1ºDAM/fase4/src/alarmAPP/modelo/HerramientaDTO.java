package alarmAPP.modelo;
/**
 * Esta es la clase para transportar datos del tipo Herramienta
 * 
 *
 */
public class HerramientaDTO {
	/**
	 * @version 1.0
	 */
	private Integer codigo;
	private String herramienta;
	private Integer codInstalacion;
	
	public HerramientaDTO(Integer codigo, String herramienta, Integer codInstalacion) {
		this.codigo = codigo;
		this.herramienta = herramienta;
		this.codInstalacion = codInstalacion;
	}
	

	public HerramientaDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getHerramienta() {return herramienta;}
	public void setHerramienta(String herramienta) {this.herramienta = herramienta;}
	public Integer getCodigo() {return codigo;}
	public void setCodigo(Integer codigo) {this.codigo = codigo;}
	public Integer getCodInstalacion() {return codInstalacion;}
	public void setCodInstalacion(Integer codInstalacion) {this.codInstalacion = codInstalacion;}
	
}
