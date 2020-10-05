package Tienda;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
// comprobar que no puedes poner precios negativos y que no puede haber stock negativo
public class Main {
	static Scanner cad = new Scanner(System.in);
	static Scanner num = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Producto> stock = new ArrayList<Producto> ();
		ArrayList<Compra> cesta = new ArrayList<Compra> ();
		//productos que vienen por defecto añadidos
		
		//creamos productos
		Producto p1 = new Producto("silla","mueble",2,20.5);	
		Producto p2 = new Producto("mesa","mueble",3,40.5);
		Producto p3 = new Producto("estanteria","mueble",3,42.5);
		//añadimos al stock
		stock.add(p1);
		stock.add(p2);
		stock.add(p3);
		
		int opcion1=1;
		while(opcion1==1) {
		System.out.println("Tienda NombreTienda");
		System.out.println("1. Anadir un nuevo producto");
		System.out.println("2. Modificar un producto existente");
		System.out.println("3. Comprar");
		System.out.println("4. Mostrar Stock");
		System.out.println("5. Salir");
		
			
			System.out.printf("Introduce opcion: ");
		
			int opcion;
			opcion=num.nextInt();
			//la opcion solo puede ser del 1-4
			while(opcion<0&&opcion>4)
			{
				System.out.println("opcion no valida");
				System.out.printf("Introduce de nuevo la opcion: ");
				opcion=num.nextInt();
			}
		
			switch(opcion)
			{
				case 1:
					p1=anadirProducto();
					stock.add(p1);
					break;
				case 2:
					modificarProducto(stock);
					break;
				case 3:
					comprar(stock,cesta);
					break;
				case 4:
					mostrarStock(stock);
					break;
				case 5:
					return;
				default:
					System.out.println("opcion no valida");
				
			}
		
		System.out.printf("\n");
		System.out.println("Desea realizar alguna otra operacion");
		System.out.println("1.Si");
		System.out.println("2.No");
		System.out.printf("Introduce opcion: ");
		opcion1=num.nextInt();
		System.out.printf("\n");
		}
		
	}
	private static Producto anadirProducto() {
		String nombre_producto;
		String categoria;
		int cantidad;
		double precio;
		
		System.out.printf("Introduce nombre producto: ");
		nombre_producto=cad.nextLine();
		
		System.out.printf("Introduce categoria producto: ");
		categoria=cad.nextLine();
		
		System.out.printf("Introduce cantidad producto: ");
		cantidad=num.nextInt();
		
		System.out.printf("Introduce precio producto: ");
		precio=num.nextDouble();
		
		Producto p5 =new Producto(nombre_producto,categoria,cantidad,precio);
		return p5;
		
		
	}
	private static void modificarProducto(ArrayList<Producto> stock) {
		String nombre;
		System.out.printf("Introduce nombre del producto que quieres modificar: ");
		nombre=cad.nextLine();
	
		Producto p = new Producto("a","b",1,2);
		int i;
		for(i=0;i<stock.size();i++)
		{
			p=stock.get(i);
			
			if(nombre.equals(p.getNombre())) {
				int opcion1;
				do {
					System.out.println("Que quieres modificar?");
					System.out.println("1.cantidad");
					System.out.println("2.precio");
					System.out.printf("Introduce opcion: ");
					
					int opcion;
					opcion=num.nextInt();
					
					switch(opcion)
					{
						case 1:
							int cantidad;
							System.out.printf("Que cantidad quieres: ");
							cantidad=num.nextInt();
							p.setCantidad(cantidad);
							break;
						case 2:
							double precio;
							System.out.printf("Que precio quieres: ");
							precio=num.nextDouble();
							p.setPrecio(precio);
							break;
						default:
							System.out.println("opcion no valida");
							
					}
					//actualizar producto en el stock
					stock.set(i, p);
					System.out.println("1. Para modificar cantidad o precio del producto seleccionado");
					System.out.println("2. Volver al menu principal");
					System.out.printf("Introduce opcion: ");
					opcion1=num.nextInt();
					if(opcion==2)
					{
						System.out.println("Volviendo al menu principal...");
						return;
					}
					
				}while(opcion1==1);
			}
			
		}
		System.out.println("No se han encontrado productos con ese nombre");
		
	}
	private static void comprar(ArrayList<Producto> stock, ArrayList<Compra> cesta) {//anotaciones: no deberia poder comprar mas cantidad de la que hay en stock, añadir los scanners
		//a) Mostrar listado de artículos del almacén junto con un número identificativo.
		Producto p = new Producto("a","b",1,2);
		int i;
		System.out.printf("\n");
		for(i=0;i<stock.size();i++)
		{
			p=stock.get(i);
			System.out.println("nombre: "+p.getNombre());
			System.out.println("categoria: "+p.getCategoria());
			System.out.println("cantidad: "+p.getCantidad());
			System.out.println("precio: "+p.getPrecio());
			System.out.println("numero ID:" +i);
			System.out.println("");
			
		}
		//b) Vaciar la lista de la cesta de la compra.
		cesta.clear();
		//c) Preguntar el código del artículo que desea comprar y la cantidad.
		int opcion=1;
		do
		{
			System.out.printf("Que producto quieres comprar? Introduzca el ID del codigo que quiere comprar: ");
			int id;
			id=num.nextInt();
			if(!stock.contains(stock.get(id)))
			{
				System.out.println("ese producto no existe");
			}
			System.out.printf("Introduzca la cantidad del producto que quieres comprar: ");
			int cantidad;
			cantidad=num.nextInt();
			//d) Instanciar la clase compra con los datos del paso anterior.
			p=stock.get(id);
			Compra c = new Compra(p.getNombre(),cantidad);
			//e) Actualizar la cantidad del producto en el almacén (si tengo 5 artículos y vendo 2 me quedan 3).
			int cantidad_actualizada=p.getCantidad()-cantidad;
			p.setCantidad(cantidad_actualizada);
			//f) Añadir el nuevo objeto compra a la cesta.
			cesta.add(c);
			//g) Preguntar si se desea hacer otra compra (en caso afirmativo, volver al paso c.Utilizar bucle do-while).
			System.out.println("Desea hacer otra compra?");
			System.out.println("1.Si");
			System.out.println("2.No");
			System.out.printf("Introduce opcion: ");
			opcion=num.nextInt();
		}while(opcion==1);
		//h) Mostrar por pantalla el ticket de la compra.
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH-mm-ss dd-MM-yy");
		String date = simpleDateFormat.format(new Date());
		Compra c1 = new Compra("a",1);
		System.out.println("\t-Ticket de compra");
		System.out.println("\t"+date);
		System.out.println("-----------------------------------");
		double precio_total=0;
		for(i=0;i<cesta.size();i++)
		{
			c1=cesta.get(i);
			System.out.printf("\n%-10s",c1.getProducto());
			System.out.printf("\t");
			System.out.printf("ud: %d",c1.getCantidad());
			System.out.printf("\t|");
			//buscamos el precio del producto
			int j;
			for(j=0;j<stock.size();j++)
			{
				p=stock.get(j);
				if(p.getNombre().equals(c1.getProducto()))
				{
					break;
				}
			
			}
			double precio = p.getPrecio()*c1.getCantidad();
			precio_total+=precio;
			System.out.printf("%.2f€",precio);

		}
		System.out.printf("\n___________________________________");
		System.out.printf("\nPrecio total: \t\t|%.2f€\n",precio_total);
		//i) Generar el ticket de la compra en un archivo txt cuyo nombre será la fecha y hora en que se ha realizado:
		precio_total=0;
		try {
			PrintWriter writer = new PrintWriter(date.concat(".txt"), "UTF-8");
			writer.printf("\t-Ticket de compra\n");
			writer.printf("\t"+date);
			writer.printf("\n-----------------------------------");
			for(i=0;i<cesta.size();i++)
			{
				c1=cesta.get(i);
				writer.printf("\n%-10s",c1.getProducto()); 
				writer.printf("\t");
				writer.printf("ud: %d",c1.getCantidad());
				writer.printf("\t|");
				//buscamos el precio del producto
				int j;
				for(j=0;j<stock.size();j++)
				{
					p=stock.get(j);
					if(p.getNombre().equals(c1.getProducto()))
					{
						break;
					}
				
				}
				double precio = p.getPrecio()*c1.getCantidad();
				precio_total+=precio;
				writer.printf("%.2f€",precio);

			}
			writer.printf("\n___________________________________");
			writer.printf("\nPrecio total: \t\t|%.2f€",precio_total);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void mostrarStock(ArrayList<Producto> stock) {
		Producto p = new Producto("a","b",1,2);
		int i;
		System.out.printf("\n");
		for(i=0;i<stock.size();i++)
		{
			p=stock.get(i);
			System.out.println("nombre: "+p.getNombre());
			System.out.println("categoria: "+p.getCategoria());
			System.out.println("cantidad: "+p.getCantidad());
			System.out.println("precio: "+p.getPrecio());
			System.out.println("");
			
		}
		System.out.println("Fin del stock");
	}
	
}
