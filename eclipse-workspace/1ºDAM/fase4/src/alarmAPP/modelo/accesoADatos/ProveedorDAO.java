package alarmAPP.modelo.accesoADatos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import alarmAPP.modelo.ProveedorDTO;
/**
 * 
 * Esta es la clase que se utiliza para manipular datos relacionados con los proveedores en la base de datos
 *
 */
public class ProveedorDAO {
	private ArrayList<ProveedorDTO> proveedores;
	private ProveedorDTO proveedor;
	private String suceso;
	public ProveedorDAO() {
		proveedores=new ArrayList<ProveedorDTO>();
	}
	public ArrayList<ProveedorDTO> getProveedores() {return proveedores;}
	public void setProveedores(ArrayList<ProveedorDTO> proveedores) {this.proveedores = proveedores;}
	public ProveedorDTO getProveedor() {return proveedor;}
	public void setProveedor(ProveedorDTO proveedor) {this.proveedor = proveedor;}
	public String getSuceso() {return suceso;}
	public void setSuceso(String suceso) {this.suceso = suceso;}
	
	//crear
	/**
	 * Sirve para anadir un proveedor a la bbdd
	 * @param proveedor le pasamos por parametro el proveedor que queremos anadir a la bbdd
	 */
	public void crearProveedor(ProveedorDTO proveedor) {
		setSuceso(new String("El Proveedor ha sido creada correctamente"));
		try {
				Conectar conn = new Conectar();
	            Statement consultaprueba = conn.getConnect().createStatement();
	            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Proveedor WHERE cif='"+proveedor.getCif()+"'");
	            if(resultado.next()==false)
	            {
	                Statement consulta = conn.getConnect().createStatement();
	                int executeUpdate = consulta.executeUpdate("INSERT INTO Proveedor (cif, nombre, calle, parcela, provincia, cp, numnave)"+"VALUES ('"+
	                        proveedor.getCif()+"','" + proveedor.getNombre()+ "','" + proveedor.getCalle()+"','"+
	                        proveedor.getParcela()+"','" +proveedor.getProvincia()+"','"+proveedor.getCp()+"','"+proveedor.getNum_nave()+"')");
	
	                consulta.close();
	            }
	            else {
	            	setSuceso(new String("El proveedor ya existe"));
	            }
	            consultaprueba.close();
	            conn.getConnect().close();
			}catch(Exception e) {
    	   setSuceso(new String("Error: "+e));
       }
		
	}
	//modificar
	/**
	 * Sirve para modificar un proveedor de la bbdd
	 * @param proveedor le pasamos por parametro el proveedor que queremos modificar
	 */
	public void modificarProveedor(ProveedorDTO proveedor) {
		setSuceso(new String("El Proveedor ha sido modificado correctamente"));
        try
        {
            Conectar conn = new Conectar();
            Statement consultaprueba = conn.getConnect().createStatement();
            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Proveedor WHERE cif='"+proveedor.getCif()+"'");

            if (resultado.next()==true)
            {
                Statement consultaprueba2 = conn.getConnect().createStatement();
                int executeUpdate  = consultaprueba2.executeUpdate("UPDATE Proveedor SET nombre='"+proveedor.getNombre()+"' WHERE cif='"+proveedor.getCif()+"'");
                executeUpdate  = consultaprueba2.executeUpdate("UPDATE Proveedor SET calle="+proveedor.getCalle()+" WHERE cif='"+proveedor.getCif()+"'");
                executeUpdate  = consultaprueba2.executeUpdate("UPDATE Proveedor SET parcela="+proveedor.getParcela()+" WHERE cif='"+proveedor.getCif()+"'");
                executeUpdate  = consultaprueba2.executeUpdate("UPDATE Proveedor SET provincia="+proveedor.getProvincia()+" WHERE cif='"+proveedor.getCif()+"'");
                executeUpdate  = consultaprueba2.executeUpdate("UPDATE Proveedor SET cp="+proveedor.getCp()+" WHERE cif='"+proveedor.getCif()+"'");
                executeUpdate  = consultaprueba2.executeUpdate("UPDATE Proveedor SET numnave="+proveedor.getNum_nave()+" WHERE cif='"+proveedor.getCif()+"'");
                consultaprueba2.close();
            }
            else
                setSuceso(new String("El proveedor no existe"));

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
	 * Sirve para eliminar un proveedor de la bbdd
	 * @param proveedor le pasamos por parametro el proveedor que queremos eliminar
	 */
	public void eliminarProveedor(ProveedorDTO proveedor) {
		 setSuceso(new String("El proveedor ha sido eliminado correctamente"));
	        try
	        {
	            Conectar conn = new Conectar();
	            Statement consultaprueba = conn.getConnect().createStatement();
	            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Proveedor WHERE cif='"+proveedor.getCif()+"'");

	            if(resultado.next()==true)
	            {
	                Statement consulta = conn.getConnect().createStatement();
	                int executeUpdate = consulta.executeUpdate("DELETE FROM Proveedor WHERE cif='"+proveedor.getCif()+"'");
	                consulta.close();
	            }
	            else
	                setSuceso(new String("El proveedor no existe"));

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
	 * Sirve para buscar proveedores en la bbdd
	 * Devolvera los resultados que coincidan en el ArrayList proveedores
	 * @param proveedor le pasamos por parametro el proveedor que queremos buscar
	 */
	public void buscarProveedor(ProveedorDTO proveedor) {
		try
		{
			setSuceso(new String("Busqueda Correcta"));
			Conectar conn = new Conectar();
			Statement consultaprueba = conn.getConnect().createStatement();
			
			if(!proveedor.getCif().equals(null))
			{
				//cif -> conocido
				
				ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Proveedor WHERE cif='"+proveedor.getCif()+"' ORDER BY cif");
				setProveedor(new ProveedorDTO());
	               if (resultado.next()==true)
	               {
	                   getProveedor().setCif(resultado.getString(1));
	                   getProveedor().setNombre(resultado.getString(2));
	                   getProveedor().setCalle(resultado.getString(3));
	                   getProveedor().setParcela(resultado.getInt(4));
	                   getProveedor().setProvincia(resultado.getString(5));
	                   getProveedor().setCp(resultado.getInt(6));
	                   getProveedor().setNum_nave(resultado.getInt(7));
	                   getProveedor().setProvincia(resultado.getString(8));
	                   getProveedores().add(getProveedor());
	               }
	               else
	               {
	            	   getProveedor().setCif(null);
	            	   getProveedor().setNombre(null);
	            	   getProveedor().setCalle(null);
	                   getProveedor().setParcela(null);
	                   getProveedor().setProvincia(null);
	                   getProveedor().setCp(null);
	                   getProveedor().setNum_nave(null);
	               }
	               consultaprueba.close();
	               conn.getConnect().close();
	               
			}
			else{
	                String cif, nombre, calle, provincia;
	                Integer parcela,num_nave,cp;

	                if(proveedor.getNombre().equals(null))
	                {
	                    if(proveedor.getCalle().equals(null)||proveedor.getCp().equals(null)||proveedor.getParcela().equals(null)||proveedor.getNum_nave().equals(null))
	                    {
	                       /*
	                         cif -> Desconocido
	                         nombre -> Desconocido
	                         direccion -> Desconocido
	                       */
	                       ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Proveedor ORDER BY cif");
	                       while (resultado.next())
	                       {
	                    	   cif=resultado.getString(1);
	                    	   nombre=resultado.getString(2);
	                    	   calle=resultado.getString(3);
	                    	   parcela=resultado.getInt(4);
	                    	   provincia=resultado.getString(5);
	                    	   cp=resultado.getInt(6);
	                    	   num_nave=resultado.getInt(7);
	                    	   
	                    	   setProveedor(new ProveedorDTO(cif,nombre,calle,parcela,provincia,cp,num_nave));
	                    	   getProveedores().add(getProveedor());
	                       }
	                    } 
	                    else
	                    {
	                          /*
	                            cif -> Desconocido
	                            nombre -> Desconocido
	                            direccion -> Conocido
	                          */
	                            
	                         ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Proveedores WHERE cp='"+proveedor.getCp()+"' and calle='"+proveedor.getCalle()+"' and numNave='"+proveedor.getNum_nave()+"' and parcela='"+proveedor.getParcela()+"' ORDER BY cif");
	                         while (resultado.next())
	                         {
	                        	   cif=resultado.getString(1);
	                        	   nombre=resultado.getString(2);
	   	                    	   calle=resultado.getString(3);
	   	                    	   parcela=resultado.getInt(4);
	   	                    	   provincia=resultado.getString(5);
	   	                    	   cp=resultado.getInt(6);
	   	                    	   num_nave=resultado.getInt(7);
	   	                    	   
	   	                    	   setProveedor(new ProveedorDTO(cif,nombre,calle,parcela,provincia,cp,num_nave));
	   	                    	   getProveedores().add(getProveedor());
	                         }
	                    }
	                 }
	                    else
	                    {
	                        if(proveedor.getCalle().equals(null)||proveedor.getCp().equals(null)||proveedor.getParcela().equals(null)||proveedor.getNum_nave().equals(null))
	                        {
	                            /*
	                                cif -> Desconocido
	                                nombre -> Conocido
	                                direccion -> Desconocido
	                            */
	                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Proveedor WHERE nombre='"+proveedor.getNombre()+"' ORDER BY cif");
	                            while (resultado.next())
	                            {
	                            	cif=resultado.getString(1);
		                        	nombre=resultado.getString(2);
		   	                    	calle=resultado.getString(3);
		   	                    	parcela=resultado.getInt(4);
		   	                    	provincia=resultado.getString(5);
		   	                    	cp=resultado.getInt(6);
		   	                    	num_nave=resultado.getInt(7);
		   	                    	   
		   	                    	setProveedor(new ProveedorDTO(cif,nombre,calle,parcela,provincia,cp,num_nave));
		   	                    	getProveedores().add(getProveedor());
	                            }
	                        }
	                        else
	                        {
	                            /*
	                                cif -> Desconocido
	                                nombre -> Conocido
	                                direccion -> Conocido
	                            */
	                            
	                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Instalacion WHERE nombre='"+proveedor.getNombre()+"' and cp='"+proveedor.getCp()+"' and calle='"+proveedor.getCalle()+"' and numNave='"+proveedor.getNum_nave()+"' and parcela='"+proveedor.getParcela()+"' ORDER BY cif");
	                            while (resultado.next())
	                            {
	                            	cif=resultado.getString(1);
		                        	nombre=resultado.getString(2);
		   	                    	calle=resultado.getString(3);
		   	                    	parcela=resultado.getInt(4);
		   	                    	provincia=resultado.getString(5);
		   	                    	cp=resultado.getInt(6);
		   	                    	num_nave=resultado.getInt(7);
		   	                    	   
		   	                    	setProveedor(new ProveedorDTO(cif,nombre,calle,parcela,provincia,cp,num_nave));
		   	                    	getProveedores().add(getProveedor());
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
