package DAO;

import DTO.Galaxia;

public interface GalaxiaDAO{
    public boolean insertarGalaxia(Galaxia gal);
    public boolean eliminaGalaxia(Galaxia gal);
    public boolean modificarGalaxia(Galaxia gal);
    public Galaxia consultarGalaxia(Galaxia gal);
}
