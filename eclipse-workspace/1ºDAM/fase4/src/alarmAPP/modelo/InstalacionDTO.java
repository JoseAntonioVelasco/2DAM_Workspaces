package alarmAPP.modelo;

import java.util.Date;
/**
 * 
 * Esta es la clase para transportar datos del tipo Instalacion
 *
 */
public class InstalacionDTO {
	/**
	 * @version 1.0
	 */
	private Integer codigo;
	private Date fecha_fin;
	private Date fecha_inicio;
	private String dueno;
	private String calle;
	private Integer num;
	private Integer cp;
	private String provincia;
	
	public InstalacionDTO(Integer codigo, Date fecha_fin,Date fecha_inicio, String dueno, String calle, Integer num, Integer cp,
			String provincia) {
		this.codigo = codigo;
		this.fecha_fin = fecha_fin;
		this.fecha_inicio=fecha_inicio;
		this.dueno = dueno;
		this.calle = calle;
		this.num = num;
		this.cp = cp;
		this.provincia = provincia;
	}
	
	public InstalacionDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getCodigo() {return codigo;}
	public void setCodigo(Integer codigo) {this.codigo = codigo;}
	public Date getFecha_fin() {return fecha_fin;}
	public void setFecha_fin(Date fecha_fin) {this.fecha_fin = fecha_fin;}
	public String getDueno() {return dueno;}
	public void setDueno(String dueno) {this.dueno = dueno;}
	public String getCalle() {return calle;}
	public void setCalle(String calle) {this.calle = calle;}
	public Integer getNum() {return num;}
	public void setNum(Integer num) {this.num = num;}
	public Integer getCp() {return cp;}
	public void setCp(Integer cp) {this.cp = cp;}
	public String getProvincia() {return provincia;}
	public void setProvincia(String provincia) {this.provincia = provincia;}
	public Date getFecha_inicio() {return fecha_inicio;}
	public void setFecha_inicio(Date fecha_inicio) {this.fecha_inicio = fecha_inicio;}
	
	
}
