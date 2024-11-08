package fachada;

import java.util.InputMismatchException;
import java.util.Scanner;

import control.Controlador;
import control.ViveroServiciosConexion;
import modelo.Planta;
import servicios.ServiciosCredencial;
import servicios.ServiciosEjemplar;
import servicios.ServiciosMensaje;
import servicios.ServiciosPersona;
import servicios.ServiciosPlanta;

public class ViveroFachadaGestionPlantas {
	
	private static ViveroFachadaGestionPlantas gestPlantas;
	
	private static ViveroFachadaPrincipal portal = ViveroFachadaPrincipal.getPortal();
	
	ViveroServiciosConexion conServicios = ViveroServiciosConexion.getServicios();

	
	ServiciosCredencial crServ = conServicios.getServiciosCredencial();
	ServiciosEjemplar ejServ = conServicios.getServiciosEjemplar();
	ServiciosMensaje menServ = conServicios.getServiciosMensaje();
	ServiciosPersona perServ = conServicios.getServiciosPersona();
	ServiciosPlanta plServ = conServicios.getServiciosPlanta();
	
	Scanner in = new Scanner(System.in);
	
	
	public static ViveroFachadaGestionPlantas getPortal() {
		if (gestPlantas==null)
			gestPlantas = new ViveroFachadaGestionPlantas();
		return gestPlantas;
	}
	
	public void mostrarMenuGestionPlantas() {
		System.out.println();
		
        int opcion = 0;
        do {
        	System.out.println("---MENÚ DE PLANTAS---");
    		System.out.println("Seleccione una opcion:");
    		System.out.println("1.  Registrar una nueva planta.");
    		System.out.println("2.  Modificar una planta existente.");
    		System.out.println("3.  Volver al menú del administrador.");
            
    	try {
    		opcion = in.nextInt();
            if (opcion < 1 || opcion > 3) {
                System.out.println("Opcion incorrecta.");
                continue;
            }
            switch (opcion) {
            	case 1:
            		this.registrarPlanta();
            		break;
            	case 2:
            		this.modificarPlanta();
            		break;
            	case 3:
            		break;
            	case 4:
            }
    	} catch (InputMismatchException e) {
			System.out.println("ERROR. Ingrese un número entero.");
			in.nextLine();
        }
        } while(opcion != 3);
	}
	
	public void registrarPlanta() {
		System.out.println("Introduzca los datos de la nueva planta.");
		System.out.println();
		System.out.println("Código: ");
		String codigo = in.next();
		while(Controlador.getServicios().getServPlanta().existePlanta(codigo)) {
			System.out.println("Código de planta ya existente, vuelva a intentarlo: ");
			in.nextLine();
			codigo = in.nextLine();
		}
		System.out.println("Nombre común: ");
		String nom_com = in.next();
		System.out.println("Nombre científico: ");
		String nom_cien = in.next();
		
		Planta p = new Planta(codigo, nom_com, nom_cien);
		
		Controlador.getServicios().getServPlanta().insertar(p);	
	}
	
	public void modificarPlanta() {
		System.out.println("A continuación se muestran todas las plantas disponibles. Introduce el código de la planta a modificar.");
		System.out.println();
		portal.mostarPlantas();
		System.out.println();
		System.out.println("Código de planta: ");
		String cod_planta = in.next();
		
		System.out.println();
		System.out.println("Introduzca los nuevos datos.");
		System.out.println();
		System.out.println("Nombre común: ");
		String nom_com = in.next();
		System.out.println("Nombre científico: ");
		String nom_cien = in.next();
		
		Planta p = new Planta(cod_planta, nom_com, nom_cien);
		
		Controlador.getServicios().getServPlanta().modificar(p);	
	}
		
}
