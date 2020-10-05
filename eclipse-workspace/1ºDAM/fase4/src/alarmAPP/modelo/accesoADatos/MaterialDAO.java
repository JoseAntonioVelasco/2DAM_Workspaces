package alarmAPP.modelo.accesoADatos;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import alarmAPP.modelo.MaterialDTO;
/**
 * 
 * Esta es la clase que se utiliza para manipular datos relacionados con los materiales en la base de datos
 *
 */
public class MaterialDAO {
	private ArrayList<MaterialDTO> materiales;
	private MaterialDTO material;
	private String suceso;
	public MaterialDAO() {
		materiales=new ArrayList<MaterialDTO>();
	}
	public ArrayList<MaterialDTO> getMateriales() {return materiales;}
	public void setMateriales(ArrayList<MaterialDTO> materiales) {this.materiales = materiales;}
	public MaterialDTO getMaterial() {return material;}
	public void setMaterial(MaterialDTO material) {this.material = material;}
	public String getSuceso() {return suceso;}
	public void setSuceso(String suceso) {this.suceso = suceso;}
	
	//crear
	/**
	 * Sirve para anadir un material a la bbdd
	 * @param material pasamos por parametro el material que queremos anadir a la bbdd
	 */
	public void crearMaterial(MaterialDTO material) {
		setSuceso(new String("El material ha sido creado correctamente"));
		try{
				
	            Conectar conn = new Conectar();
	            Statement consultaprueba = conn.getConnect().createStatement();
	            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Material WHERE codigo='"+material.getCodigoMaterial()+"'");
	            if(resultado.next()==false)
	            {
	                Statement consulta = conn.getConnect().createStatement();
	                int executeUpdate = consulta.executeUpdate("INSERT INTO Material (codigo,nombre,stock,tiempo_suministro,cif)"+"VALUES ('"+
	                		material.getCodigoMaterial()+"','" + material.getNombre()+ "','" + material.getStock()+"','"+
	                		material.getTiempo_suministro()+"','" +material.getCif()+"')");

	                consulta.close();
	            }
	            else {
	            	setSuceso(new String("El material ya existe"));
	            }
	            consultaprueba.close();
	            conn.getConnect().close();
	       }catch(Exception e) {
	    	   setSuceso(new String("Error: "+e));
	       }
	
       
	}
	//modificar
	/**
	 * Sirve para modificar un material guardado en la bbdd
	 * @param material le pasamos por parametro el material que queremos modificar 
	 */
	public void modificarMaterial(MaterialDTO material) {
		setSuceso(new String("El material ha sido modificada correctamente"));
        try
        {
            Conectar conn = new Conectar();
            Statement consultaprueba = conn.getConnect().createStatement();
            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Material WHERE codigo='"+material.getCodigoMaterial()+"'");

            if (resultado.next()==true)
            {
                Statement consultaprueba2 = conn.getConnect().createStatement();
                int executeUpdate  = consultaprueba2.executeUpdate("UPDATE Material SET nombre='"+material.getNombre()+"' WHERE codigo='"+material.getCodigoMaterial()+"'");
                executeUpdate  = consultaprueba2.executeUpdate("UPDATE Material SET stock="+material.getStock()+" WHERE codigo='"+material.getCodigoMaterial()+"'");
                executeUpdate  = consultaprueba2.executeUpdate("UPDATE Material SET Tiempo_Suministro="+material.getTiempo_suministro()+" WHERE codigo='"+material.getCodigoMaterial()+"'");
                executeUpdate  = consultaprueba2.executeUpdate("UPDATE Material SET CIF="+material.getCif()+" WHERE codigo='"+material.getCodigoMaterial()+"'");
                consultaprueba2.close();
            }
            else
                setSuceso(new String("El material no existe"));

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
	 * Sirve para eliminar un material de la bbdd
	 * @param material le pasamos por parametro el material a eliminar
	 */
	public void eliminarInstalacion(MaterialDTO material) {
		 setSuceso(new String("El material ha sido eliminado correctamente"));
	        try
	        {
	            Conectar conn = new Conectar();
	            Statement consultaprueba = conn.getConnect().createStatement();
	            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Material WHERE codigo='"+material.getCodigoMaterial()+"'");

	            if(resultado.next()==true)
	            {
	                Statement consulta = conn.getConnect().createStatement();
	                int executeUpdate = consulta.executeUpdate("DELETE FROM Material WHERE codigo='"+material.getCodigoMaterial()+"'");
	                consulta.close();
	            }
	            else
	                setSuceso(new String("El material no existe"));

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
	 * Sirve para buscar en la bbdd.
	 * Puede buscar por codigo,nombre,stock y cif y devolvera los resultados que coincidan
	 * @param material le pasamos por parametro el material a buscar
	 */
	public void buscarInstalacion(MaterialDTO material) {
		try
        {
            setSuceso(new String("Busqueda Correcta"));
            Conectar conn = new Conectar();
            Statement consultaprueba = conn.getConnect().createStatement();
            
            if(!material.getCodigoMaterial().equals(null))
            {
                //codigo -> conocido
                 
                ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Material WHERE codigo='"+material.getCodigoMaterial()+"' ORDER BY codigo");
                setMaterial(new MaterialDTO());
                if (resultado.next()==true)
                {
                	getMaterial().setCodigoMaterial(resultado.getInt(1));
                	getMaterial().setNombre(resultado.getString(2));
                	getMaterial().setStock(resultado.getInt(3));
                	getMaterial().setTiempo_suministro(resultado.getString(4));
                	getMaterial().setCif(resultado.getString(5));
                	getMateriales().add(getMaterial());
                }
                else
                {
                	getMaterial().setCodigoMaterial(null);
                	getMaterial().setNombre(null);
                	getMaterial().setStock(null);
                	getMaterial().setTiempo_suministro(null);
                	getMaterial().setCif(null);
                }
                
                consultaprueba.close();
                conn.getConnect().close();
            }
            else
            {
                String nombre,tiempo_suministro,cif;
                Integer codigo,stock;

                if(material.getNombre().equals(null))
                {
                    if(material.getStock().equals(null))
                    {
                        if(material.getCif().equals(null))
                        {
                        	
                        	
                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Material ORDER BY codigo");
                            while (resultado.next())
                            {
                            	codigo=resultado.getInt(1);
                            	nombre=resultado.getString(2);
                            	stock=resultado.getInt(3);
                            	tiempo_suministro=resultado.getString(4);
                            	cif=resultado.getString(5);
                                
                                setMaterial(new MaterialDTO(codigo,nombre,stock,tiempo_suministro,cif));
                                getMateriales().add(getMaterial());
                            }
                        }
                        else
                        {
                            /*
                                codigo -> Desconocido
                                nombre -> Desconocido
                                stock -> Desconocido
                                cif -> Conocido
                            */
                            
                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Material WHERE CIF='"+material.getCif()+"' ORDER BY codigo");
                            while (resultado.next())
                            {
                            	codigo=resultado.getInt(1);
                            	nombre=resultado.getString(2);
                            	stock=resultado.getInt(3);
                            	tiempo_suministro=resultado.getString(4);
                            	cif=resultado.getString(5);
                                
                            	setMaterial(new MaterialDTO(codigo,nombre,stock,tiempo_suministro,cif));
                                getMateriales().add(getMaterial());
                            }
                        }
                    }
                    else
                    {
                        if(material.getCif().equals(null))
                        {
                        	/*
                            codigo -> Desconocido
                            nombre -> Desconocido
                            stock -> Conocido
                            cif -> Desconocido
                            */
                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Material WHERE stock='"+material.getStock()+"' ORDER BY codigo");
                            while (resultado.next())
                            {
                            	codigo=resultado.getInt(1);
                            	nombre=resultado.getString(2);
                            	stock=resultado.getInt(3);
                            	tiempo_suministro=resultado.getString(4);
                            	cif=resultado.getString(5);
                                
                            	setMaterial(new MaterialDTO(codigo,nombre,stock,tiempo_suministro,cif));
                                getMateriales().add(getMaterial());
                            }
                        }
                        else
                        {
                        	/*
                            codigo -> Desconocido
                            nombre -> Desconocido
                            stock -> Conocido
                            cif -> Conocido
                            */
                            
                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Material WHERE stock='"+material.getStock()+"' ORDER BY codigo");
                            while (resultado.next())
                            {
                            	codigo=resultado.getInt(1);
                            	nombre=resultado.getString(2);
                            	stock=resultado.getInt(3);
                            	tiempo_suministro=resultado.getString(4);
                            	cif=resultado.getString(5);
                                
                            	setMaterial(new MaterialDTO(codigo,nombre,stock,tiempo_suministro,cif));
                                getMateriales().add(getMaterial());
                            }
                        }
                    }
                }
                else
                {
                    if(material.getStock().equals(null))
                    {
                        if(material.getCif().equals(null))
                        {
                        	/*
                            codigo -> Desconocido
                            nombre -> Conocido
                            stock -> Desconocido
                            cif -> Desconocido
                            */
                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Material WHERE nombre='"+material.getNombre()+"' ORDER BY codigo");
                            while (resultado.next())
                            {
                            	codigo=resultado.getInt(1);
                            	nombre=resultado.getString(2);
                            	stock=resultado.getInt(3);
                            	tiempo_suministro=resultado.getString(4);
                            	cif=resultado.getString(5);
                                
                            	setMaterial(new MaterialDTO(codigo,nombre,stock,tiempo_suministro,cif));
                                getMateriales().add(getMaterial());
                            }
                        }
                        else
                        {
                        	/*
                            codigo -> Desconocido
                            nombre -> Conocido
                            stock -> Desconocido
                            cif -> Conocido
                            */
                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Material WHERE nombre='"+material.getNombre()+"'and CIF='"+material.getCif()+"' ORDER BY codigo");
                            while (resultado.next())
                            {
                            	codigo=resultado.getInt(1);
                            	nombre=resultado.getString(2);
                            	stock=resultado.getInt(3);
                            	tiempo_suministro=resultado.getString(4);
                            	cif=resultado.getString(5);
                                
                            	setMaterial(new MaterialDTO(codigo,nombre,stock,tiempo_suministro,cif));
                                getMateriales().add(getMaterial());
                            }
                        }
                    }
                    else
                    {
                        if(material.getCif().equals(null))
                        {
                        	/*
                            codigo -> Desconocido
                            nombre -> Conocido
                            stock -> Conocido
                            cif -> Desconocido
                            */
                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Material WHERE nombre='"+material.getNombre()+"' AND stock='"+material.getStock()+"' ORDER BY codigo");
                            while (resultado.next())
                            {
                            	codigo=resultado.getInt(1);
                            	nombre=resultado.getString(2);
                            	stock=resultado.getInt(3);
                            	tiempo_suministro=resultado.getString(4);
                            	cif=resultado.getString(5);
                                
                            	setMaterial(new MaterialDTO(codigo,nombre,stock,tiempo_suministro,cif));
                                getMateriales().add(getMaterial());
                            }
                        }
                        else
                        {
                        	/*
                            codigo -> Desconocido
                            nombre -> Conocido
                            stock -> Conocido
                            cif -> Conocido
                            */
                            
                            ResultSet resultado = consultaprueba.executeQuery("SELECT * FROM Material WHERE nombre='"+material.getNombre()+"' AND stock='"+material.getStock()+"' AND CIF='"+material.getCif()+"' ORDER BY codigo");
                            while (resultado.next())
                            {
                            	codigo=resultado.getInt(1);
                            	nombre=resultado.getString(2);
                            	stock=resultado.getInt(3);
                            	tiempo_suministro=resultado.getString(4);
                            	cif=resultado.getString(5);
                                
                            	setMaterial(new MaterialDTO(codigo,nombre,stock,tiempo_suministro,cif));
                                getMateriales().add(getMaterial());
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
