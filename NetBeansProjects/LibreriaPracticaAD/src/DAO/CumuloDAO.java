package DAO;

import DTO.*;
import java.io.Serializable;

public interface CumuloDAO{
    public boolean insertarCumulo(Cumulo cum);
    public boolean eliminarCumulo(Cumulo cum);
    public boolean modificarCumulo(Cumulo cum);
    public Cumulo consultarCumulo(Cumulo cum);
}
