package academia.modelo;

public class ContratoDTO {
	private int numero;
	private String finicio;
	private String ffin;
	private String tipo;
	private String descripcion;
	/**
	 * Constructor de la clase ContratoDTO
	 * 
	 * @param numero numero de contrato
	 * @param finicio fecha de inicio del contrato
	 * @param ffin fecha fin del contrato
	 * @param tipo tipo de contrato
	 * @param descripcion descripcion del contrato
	 */
	public ContratoDTO(int numero, String finicio, String ffin, String tipo, String descripcion) {
		this.numero = numero;
		this.finicio = finicio;
		this.ffin = ffin;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getFinicio() {
		return finicio;
	}

	public void setFinicio(String finicio) {
		this.finicio = finicio;
	}

	public String getFfin() {
		return ffin;
	}

	public void setFfin(String ffin) {
		this.ffin = ffin;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
