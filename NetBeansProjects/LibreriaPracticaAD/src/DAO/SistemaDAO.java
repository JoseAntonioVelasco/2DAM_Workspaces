package DAO;

import DTO.*;
import java.io.Serializable;

public interface SistemaDAO{
    public boolean insertarSistema(Sistema sis);
    public boolean eliminarSistema(Sistema sis);
    public boolean modificarSistema(Sistema sis);
    public Sistema consultarSistema(Sistema sis);
}
