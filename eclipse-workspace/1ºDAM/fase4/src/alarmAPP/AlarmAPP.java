package alarmAPP;

import java.util.Scanner;

import alarmAPP.modelo.accesoADatos.Conectar;
import alarmAPP.modelo.accesoADatos.InstalacionDAO;
import alarmAPP.modelo.accesoADatos.MaterialDAO;
import alarmAPP.modelo.accesoADatos.ProveedorDAO;

public class AlarmAPP {
	public static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		InstalacionDAO inst = new InstalacionDAO();
		MaterialDAO mat = new MaterialDAO();
		ProveedorDAO prov= new ProveedorDAO();
		int opcion=-1;
		while(opcion!=0) {
			System.out.println("----AlarmAPP----");
			System.out.println("1.Gestion de Proveedores");
			System.out.println("2.Gestion de Instalaciones");
			System.out.println("3.Gestion de Materiales");
			System.out.println("4.Salir");
			System.out.print("opcion: ");
			opcion=sc.nextInt();
		
	
			switch(opcion) {
				case 1:
					int opcionP=-1;
					while(opcionP!=0) {
						System.out.println("--Gestion de Proveedores--");
						System.out.println("1.Crear proveedor");
						System.out.println("2.Modificar proveedor");
						System.out.println("3.Eliminar proveedor");
						System.out.println("4.Salir");
						System.out.print("opcion: ");
						opcionP =sc.nextInt();
						switch(opcionP) {
							case 1:
								break;
							case 2:
								break;
							case 3:
								break;
							case 4:
								opcionP=0;
								break;
							default:
						}
					}
					break;
				case 2:
					int opcionI=-1;
					while(opcionI!=0) {
						System.out.println("--Gestion de Instalaciones--");
						System.out.println("1.Crear instalacion");
						System.out.println("2.Modificar instalacion");
						System.out.println("3.Eliminar instalacion");
						System.out.println("4.Salir");
						System.out.print("opcion: ");
						opcionI =sc.nextInt();
						switch(opcionI) {
							case 1:
								break;
							case 2:
								break;
							case 3:
								break;
							case 4:
								opcionI=0;
								break;
							default:
						}
					}
					break;
				case 3:
					int opcionM=-1;
					while(opcionM!=0) {
						System.out.println("--Gestion de Materiales--");
						System.out.println("1.Crear material");
						System.out.println("2.Modificar material");
						System.out.println("3.Eliminar material");
						System.out.println("4.Salir");
						System.out.print("opcion: ");
						opcionM =sc.nextInt();
						switch(opcionM) {
							case 1:
								break;
							case 2:
								break;
							case 3:
								break;
							case 4:
								opcionM=0;
								break;
							default:
						}
					}
					break;
				case 4:
					return;
				default:
					System.out.println("opcion no valida");
					
			}
		
		}
	}
}