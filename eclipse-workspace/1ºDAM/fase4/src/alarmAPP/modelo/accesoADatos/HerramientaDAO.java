package alarmAPP.modelo.accesoADatos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import alarmAPP.modelo.HerramientaDTO;
/**
 * 
 * Esta es la clase que se utiliza para manipular datos relacionados con las herramientas en la base de datos
 *
 */
public class HerramientaDAO {
	private ArrayList<HerramientaDTO> herramientas;
	private HerramientaDTO herramienta;
	private String suceso;
	
	public HerramientaDAO(){
		herramientas=new ArrayList<HerramientaDTO>();
	}

	public ArrayList<HerramientaDTO> getHerramientas() {return herramientas;}
	public void setHerramientas(ArrayList<HerramientaDTO> herramientas) {this.herramientas = herramientas;}
	public HerramientaDTO getHerramienta() {return herramienta;}
	public void setHerramienta(HerramientaDTO herramienta) {this.herramienta = herramienta;}
	public String getSuceso() {return suceso;}
	public void setSuceso(String suceso) {this.suceso = suceso;}
	
	//crear
	/**
	 * Sirve para anadir una herramienta a la bbdd
	 * @param herramienta recibe un objeto de tipo HerramientaDTO con sus datos
	 */
	public void crearHerramienta(HerramientaDTO herramienta) {
		setSuceso(new String("La Herramienta ha sido creada correctamente"));
		try{
				
	            Conectar conn = new Conectar();
	            Statement consultaprueba = conn.getConnect().createStatement();
	            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Herramienta WHERE codigo='"+herramienta.getCodigo()+"'");
	            if(resultado.next()==false)
	            {
	                Statement consulta = conn.getConnect().createStatement();
	                int executeUpdate = consulta.executeUpdate("INSERT INTO Herramienta (codigo, herramienta, codInstalacion)"+"VALUES ('"+
	                        herramienta.getCodigo()+"','" + herramienta.getHerramienta()+ "','" +herramienta.getCodInstalacion()+"')");
	                consulta.close();
	            }
	            else {
	            	setSuceso(new String("La Herramienta ya existe"));
	            }
	            consultaprueba.close();
	            conn.getConnect().close();
	       }catch(Exception e) {
	    	   setSuceso(new String("Error: "+e));
	       }
	}
	//modificar
	/**
	 * Sirve para modificar una herramienta en la bbdd
	 * @param herramienta recibe un objeto de tipo HerramientaDTO del cual utilizaremos el codigo
	 */
	public void modificarHerramienta(HerramientaDTO herramienta) {
		setSuceso(new String("La Herramienta ha sido modificada correctamente"));
        try
        {
            Conectar conn = new Conectar();
            Statement consultaprueba = conn.getConnect().createStatement();
            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Herramienta WHERE codigo='"+herramienta.getCodigo()+"'");

            if (resultado.next()==true)
            {
                Statement consultaprueba2 = conn.getConnect().createStatement();
                int executeUpdate  = consultaprueba2.executeUpdate("UPDATE Herramienta SET herramienta='"+herramienta.getHerramienta()+"' WHERE codigo='"+herramienta.getCodigo()+"'");
                executeUpdate  = consultaprueba2.executeUpdate("UPDATE Herramienta SET codInstalacion="+herramienta.getCodInstalacion()+" WHERE codigo='"+herramienta.getCodigo()+"'");
                consultaprueba2.close();
            }
            else
                setSuceso(new String("La Herramienta no existe"));

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
	 * Sirve para eliminar una herramienta guardada en la bbdd
	 * @param herramienta le pasamos la herramienta que queremos eliminar
	 */
	public void eliminarHerramienta(HerramientaDTO herramienta) {
		 setSuceso(new String("La Herramienta ha sido eliminada correctamente"));
	        try
	        {
	            Conectar conn = new Conectar();
	            Statement consultaprueba = conn.getConnect().createStatement();
	            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Herramienta WHERE codigo='"+herramienta.getCodigo()+"'");

	            if(resultado.next()==true)
	            {
	                Statement consulta = conn.getConnect().createStatement();
	                int executeUpdate = consulta.executeUpdate("DELETE FROM Herramienta WHERE codigo='"+herramienta.getCodigo()+"'");
	                consulta.close();
	            }
	            else
	                setSuceso(new String("La Herramienta no existe"));

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
	 * Sirve para buscar herramientas en la bbdd,
	 * podemos buscar por codigo,nombre de la herramienta o por codigo de instalacion donde esta siendo usada
	 * los resultados los guarda en el ArrayList herramientas
	 * @param herramienta le pasamos la herramienta que queremos buscar
	 */
	public void buscarHerramienta(HerramientaDTO herramienta) {
		try
		{
			setSuceso(new String("Busqueda Correcta"));
			Conectar conn = new Conectar();
			Statement consultaprueba = conn.getConnect().createStatement();
			
			if(!herramienta.getCodigo().equals(null))
			{
				//codigo -> conocido
				
				ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Herramienta WHERE codigo='"+herramienta.getCodigo()+"' ORDER BY codigo");
				setHerramienta(new HerramientaDTO());
	               if (resultado.next()==true)
	               {
	                   getHerramienta().setCodigo(resultado.getInt(1));
	                   getHerramienta().setHerramienta(resultado.getString(2));
	                   getHerramienta().setCodInstalacion(resultado.getInt(3));
	                   getHerramientas().add(getHerramienta());
	               }
	               else
	               {
	            	   getHerramienta().setCodigo(null);
	            	   getHerramienta().setHerramienta(null);
	            	   getHerramienta().setCodInstalacion(null);
	               }
	               consultaprueba.close();
	               conn.getConnect().close();
	               
			}
			else{
	                String nomb_herr;
	                Integer codigo,codInstalacion;

	                if(herramienta.getHerramienta().equals(null))
	                {
	                    if(herramienta.getCodInstalacion().equals(null))
	                    {
	                       /*
	                         codigo -> Desconocido
	                         nomb_herr -> Desconocido
	                         codInstalacion -> Desconocido
	                       */
	                       ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Herramienta ORDER BY codigo");
	                       while (resultado.next())
	                       {
	                    	   codigo=resultado.getInt(1);
	                    	   nomb_herr=resultado.getString(2);
	                    	   codInstalacion=resultado.getInt(3);
	                    	   
	                    	   setHerramienta(new HerramientaDTO(codigo,nomb_herr,codInstalacion));
	                    	   getHerramientas().add(getHerramienta());
	                       }
	                    } 
	                    else
	                    {
	                          /*
	                            codigo -> Desconocido
	                            nomb_herr -> Desconocido
	                            codInstalacion -> Conocido
	                          */
	                            
	                         ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Herramienta WHERE codInstalacion='"+herramienta.getCodInstalacion()+"' ORDER BY codigo");
	                         while (resultado.next())
	                         {
	                        	 codigo=resultado.getInt(1);
		                    	 nomb_herr=resultado.getString(2);
		                    	 codInstalacion=resultado.getInt(3);
		                    	   
		                    	 setHerramienta(new HerramientaDTO(codigo,nomb_herr,codInstalacion));
		                    	 getHerramientas().add(getHerramienta());
	                         }
	                    }
	                 }
	                    else
	                    {
	                        if(herramienta.getCodInstalacion().equals(null))
	                        {
	                            /*
	                                codigo -> Desconocido
	                                nomb_herr -> Conocido
	                                codInstalacion -> Desconocido
	                            */
	                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Herramienta WHERE herramienta='"+herramienta.getHerramienta()+"' ORDER BY codigo");
	                            while (resultado.next())
	                            {
	                            	codigo=resultado.getInt(1);
			                    	nomb_herr=resultado.getString(2);
			                    	codInstalacion=resultado.getInt(3);
			                    	   
			                    	setHerramienta(new HerramientaDTO(codigo,nomb_herr,codInstalacion));
			                    	getHerramientas().add(getHerramienta());
	                            }
	                        }
	                        else
	                        {
	                            /*
	                                codigo -> Desconocido
	                                nomb_herr -> Conocido
	                                codInstalacion -> Conocido
	                            */
	                            
	                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Herramienta WHERE herramienta='"+herramienta.getHerramienta()+"' and codInstalacion='"+herramienta.getCodInstalacion()+"' ORDER BY codigo");
	                            while (resultado.next())
	                            {
	                            	codigo=resultado.getInt(1);
			                    	nomb_herr=resultado.getString(2);
			                    	codInstalacion=resultado.getInt(3);
			                    	   
			                    	setHerramienta(new HerramientaDTO(codigo,nomb_herr,codInstalacion));
			                    	getHerramientas().add(getHerramienta());
	                            }
	                        }
	                    }
	                }	                
	                consultaprueba.close();
	                conn.getConnect().close();
	            }
		catch(Exception e)
		{
			setSuceso(new String("Error: "+e));
		}
	}
}
