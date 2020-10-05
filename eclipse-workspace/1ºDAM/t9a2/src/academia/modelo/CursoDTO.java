package academia.modelo;

public class CursoDTO {
	private int numero;
	private String titulo;
	private int horas;
	private float precio;
	private ProfesorDTO profesor;
	/**
	 * Constructor de la clase CursoDTO
	 * @param numero numero de curso
	 * @param titulo titulo del curso
	 * @param horas horas impartidas en el curso
	 * @param precio precio del curso
	 * @param profesor profesor que imparte el curso
	 */
	public CursoDTO(int numero, String titulo, int horas, float precio, ProfesorDTO profesor) {
		super();
		this.numero = numero;
		this.titulo = titulo;
		this.horas = horas;
		this.precio = precio;
		this.profesor = profesor;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public ProfesorDTO getProfesor() {
		return profesor;
	}
	public void setProfesor(ProfesorDTO profesor) {
		this.profesor = profesor;
	}
	
	
}
