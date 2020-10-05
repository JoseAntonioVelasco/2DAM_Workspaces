package alarmAPP.modelo.accesoADatos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


import alarmAPP.modelo.InstalacionDTO;
/**
 * 
 * Esta es la clase que se utiliza para manipular datos relacionados con las instalaciones en la base de datos
 *
 */
public class InstalacionDAO {
	private ArrayList<InstalacionDTO> instalaciones;
	private InstalacionDTO instalacion;
	private String suceso;
	public InstalacionDAO() {
		instalaciones=new ArrayList<InstalacionDTO>();
	}
	public ArrayList<InstalacionDTO> getInstalaciones() {return instalaciones;}
	public void setInstalaciones(ArrayList<InstalacionDTO> instalaciones) {this.instalaciones = instalaciones;}
	public InstalacionDTO getInstalacion() {return instalacion;}
	public void setInstalacion(InstalacionDTO instalacion) {this.instalacion = instalacion;}
	public String getSuceso() {return suceso;}
	public void setSuceso(String suceso) {this.suceso = suceso;}
	
	//crear
	/**
	 * Sirve para anadir una instalacion a la bbdd
	 * @param instalacion le pasamos por parametro la instalacion que queremos anadir a la bbdd
	 */
	public void crearInstalacion(InstalacionDTO instalacion) {
		setSuceso(new String("La Instalacion ha sido creada correctamente"));
		try{
				
	            Conectar conn = new Conectar();
	            Statement consultaprueba = conn.getConnect().createStatement();
	            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Instalacion WHERE codigo='"+instalacion.getCodigo()+"'");
	            if(resultado.next()==false)
	            {
	                Statement consulta = conn.getConnect().createStatement();
	                int executeUpdate = consulta.executeUpdate("INSERT INTO Instalacion (codigo, Fecha_Fin, Fecha_Inicio,dueno,calle,num,CP,Provincia)"+"VALUES ('"+
	                        instalacion.getCodigo()+"','" + instalacion.getFecha_fin()+ "','" + instalacion.getFecha_inicio()+"','"+
	                        instalacion.getDueno()+"','" +instalacion.getCalle()+"','"+instalacion.getNum()+"','"+instalacion.getCp()+"','"+instalacion.getProvincia()+"')");

	                consulta.close();
	            }
	            else {
	            	setSuceso(new String("La Instalacion ya existe"));
	            }
	            consultaprueba.close();
	            conn.getConnect().close();
	       }catch(Exception e) {
	    	   setSuceso(new String("Error: "+e));
	       }
	
       
	}
	//crear
	/**
	 * Si queremos utilizar materiales en la instalacion los relacionamos con la tabla materiales mediante este metodo
	 * @param codigoMaterial codigo del material a usar en nuestra instalacion
	 * @param codigoInstalacion codigo de la instalacion en la que vamos a usar ese material
	 */
	public void crearSeEmplea(Integer codigoMaterial, Integer codigoInstalacion) {
		setSuceso(new String("Se ha anadido ese material a esta instalacion correctamente"));
		try {
			Conectar conn = new Conectar();
			Statement consultaprueba = conn.getConnect().createStatement();
			ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM seEmplea WHERE codigoMaterial='"+codigoMaterial+"' and codigoInstalacion='"+codigoInstalacion+"'");
			if(resultado.next()==false)
			{
				Statement consulta = conn.getConnect().createStatement();
				int executeUpdate = consulta.executeUpdate("INSERT INTO seEmplea (codigoMaterial,codigoInstalacion)"+"VALUES ('"+codigoMaterial+"','"+codigoInstalacion+"'");
				consulta.close();
			}
			else {
				setSuceso(new String("El seEmplea ya existe"));
			}
			consultaprueba.close();
			conn.getConnect().close();
			}catch(Exception e) {
			setSuceso(new String("Error: "+e));
		}
	}
	//modificar
	/**
	 * Si queremeos modificar instalaciones ya presentes en la bbdd
	 * @param instalacion le pasamos por parametro la instalacion que queremos modificar
	 */
	public void modificarInstalacion(InstalacionDTO instalacion) {
		setSuceso(new String("La Instalacion ha sido modificada correctamente"));
        try
        {
            Conectar conn = new Conectar();
            Statement consultaprueba = conn.getConnect().createStatement();
            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Instalacion WHERE codigo='"+instalacion.getCodigo()+"'");

            if (resultado.next()==true)
            {
                Statement consultaprueba2 = conn.getConnect().createStatement();
                int executeUpdate  = consultaprueba2.executeUpdate("UPDATE Instalacion SET Fecha_Fin='"+instalacion.getFecha_fin()+"' WHERE codigo='"+instalacion.getCodigo()+"'");
                executeUpdate  = consultaprueba2.executeUpdate("UPDATE Instalacion SET Fecha_Inicio="+instalacion.getFecha_inicio()+" WHERE codigo='"+instalacion.getCodigo()+"'");
                executeUpdate  = consultaprueba2.executeUpdate("UPDATE Instalacion SET dueno="+instalacion.getDueno()+" WHERE codigo='"+instalacion.getCodigo()+"'");
                executeUpdate  = consultaprueba2.executeUpdate("UPDATE Instalacion SET calle="+instalacion.getCalle()+" WHERE codigo='"+instalacion.getCodigo()+"'");
                executeUpdate  = consultaprueba2.executeUpdate("UPDATE Instalacion SET num="+instalacion.getNum()+" WHERE codigo='"+instalacion.getCodigo()+"'");
                executeUpdate  = consultaprueba2.executeUpdate("UPDATE Instalacion SET CP="+instalacion.getCp()+" WHERE codigo='"+instalacion.getCodigo()+"'");
                executeUpdate  = consultaprueba2.executeUpdate("UPDATE Instalacion SET Provincia="+instalacion.getProvincia()+" WHERE codigo='"+instalacion.getCodigo()+"'");
                consultaprueba2.close();
            }
            else
                setSuceso(new String("La Instalacion no existe"));

            consultaprueba.close();
            conn.getConnect().close();
        }

        catch(Exception e)
        {
            setSuceso(new String("Error: "+e));
        }
	}
	//eliminar
	/**
	 * Sirve para eliminar instalaciones guardadas en la bbdd
	 * @param instalacion le pasamos por parametro la instalacion que queremos eliminar
	 */
	public void eliminarInstalacion(InstalacionDTO instalacion) {
		 setSuceso(new String("La Instalacion ha sido eliminada correctamente"));
	        try
	        {
	            Conectar conn = new Conectar();
	            Statement consultaprueba = conn.getConnect().createStatement();
	            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Instalacion WHERE codigo='"+instalacion.getCodigo()+"'");

	            if(resultado.next()==true)
	            {
	                Statement consulta = conn.getConnect().createStatement();
	                int executeUpdate = consulta.executeUpdate("DELETE FROM Instalacion WHERE codigo='"+instalacion.getCodigo()+"'");
	                consulta.close();
	            }
	            else
	                setSuceso(new String("La Instalacion no existe"));

	            consultaprueba.close();
	            conn.getConnect().close();
	        }

	        catch(Exception e)
	        {
	            setSuceso(new String("Error: "+e));
	        }
	}
	//buscar
	/**
	 * Sirve para buscar instalaciones en la base de datos
	 * podemos buscar por codigo,fecha de inicio,dueno y direccion completa
	 * @param instalacion le pasamos por parametro la instalacion/es que queremos buscar
	 */
	public void buscarInstalacion(InstalacionDTO instalacion) {
		try
        {
            setSuceso(new String("Busqueda Correcta"));
            Conectar conn = new Conectar();
            Statement consultaprueba = conn.getConnect().createStatement();
            
            if(!instalacion.getCodigo().equals(null))
            {
                //codigo -> conocido
                 
                ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Instalacion WHERE codigo='"+instalacion.getCodigo()+"' ORDER BY codigo");
                setInstalacion(new InstalacionDTO());
                if (resultado.next()==true)
                {
                    getInstalacion().setCodigo(resultado.getInt(1));
                    getInstalacion().setFecha_fin(resultado.getDate(2));
                    getInstalacion().setFecha_inicio(resultado.getDate(3));
                    getInstalacion().setDueno(resultado.getString(4));
                    getInstalacion().setCalle(resultado.getString(5));
                    getInstalacion().setNum(resultado.getInt(6));
                    getInstalacion().setCp(resultado.getInt(7));
                    getInstalacion().setProvincia(resultado.getString(8));
                    getInstalaciones().add(getInstalacion());
                }
                else
                {
                	getInstalacion().setCodigo(null);
                    getInstalacion().setFecha_fin(null);
                    getInstalacion().setFecha_inicio(null);
                    getInstalacion().setDueno(null);
                    getInstalacion().setCalle(null);
                    getInstalacion().setNum(null);
                    getInstalacion().setCp(null);
                    getInstalacion().setProvincia(null);
                }
                
                consultaprueba.close();
                conn.getConnect().close();
            }
            else
            {
                String dueno,calle, provincia;
                Integer codigo,num,cp;
                Date fecha_inicio,fecha_fin;

                if(instalacion.getFecha_inicio().equals(null))
                {
                    if(instalacion.getDueno().equals(null))
                    {
                        if(instalacion.getCalle().equals(null)||instalacion.getCp().equals(null)||instalacion.getNum().equals(null))
                        {
                            /*
                                codigo -> Desconocido
                                fecha_inicio -> Desconocido
                                dueno -> Desconocido
                                direccion -> Desocnocido
                            */
                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Instalacion ORDER BY codigo");
                            while (resultado.next())
                            {
                            	codigo=resultado.getInt(1);
                                fecha_fin=resultado.getDate(2);
                                fecha_inicio=resultado.getDate(3);
                                dueno=resultado.getString(4);
                                calle=resultado.getString(5);
                                num=resultado.getInt(6);
                                cp=resultado.getInt(7);
                                provincia=resultado.getString(8);
                                
                                setInstalacion(new InstalacionDTO(codigo,fecha_fin,fecha_inicio,dueno,calle,num,cp,provincia));
                                getInstalaciones().add(getInstalacion());
                            }
                        }
                        else
                        {
                            /*
                                codigo -> Desconocido
                                fecha_inicio -> Desconocido
                                dueno -> Desconocido
                                direccion -> Conocido
                            */
                            
                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Instalacion WHERE cp='"+instalacion.getCp()+"' and calle='"+instalacion.getCalle()+"' and num='"+instalacion.getNum()+"' ORDER BY codigo");
                            while (resultado.next())
                            {
                            	codigo=resultado.getInt(1);
                                fecha_fin=resultado.getDate(2);
                                fecha_inicio=resultado.getDate(3);
                                dueno=resultado.getString(4);
                                calle=resultado.getString(5);
                                num=resultado.getInt(6);
                                cp=resultado.getInt(7);
                                provincia=resultado.getString(8);
                                
                                setInstalacion(new InstalacionDTO(codigo,fecha_fin,fecha_inicio,dueno,calle,num,cp,provincia));
                                getInstalaciones().add(getInstalacion());
                            }
                        }
                    }
                    else
                    {
                        if(instalacion.getCalle().equals(null)||instalacion.getCp().equals(null)||instalacion.getNum().equals(null))
                        {
                            /*
                                codigo -> Desconocido
                                fecha_inicio -> Desconocido
                                dueno -> Conocido
                                direccion -> Desocnocido
                            */
                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Instalacion WHERE dueno='"+instalacion.getDueno()+"' ORDER BY codigo");
                            while (resultado.next())
                            {
                            	codigo=resultado.getInt(1);
                                fecha_fin=resultado.getDate(2);
                                fecha_inicio=resultado.getDate(3);
                                dueno=resultado.getString(4);
                                calle=resultado.getString(5);
                                num=resultado.getInt(6);
                                cp=resultado.getInt(7);
                                provincia=resultado.getString(8);
                                
                                setInstalacion(new InstalacionDTO(codigo,fecha_fin,fecha_inicio,dueno,calle,num,cp,provincia));
                                getInstalaciones().add(getInstalacion());
                                
                            }
                        }
                        else
                        {
                            /*
                                codigo -> Desconocido
                                fecha_inicio -> Desconocido
                                dueno -> Conocido
                                direccion -> Conocido
                            */
                            
                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Instalacion WHERE dueno='"+instalacion.getDueno()+"' and cp='"+instalacion.getCp()+"' and calle='"+instalacion.getCalle()+"' and num='"+instalacion.getNum()+"' ORDER BY codigo");
                            while (resultado.next())
                            {
                            	codigo=resultado.getInt(1);
                                fecha_fin=resultado.getDate(2);
                                fecha_inicio=resultado.getDate(3);
                                dueno=resultado.getString(4);
                                calle=resultado.getString(5);
                                num=resultado.getInt(6);
                                cp=resultado.getInt(7);
                                provincia=resultado.getString(8);
                                
                                setInstalacion(new InstalacionDTO(codigo,fecha_fin,fecha_inicio,dueno,calle,num,cp,provincia));
                                getInstalaciones().add(getInstalacion());
                            }
                        }
                    }
                }
                else
                {
                    if(instalacion.getDueno().equals(null))
                    {
                        if(instalacion.getCalle().equals(null)||instalacion.getCp().equals(null)||instalacion.getNum().equals(null))
                        {
                            /*
                                codigo -> Desconocido
                                fecha_inicio -> Conocido
                                dueno -> Desconocido
                                direccion -> Desocnocido
                            */
                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Instalacion WHERE Fecha_Inicio='"+instalacion.getFecha_inicio()+"' ORDER BY codigo");
                            while (resultado.next())
                            {
                            	codigo=resultado.getInt(1);
                                fecha_fin=resultado.getDate(2);
                                fecha_inicio=resultado.getDate(3);
                                dueno=resultado.getString(4);
                                calle=resultado.getString(5);
                                num=resultado.getInt(6);
                                cp=resultado.getInt(7);
                                provincia=resultado.getString(8);
                                
                                setInstalacion(new InstalacionDTO(codigo,fecha_fin,fecha_inicio,dueno,calle,num,cp,provincia));
                                getInstalaciones().add(getInstalacion());
                            }
                        }
                        else
                        {
                            /*
                                codigo -> Desconocido
                                fecha_inicio -> Conocido
                                dueno -> Desconocido
                                direccion -> Conocido
                            */
                            
                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Instalacion WHERE Fecha_Inicio='"+instalacion.getFecha_inicio()+"'and cp='"+instalacion.getCp()+"' and calle='"+instalacion.getCalle()+"' and num='"+instalacion.getNum()+"' ORDER BY codigo");
                            while (resultado.next())
                            {
                            	codigo=resultado.getInt(1);
                                fecha_fin=resultado.getDate(2);
                                fecha_inicio=resultado.getDate(3);
                                dueno=resultado.getString(4);
                                calle=resultado.getString(5);
                                num=resultado.getInt(6);
                                cp=resultado.getInt(7);
                                provincia=resultado.getString(8);
                                
                                setInstalacion(new InstalacionDTO(codigo,fecha_fin,fecha_inicio,dueno,calle,num,cp,provincia));
                                getInstalaciones().add(getInstalacion());
                            }
                        }
                    }
                    else
                    {
                        if(instalacion.getCalle().equals(null)||instalacion.getCp().equals(null)||instalacion.getNum().equals(null))
                        {
                            /*
                                codigo -> Desconocido
                                fecha_inicio -> Conocido
                                dueno -> Conocido
                                direccion -> Desocnocido
                            */
                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Instalacion WHERE Fecha_inicio='"+instalacion.getFecha_inicio()+"' AND dueno='"+instalacion.getDueno()+"' ORDER BY codigo");
                            while (resultado.next())
                            {
                            	codigo=resultado.getInt(1);
                                fecha_fin=resultado.getDate(2);
                                fecha_inicio=resultado.getDate(3);
                                dueno=resultado.getString(4);
                                calle=resultado.getString(5);
                                num=resultado.getInt(6);
                                cp=resultado.getInt(7);
                                provincia=resultado.getString(8);
                                
                                setInstalacion(new InstalacionDTO(codigo,fecha_fin,fecha_inicio,dueno,calle,num,cp,provincia));
                                getInstalaciones().add(getInstalacion());
                            }
                        }
                        else
                        {
                            /*
                                codigo -> Desconocido
                                fecha_inicio -> Conocido
                                dueno -> Conocido
                                direccion -> Conocido
                            */
                            
                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Instalacion WHERE dueno='"+instalacion.getDueno()+"' AND Fecha_inicio='"+instalacion.getFecha_inicio()+"' AND cp='"+instalacion.getCp()+"' and calle='"+instalacion.getCalle()+"' and num='"+instalacion.getNum()+"' ORDER BY codigo");
                            while (resultado.next())
                            {
                            	codigo=resultado.getInt(1);
                                fecha_fin=resultado.getDate(2);
                                fecha_inicio=resultado.getDate(3);
                                dueno=resultado.getString(4);
                                calle=resultado.getString(5);
                                num=resultado.getInt(6);
                                cp=resultado.getInt(7);
                                provincia=resultado.getString(8);
                                
                                setInstalacion(new InstalacionDTO(codigo,fecha_fin,fecha_inicio,dueno,calle,num,cp,provincia));
                                getInstalaciones().add(getInstalacion());
                            }
                        }
                    }
                }
            
                consultaprueba.close();
                conn.getConnect().close();
            }
        }catch(Exception e){
            setSuceso(new String("Error: "+e));
        }
	}
}
	
