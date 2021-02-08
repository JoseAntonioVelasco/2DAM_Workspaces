package beans;

import java.io.*;
/**
 *
 * @author JoseAntonioVelasco
 */
public class Producto implements Serializable{
    private int idProducto;
    private String descripcion;
    private int stockActual;
    private int stockMinimo;
    private float pvp;

    public Producto() {
    }

    public Producto(String descripcion, int idProducto, int stockActual, int stockMinimo, float pvp) {
        this.descripcion = descripcion;
        this.idProducto = idProducto;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.pvp = pvp;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public float getPvp() {
        return pvp;
    }

    public void setPvp(float pvp) {
        this.pvp = pvp;
    }
    
    

}
