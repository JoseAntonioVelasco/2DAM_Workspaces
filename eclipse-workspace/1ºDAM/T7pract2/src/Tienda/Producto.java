package Tienda;

public class Producto {
	//atributos
	private String nombre;
	private String categoria;
	private int cantidad;
	private double precio;
	//constructor
	public Producto(String nombre,String categoria,int cantidad,double precio){
		this.nombre=nombre;
		this.categoria=categoria;
		this.cantidad=cantidad;
		this.precio=precio;
	}
	//metodos
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
