package fachada;

import java.util.InputMismatchException;
import java.util.Scanner;

import control.Controlador;
import control.ViveroServiciosConexion;
import servicios.ServiciosCredencial;
import servicios.ServiciosEjemplar;
import servicios.ServiciosMensaje;
import servicios.ServiciosPersona;
import servicios.ServiciosPlanta;

public class ViveroFachadaGestionMensajes {

private static ViveroFachadaGestionMensajes gestMens;
	
	private static ViveroFachadaPrincipal portal = ViveroFachadaPrincipal.getPortal();
	
	ViveroServiciosConexion conServicios = ViveroServiciosConexion.getServicios();
	
	ServiciosCredencial crServ = conServicios.getServiciosCredencial();
	ServiciosEjemplar ejServ = conServicios.getServiciosEjemplar();
	ServiciosMensaje menServ = conServicios.getServiciosMensaje();
	ServiciosPersona perServ = conServicios.getServiciosPersona();
	ServiciosPlanta plServ = conServicios.getServiciosPlanta();
	
	Scanner in = new Scanner(System.in);
	
	
	public static ViveroFachadaGestionMensajes getPortal() {
		if (gestMens==null)
			gestMens = new ViveroFachadaGestionMensajes();
		return gestMens;
	}
	
	public void mostrarMenuGestionMensajes() {
		System.out.println();
		
        int opcion = 0;
        do {
        	System.out.println("---MENÚ DE GESTIÓN DE MENSAJES---");
    		System.out.println("Seleccione una opcion:");
    		System.out.println("1.  Registrar un nuevo mensaje.");
    		System.out.println("2.  Filtrar mensajes (vacío).");
    		System.out.println("3.  Volver al menú anterior.");
            
    	try {
    		opcion = in.nextInt();
            if (opcion < 1 || opcion > 3) {
                System.out.println("Opción incorrecta.");
                continue;
            }
            switch (opcion) {
            	case 1:
            		this.registrarMensaje();
            		break;
            	case 2:
            		this.mostrarMenuFiltrarMensajes();
            		break;
            	case 3:
            		break;
            }
    	} catch (InputMismatchException e) {
			System.out.println("ERROR. Ingrese un número entero.");
			in.nextLine();
        }
        } while(opcion != 3);
	}
	
	public void registrarMensaje(){

		System.out.println("A continuación se muestran todos los ejemplares. Introduce el código del ejemplar para el que realizar una anotación.");
		System.out.println();
		Controlador.getServicios().getServEjemplar().mostrarEjemplares();
		System.out.println();
		System.out.println("Código de ejemplar: ");
		int id_ej = in.nextInt();
		in.nextLine();
		System.out.println();
		System.out.println("Mensaje: ");
		String mensaje = in.nextLine();

		Controlador.getServicios().getServMensaje().registrarMensaje(id_ej, portal.getCredencial().getFk_persona(), mensaje);
		
	}
	
	public void mostrarMenuFiltrarMensajes(){
		
	}
	
}
