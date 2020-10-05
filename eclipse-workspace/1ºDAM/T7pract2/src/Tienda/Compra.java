package Tienda;

public class Compra {
	//atributos
	private String producto;
	private int cantidad;
	//constructor
	public Compra(String producto,int cantidad) {
		this.producto=producto;
		this.cantidad=cantidad;
	}
	//metodos
	
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
