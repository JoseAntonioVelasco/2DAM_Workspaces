package IMPL;

import BBDD.AccesoBaseDatos;
import DAO.PlanetaDAO;
import DTO.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlanetaImpl implements PlanetaDAO {
    /**
     * Añade un planeta a la tabla planeta de la base de datos
     * @param plan planeta que se va a añadir
     * @return true si se añadio correctamente
     */
    @Override
    public boolean insertarPlaneta(Planeta plan){
        AccesoBaseDatos abd = new AccesoBaseDatos();
        Connection conexion = abd.getConexion();
        String sql = "INSERT INTO planeta VALUES (?,?,?,?)";
        PreparedStatement ps;
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, plan.getNombre());
            ps.setDouble(2, plan.getMasa());
            ps.setDouble(3, plan.getVolumen());
            ps.setString(4, plan.getNombre_sistema());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    /**
     * Borra el planeta de la tabla planeta de la base de datos
     * @param plan objeto planeta que queremos borrar que debe contener al menos el nombre.
     * @return true si se ha borrado correctamente
     */
    @Override
    public boolean eliminarPlaneta(Planeta plan){
        AccesoBaseDatos abd = new AccesoBaseDatos();
        try(
            Connection c = abd.getConexion();
            Statement s = c.createStatement();
            ){
            boolean rs = s.execute("DELETE FROM planeta WHERE nombre = '"+plan.getNombre()+"'");
            return rs;
        }catch(SQLException e){
            Logger.getLogger(AccesoBaseDatos.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    /**
     * Modifica un planeta de la tabla planeta de la base de datos
     * @param plan objeto que contiene todos los nuevos datos que queremos poner
     * @param nombre_antiguo nombre del planeta que queremos modificar sus datos
     * @return true si se ha modificado correctamente
     */
    @Override
    public boolean modificarPlaneta(Planeta plan,String nombre_antiguo){
        AccesoBaseDatos abd = new AccesoBaseDatos();
        try(
            Connection c = abd.getConexion();
            Statement s = c.createStatement();
            ){
            boolean rs = s.execute("UPDATE planeta "
                    + "SET nombre = '"+plan.getNombre()+"', masa = '"+plan.getMasa()+"', volumen = '"+plan.getVolumen()+"', nombre_sistema = '"+plan.getNombre_sistema()+"' "
                            + " WHERE nombre = '"+nombre_antiguo+"'");
            return rs;
        }catch(SQLException e){
            Logger.getLogger(AccesoBaseDatos.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    /**
     * Busca planetas que tengan dicho nombre en la base de datos en la tabla planeta
     * @param plan objeto planeta que tiene que contener como minimo el nombre del que queremos buscar
     * @return planeta encontrado con ese nombre
     */
    @Override
    public Planeta consultarPlaneta(Planeta plan){
        AccesoBaseDatos abd = new AccesoBaseDatos();
        try(
            Connection c = abd.getConexion();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM planeta WHERE nombre = '"+plan.getNombre()+"'")){
            
            int i = 1;
            while(rs.next()){
                plan.setNombre(rs.getString("nombre"));
                plan.setMasa(rs.getDouble("masa"));
                plan.setVolumen(rs.getDouble("volumen"));
                plan.setNombre_sistema(rs.getString("nombre_sistema"));
            }
            
        }catch(SQLException e){
            Logger.getLogger(AccesoBaseDatos.class.getName()).log(Level.SEVERE, null, e);
        }
        return plan;
    }
    /**
     * Retorna todos los planetas que haya en la tabla planeta en la base de datos
     * @return Arraylist con todos los planetas de la tabla planeta
     */
    @Override
    public ArrayList<Planeta> consultarPlanetas(){
        ArrayList<Planeta> planetas = new ArrayList<Planeta>();
        AccesoBaseDatos abd = new AccesoBaseDatos();
        try(
            Connection c = abd.getConexion();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM planeta")){
            
            int i = 1;
            while(rs.next()){
                Planeta plan = new Planeta();
                plan.setNombre(rs.getString("nombre"));
                plan.setMasa(rs.getDouble("masa"));
                plan.setVolumen(rs.getDouble("volumen"));
                plan.setNombre_sistema(rs.getString("nombre_sistema"));
                planetas.add(plan);
            }
            
        }catch(SQLException e){
            Logger.getLogger(AccesoBaseDatos.class.getName()).log(Level.SEVERE, null, e);
        }
        return planetas;
    }
}
