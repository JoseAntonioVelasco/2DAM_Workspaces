
public class ComunicacionProcesos {

	public void lanzarComando(String mensaje) {
		String ruta="procesos.EjecutaComandos";
		ProcessBuilder proceso;
		try {
			System.out.println(mensaje);
			proceso = new ProcessBuilder("java",ruta);
			
			proceso.start();
			System.out.println("Fin de : "+mensaje);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ComunicacionProcesos l = new ComunicacionProcesos();
		l.lanzarComando("Prueba 1");
		l.lanzarComando("Prueba 2");
		System.out.println("Ok");

	}

}
