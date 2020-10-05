package alarmAPP.modelo;
/**
 * 
 * Esta es la clase para transportar datos del tipo Instalacion
 *
 */
public class MaterialDTO {
	/**
	 * @version 1.0
	 */
	private Integer codigoMaterial;
	private String nombre;
	private Integer stock;
	private String tiempo_suministro;
	private String cif;
	public MaterialDTO(Integer codigoMaterial, String nombre, Integer stock, String tiempo_suministro, String cif) {
		this.codigoMaterial = codigoMaterial;
		this.nombre = nombre;
		this.stock = stock;
		this.tiempo_suministro = tiempo_suministro;
		this.cif = cif;
	}
	public MaterialDTO() {
		// TODO Auto-generated constructor stub
	}
	public Integer getCodigoMaterial() {return codigoMaterial;}
	public void setCodigoMaterial(Integer codigoMaterial) {this.codigoMaterial = codigoMaterial;}
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public Integer getStock() {return stock;}
	public void setStock(Integer stock) {this.stock = stock;}
	public String getTiempo_suministro() {return tiempo_suministro;}
	public void setTiempo_suministro(String tiempo_suministro) {this.tiempo_suministro = tiempo_suministro;}
	public String getCif() {return cif;}
	public void setCif(String cif) {this.cif = cif;}
	
	
}
