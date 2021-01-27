package problema2;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author JoseAntonioVelasco
 */
public class Clase implements Serializable{

    ArrayList<Alumno> alumnos;
    String modulo;
    int curso;

    public Clase() {
        super();
    }

    public Clase(ArrayList<Alumno> alumnos, String modulo, int curso) {
        super();
        this.alumnos = alumnos;
        this.modulo = modulo;
        this.curso = curso;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }



}
