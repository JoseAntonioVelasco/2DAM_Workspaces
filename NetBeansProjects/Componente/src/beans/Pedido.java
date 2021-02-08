package beans;

import java.io.*;
import java.util.Date;
/**
 *
 * @author JoseAntonioVelasco
 */
public class Pedido implements Serializable{
    private int numeroPedido;
    private Producto producto;
    private Date fechaPedido;
    private int cantidad;

    public Pedido() {
    }

    public Pedido(int numeroPedido, Producto producto, Date fechaPedido, int cantidad) {
        this.numeroPedido = numeroPedido;
        this.producto = producto;
        this.fechaPedido = fechaPedido;
        this.cantidad = cantidad;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
            
    
}
