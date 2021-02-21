package DAO;

import DTO.*;
import java.util.ArrayList;


public interface PlanetaDAO {
    public boolean insertarPlaneta(Planeta plan);
    public boolean eliminarPlaneta(Planeta plan);
    public boolean modificarPlaneta(Planeta plan,String nombre_antiguo);
    public Planeta consultarPlaneta(Planeta plan);
    public ArrayList<Planeta> consultarPlanetas();
}
