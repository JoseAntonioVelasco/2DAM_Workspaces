package problema2;

import java.io.Serializable;
/**
 *
 * @author JoseAntonioVelasco
 */
public class Alumno implements Serializable{

    String nombre;
    int edad;
    double notaMedia;

    public Alumno() {
        super();
    }

    public Alumno(String nombre, int edad, double notaMedia) {
        super();
        this.nombre = nombre;
        this.edad = edad;
        this.notaMedia = notaMedia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }
}
