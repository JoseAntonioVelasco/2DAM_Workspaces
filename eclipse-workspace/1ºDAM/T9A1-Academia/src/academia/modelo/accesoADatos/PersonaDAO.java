package academia.modelo.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import academia.modelo.MatriculaDTO;
import academia.modelo.PersonaDTO;
import academia.modelo.UsuarioDTO;

public class PersonaDAO
{

    private ArrayList <PersonaDTO> alumnos;
    private ArrayList <UsuarioDTO> usuarios;
    private PersonaDTO persona;
    private UsuarioDTO usuario;
    private String suceso;
    

    public PersonaDAO()
    {        
        alumnos = new ArrayList<PersonaDTO>();
        usuarios = new ArrayList<UsuarioDTO>();
    }


    public PersonaDTO getPersona() {return persona;}
    public void setPersona (PersonaDTO persona) {this.persona = persona;}
    public ArrayList <PersonaDTO> getAlumnos() {return alumnos;}
    public void setAlumnos (ArrayList <PersonaDTO> alumnos) {this.alumnos = alumnos;}
    public String getSuceso() {return suceso;}
    public void setSuceso(String suceso) {this.suceso = suceso;}
    public ArrayList <UsuarioDTO> getUsuarios() { return usuarios; }
    public void setUsuarios(ArrayList <UsuarioDTO> usuarios) { this.usuarios = usuarios; }
    public UsuarioDTO getUsuario() { return usuario; }
    public void setUsuario(UsuarioDTO usuario) { this.usuario = usuario; }

    public void crearPersona (PersonaDTO dto)
    {
        setSuceso(new String("La persona ha sido creada correctamente"));

        try
        {
            Conectar conn = new Conectar();
            Statement consultaprueba = conn.getConexion().createStatement();
            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Persona WHERE DNI='"+dto.getDNI()+"'");

            if(resultado.next()==false)
            {
                Statement consulta = conn.getConexion().createStatement();
                int executeUpdate = consulta.executeUpdate("INSERT INTO persona (DNI, nombre, apellido1," +
                        "apellido2) VALUES ('"+
                        dto.getDNI()+"','" + dto.getNombre()+ "','" + dto.getApellido1()+"','"+
                        dto.getApellido2()+"')");

                consulta.close();
            }

            else
                setSuceso(new String("La persona ya existe"));

            consultaprueba.close();
            conn.getConexion().close();
        }
        catch(Exception e)
        {
            setSuceso(new String("Error: "+e));
        }
    }

    public void crearUsuario(UsuarioDTO dto)
    {
        
    }
    
    public void crearMatricula(String usu, String curso, float nota)
    {
        
    }

    public void buscarPersona(PersonaDTO dto)
    {
        try
        {
            setSuceso(new String("Busqueda Correcta"));
            Conectar conn = new Conectar();
            Statement consultaprueba = conn.getConexion().createStatement();
            
            if(!dto.getDNI().equals(""))
            {
                /* DNI conocido */
                ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM persona WHERE DNI='"+dto.getDNI()+"' ORDER BY Codigo");
                setPersona(new PersonaDTO());
                if (resultado.next()==true)
                {
                    getPersona().setDNI(resultado.getString(1));
                    getPersona().setNombre(resultado.getString(2));
                    getPersona().setApellido1(resultado.getString(3));
                    getPersona().setApellido2(resultado.getString(4));
                    getAlumnos().add(getPersona());
                }
                else
                {
                    getPersona().setDNI("");
                    getPersona().setNombre("");
                    getPersona().setApellido1("");
                    getPersona().setApellido2("");
                }
                
                consultaprueba.close();
                conn.getConexion().close();
            }
            else
            {
                String DNI, nombre, apellido1, apellido2;

                if(dto.getNombre().equals(""))
                {
                    if(dto.getApellido1().equals(""))
                    {
                        if(dto.getApellido2().equals(""))
                        {
                            /*
                                DNI -> Desconocido
                                nombre -> Desconocido
                                ape1 -> Desconocido
                                ape2 -> Desocnocido
                            */
                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM persona ORDER BY DNI");
                            while (resultado.next())
                            {
                                DNI=resultado.getString(1);
                                nombre=resultado.getString(2);
                                apellido1=resultado.getString(3);
                                apellido2=resultado.getString(4);

                                setPersona(new PersonaDTO(DNI, nombre,apellido1, apellido2));
                                alumnos.add(getPersona());
                            }
                        }
                        else
                        {
                            /*
                                DNI -> Desconocido
                                nombre -> Desconocido
                                ape1 -> Desconocido
                                ape2 -> Conocido
                            */
                            
                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM persona WHERE apellido2='"+dto.getApellido2()+"' ORDER BY DNI");
                            while (resultado.next())
                            {
                                DNI=resultado.getString(1);
                                nombre=resultado.getString(2);
                                apellido1=resultado.getString(3);
                                apellido2=resultado.getString(4);

                                setPersona(new PersonaDTO(DNI, nombre,apellido1, apellido2));
                                getAlumnos().add(getPersona());
                            }
                        }
                    }
                    else
                    {
                        if(dto.getApellido2().equals(""))
                        {
                            /*
                                DNI -> Desconocido
                                nombre -> Desconocido
                                ape1 -> Conocido
                                ape2 -> Desocnocido
                            */
                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM persona WHERE apellido1='"+dto.getApellido1()+"' ORDER BY DNI");
                            while (resultado.next())
                            {
                                DNI=resultado.getString(1);
                                nombre=resultado.getString(2);
                                apellido1=resultado.getString(3);
                                apellido2=resultado.getString(4);

                                setPersona(new PersonaDTO(DNI, nombre,apellido1, apellido2));
                                alumnos.add(getPersona());
                            }
                        }
                        else
                        {
                            /*
                                DNI -> Desconocido
                                nombre -> Desconocido
                                ape1 -> Conocido
                                ape2 -> Conocido
                            */
                            
                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM persona WHERE apellido1='"+dto.getApellido1()+"' AND apellido2='"+dto.getApellido2()+"' ORDER BY DNI");
                            while (resultado.next())
                            {
                                DNI=resultado.getString(1);
                                nombre=resultado.getString(2);
                                apellido1=resultado.getString(3);
                                apellido2=resultado.getString(4);

                                setPersona(new PersonaDTO(DNI, nombre,apellido1, apellido2));
                                getAlumnos().add(getPersona());
                            }
                        }
                    }
                }
                else
                {
                    if(dto.getApellido1().equals(""))
                    {
                        if(dto.getApellido2().equals(""))
                        {
                            /*
                                DNI -> Desconocido
                                nombre -> Conocido
                                ape1 -> Desconocido
                                ape2 -> Desocnocido
                            */
                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM persona WHERE nombre='"+dto.getNombre()+"' ORDER BY DNI");
                            while (resultado.next())
                            {
                                DNI=resultado.getString(1);
                                nombre=resultado.getString(2);
                                apellido1=resultado.getString(3);
                                apellido2=resultado.getString(4);

                                setPersona(new PersonaDTO(DNI, nombre,apellido1, apellido2));
                                alumnos.add(getPersona());
                            }
                        }
                        else
                        {
                            /*
                                DNI -> Desconocido
                                nombre -> Conocido
                                ape1 -> Desconocido
                                ape2 -> Conocido
                            */
                            
                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM persona WHERE nombre='"+dto.getNombre()+"' AND apellido2='"+dto.getApellido2()+"' ORDER BY DNI");
                            while (resultado.next())
                            {
                                DNI=resultado.getString(1);
                                nombre=resultado.getString(2);
                                apellido1=resultado.getString(3);
                                apellido2=resultado.getString(4);

                                setPersona(new PersonaDTO(DNI, nombre,apellido1, apellido2));
                                getAlumnos().add(getPersona());
                            }
                        }
                    }
                    else
                    {
                        if(dto.getApellido2().equals(""))
                        {
                            /*
                                DNI -> Desconocido
                                nombre -> Conocido
                                ape1 -> Conocido
                                ape2 -> Desocnocido
                            */
                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM persona WHERE nombre='"+dto.getNombre()+"' AND apellido1='"+dto.getApellido1()+"' ORDER BY DNI");
                            while (resultado.next())
                            {
                                DNI=resultado.getString(1);
                                nombre=resultado.getString(2);
                                apellido1=resultado.getString(3);
                                apellido2=resultado.getString(4);

                                setPersona(new PersonaDTO(DNI, nombre,apellido1, apellido2));
                                alumnos.add(getPersona());
                            }
                        }
                        else
                        {
                            /*
                                DNI -> Desconocido
                                nombre -> Conocido
                                ape1 -> Conocido
                                ape2 -> Conocido
                            */
                            
                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM persona WHERE nombre='"+dto.getNombre()+"' AND apellido1='"+dto.getApellido1()+"' AND apellido2='"+dto.getApellido2()+"' ORDER BY DNI");
                            while (resultado.next())
                            {
                                DNI=resultado.getString(1);
                                nombre=resultado.getString(2);
                                apellido1=resultado.getString(3);
                                apellido2=resultado.getString(4);

                                setPersona(new PersonaDTO(DNI, nombre,apellido1, apellido2));
                                getAlumnos().add(getPersona());
                            }
                        }
                    }
                }
            
                consultaprueba.close();
                conn.getConexion().close();
            }
        }
        catch(Exception e)
        {
            setSuceso(new String("Error: "+e));
        }

    }

    public void buscarUsuarios(PersonaDTO dto)
    {
        
    }
    
    public void buscarMatriculas(PersonaDTO dto)
    {
        
    }
    
    public void modificarPersona (PersonaDTO dto)
    {
        setSuceso(new String("La persona ha sido modificada correctamente"));
        try
        {
            Conectar conn = new Conectar();
            Statement consultaprueba = conn.getConexion().createStatement();
            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Persona WHERE DNI='"+dto.getDNI()+"'");

            if (resultado.next()==true)
            {
                Statement consultaprueba2 = conn.getConexion().createStatement();
                int executeUpdate  = consultaprueba2.executeUpdate("UPDATE persona SET nombre='"+dto.getNombre()+"' WHERE DNI='"+dto.getDNI()+"'");
                executeUpdate  = consultaprueba2.executeUpdate("UPDATE Articulo SET apellido1="+dto.getApellido1()+" WHERE DNI='"+dto.getDNI()+"'");
                executeUpdate  = consultaprueba2.executeUpdate("UPDATE Articulo SET apellido2="+dto.getApellido2()+" WHERE DNI='"+dto.getDNI()+"'");

               consultaprueba2.close();
            }
            else
                setSuceso(new String("La persona no existe"));

            consultaprueba.close();
            conn.getConexion().close();
        }

        catch(Exception e)
        {
            setSuceso(new String("Error: "+e));
        }
    }
    
    public void modificarUsuario(PersonaDTO dto)
    {
        
    }
    
    public void modificarMatricula(String usu, int curso, float nota)
    {
        
    }

    public void eliminarPersona(PersonaDTO dto)
    {
        setSuceso(new String("La persona ha sido eliminada correctamente"));
        try
        {
            Conectar conn = new Conectar();
            Statement consultaprueba = conn.getConexion().createStatement();
            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Persona WHERE DNI='"+dto.getDNI()+"'");

            if(resultado.next()==true)
            {
                Statement consulta = conn.getConexion().createStatement();
                int executeUpdate = consulta.executeUpdate("DELETE FROM persona WHERE DNI='"+dto.getDNI()+"'");
                consulta.close();
            }
            else
                setSuceso(new String("La persona no existe"));

            consultaprueba.close();
            conn.getConexion().close();
        }

        catch(Exception e)
        {
            setSuceso(new String("Error: "+e));
        }
    }
    
    public void eliminarUsuario(UsuarioDTO dto)
    {
        
    }
    
    public void eliminarMatricula (String usu, int curso)
    {
        
    }

}
