package IMPL;

import BBDD.AccesoBaseDatos;
import DAO.PlanetaDAO;
import DTO.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlanetaImpl implements PlanetaDAO {
    public boolean insertarPlaneta(Planeta plan){
        //TODO
        Connection conexion = AccesoBaseDatos.getConexion();
        String sql = "INSERT INTO planeta VALUES (?,?,?,?)";
        PreparedStatement ps;
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, plan.getNombre());
            ps.setDouble(2, plan.getMasa());
            ps.setDouble(3, plan.getVolumen());
            ps.setString(4, plan.getNombre_sistema());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    public boolean eliminarPlaneta(Planeta plan){
        //TODO
        return true;
    }
    public boolean modificarPlaneta(Planeta plan){
        //TODO
        return true;
    }
    public Planeta consultarPlaneta(Planeta plan){
        //TODO
        return plan;
    }
    public ArrayList<Planeta> consultarPlanetas(){
        ArrayList<Planeta> planetas = new ArrayList<Planeta>();
        
        return planetas;
    }
}
