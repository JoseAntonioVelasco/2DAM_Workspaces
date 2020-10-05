package academia.modelo;

/**
 *
 * @author Raul Rubio
 */

public class UsuarioDTO 
{
    private String nombre;
    private String password;
    private int rol;
    
    public UsuarioDTO()
    {
        this.nombre="";
        this.password="";
        this.rol=0;
    }
    
    public UsuarioDTO (String nombre, String password, int rol) 
    {
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
    }


    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public int getRol() { return rol; }
    public void setRol(int rol) { this.rol = rol; }
    
}
