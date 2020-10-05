package academia.modelo;

import java.util.ArrayList;

public class ProfesorDTO extends PersonaDTO{
	private String telefono;
	private String numSS;
	private CuentaDTO cuenta;
	private ArrayList<CursoDTO> cursos;
	private ArrayList<ContratoDTO> contratos;
	
	/**
	 * Constructor  de la clase ProfesorDTO
	 * @param nombre nombre del profesor
	 * @param apellido1 primer apellido del profesor
	 * @param apellido2 segundo apellido del profesor
	 * @param DNI DNI del profesor
	 * @param usuActual usuario del profesor
	 * @param matriculas 
	 * @param telefono telefono del profesor
	 * @param numSS numero de seguridad social del profesor
	 * @param cuenta datos de la cuenta bancaria del profesor
	 * @param cursos cursos que imparte el profesor
	 * @param contratos contratos del profesor
	 */
	public ProfesorDTO(String nombre, String apellido1, String apellido2, String DNI, UsuarioDTO usuActual,
			ArrayList<MatriculaDTO> matriculas,String telefono,String numSS,CuentaDTO cuenta, ArrayList<CursoDTO> cursos,
			ArrayList<ContratoDTO> contratos) {
		super(nombre, apellido1, apellido2, DNI, usuActual, matriculas);
		this.telefono=telefono;
		this.numSS=numSS;
		this.cuenta=cuenta;
		this.cursos=cursos;
		this.contratos=contratos;
		// TODO Auto-generated constructor stub
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNumSS() {
		return numSS;
	}

	public void setNumSS(String numSS) {
		this.numSS = numSS;
	}

	public CuentaDTO getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaDTO cuenta) {
		this.cuenta = cuenta;
	}

	public ArrayList<CursoDTO> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<CursoDTO> cursos) {
		this.cursos = cursos;
	}

	public ArrayList<ContratoDTO> getContratos() {
		return contratos;
	}

	public void setContratos(ArrayList<ContratoDTO> contratos) {
		this.contratos = contratos;
	}
	

}
