package alarmAPP.modelo;
/**
 * 
 * Esta es la clase para transportar datos del tipo Proveedor
 *
 */
public class ProveedorDTO {
	/**
	 * @version 1.0
	 */
	private String cif;
	private String nombre;
	private String calle;
	private Integer parcela;
	private String provincia;
	private Integer cp;
	private Integer num_nave;
	
	public ProveedorDTO(String cif, String nombre, String calle, Integer parcela, String provincia, Integer cp,
			Integer num_nave) {
		this.cif = cif;
		this.nombre = nombre;
		this.calle = calle;
		this.parcela = parcela;
		this.provincia = provincia;
		this.cp = cp;
		this.num_nave = num_nave;
	}
	
	public ProveedorDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getCif() {return cif;}
	public void setCif(String cif) {this.cif = cif;}
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public String getCalle() {return calle;}
	public void setCalle(String calle) {this.calle = calle;}
	public Integer getParcela() {return parcela;}
	public void setParcela(Integer parcela) {this.parcela = parcela;}
	public String getProvincia() {return provincia;}
	public void setProvincia(String provincia) {this.provincia = provincia;}
	public Integer getCp() {return cp;}
	public void setCp(Integer cp) {this.cp = cp;}
	public Integer getNum_nave() {return num_nave;}
	public void setNum_nave(Integer num_nave) {this.num_nave = num_nave;}
	
}
