package DAO;

import DTO.*;


public interface PlanetaDAO {
    public boolean insertarPlaneta(Planeta plan);
    public boolean eliminarPlaneta(Planeta plan);
    public boolean modificarPlaneta(Planeta plan);
    public Planeta consultarPlaneta(Planeta plan);
}
