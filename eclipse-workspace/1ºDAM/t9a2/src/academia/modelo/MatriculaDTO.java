package academia.modelo;

public class MatriculaDTO {
	public int curso;
	public float nota;
	/**
	 * Constructor de la clase MatriculaDTO
	 * @param curso curso de la Matricula
	 * @param nota nota de la Matricula
	 */
	public MatriculaDTO(int curso, float nota) {
		this.curso = curso;
		this.nota = nota;
	}
	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	
	
}
