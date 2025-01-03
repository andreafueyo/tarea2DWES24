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

public class ViveroFachadaAdmin {

	Scanner in = new Scanner(System.in);
	
	private static ViveroFachadaAdmin admin;
	
	private static ViveroFachadaPrincipal portal = ViveroFachadaPrincipal.getPortal();
	private static ViveroFachadaGestionEjemplares gestEjemp = ViveroFachadaGestionEjemplares.getPortal();
	private static ViveroFachadaGestionMensajes gestMens = ViveroFachadaGestionMensajes.getPortal();
	private static ViveroFachadaGestionPlantas gestPlantas = ViveroFachadaGestionPlantas.getPortal();
	
	ViveroServiciosConexion conServicios = ViveroServiciosConexion.getServicios();

	
	ServiciosCredencial crServ = conServicios.getServiciosCredencial();
	ServiciosEjemplar ejServ = conServicios.getServiciosEjemplar();
	ServiciosMensaje menServ = conServicios.getServiciosMensaje();
	ServiciosPersona perServ = conServicios.getServiciosPersona();
	ServiciosPlanta plServ = conServicios.getServiciosPlanta();
	
	
	
	public static ViveroFachadaAdmin getPortal() {
		if (admin==null)
				admin = new ViveroFachadaAdmin();
		return admin;
	}
	
	public void mostrarMenuAdmin() {
		
        int opcion = 0;
        do {
        	System.out.println("---MENÚ ADMINISTRADOR GENERAL---");
    		System.out.println("Seleccione una opcion:");
    		System.out.println("1.  Ver plantas.");
    		System.out.println("2.  Registrar persona.");
    		System.out.println("3.  Gestión de plantas.");
    		System.out.println("4.  Gestión de ejemplares.");
    		System.out.println("5.  Gestión de mensajes.");
    		System.out.println("6.  Cerrar sesión.");

            try {
            	opcion = in.nextInt();
            	
            	  if (opcion < 1 || opcion > 6) {
                      System.out.println("Opción incorrecta.");
                      continue;
            }
            
            switch (opcion) {
            	case 1:
            		portal.mostarPlantas();
            		break;
            	case 2:
            		this.registrarPersona();
            		break;
            	case 3:
            		gestPlantas.mostrarMenuGestionPlantas();
            		break;
            	case 4:
            		gestEjemp.mostrarMenuGestionEjemplares();
            		break;
            	case 5:
            		gestMens.mostrarMenuGestionMensajes();
            		break;
            	case 6:
            		portal.mostrarMenuPrincipal();
            		break;
            }
         
        } catch (InputMismatchException e) {
			System.out.println("ERROR. Ingrese un número entero.");
			in.nextLine();
        }
        } while(opcion != 6);
	}
        
	
	public void registrarPersona() {
		
		in.nextLine();
		
		System.out.println("--REGISTRO DE NUEVO USUARIO--");
		System.out.println("Introduzca los datos del nuevo usuario.");
		System.out.println();
		
		String nombre;
		String email;
		
		do {
			System.out.println("Nombre: ");
			nombre = in.nextLine();
			System.out.println("Email: ");
			email = in.nextLine();
			if(nombre.contains(" ") || email.contains(" ")) {
				System.out.println("Nombre o email no válidos. Introduzca de nuevo los datos sin espacios.");
			}
		} while (nombre.contains(" ") || email.contains(" ") || 
				Controlador.getServicios().getServPersona().registrarPersona(nombre, email) == 0);	
		
		String usuario;
		String contrasena;
		do {
		System.out.println("Usuario: ");
		usuario = in.next();
		System.out.println("Contraseña: ");
		contrasena = in.next();
		if(usuario.contains(" ") || contrasena.contains(" ")) {
			System.out.println("Usuario o contraseña no válidos. Introduzca de nuevo los datos sin espacios.");
			}
		} while (usuario.contains(" ") || contrasena.contains(" ") ||
				Controlador.getServicios().getServCredencial().registrarCredencial(usuario,contrasena, email) == 0);
		
	}
	
}
