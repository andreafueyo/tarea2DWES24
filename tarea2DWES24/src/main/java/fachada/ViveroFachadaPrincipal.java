package fachada;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import control.Controlador;
import control.ViveroServiciosConexion;
import modelo.Credencial;
import modelo.Planta;
import servicios.ServiciosCredencial;
import servicios.ServiciosEjemplar;
import servicios.ServiciosMensaje;
import servicios.ServiciosPersona;
import servicios.ServiciosPlanta;

public class ViveroFachadaPrincipal {
	
	private static ViveroFachadaPrincipal portal;
	private static ViveroFachadaPersonal personal = ViveroFachadaPersonal.getPortal();
	private static ViveroFachadaAdmin admin = ViveroFachadaAdmin.getPortal();
	
	private Credencial credencial;

	Scanner in = new Scanner(System.in);
	
	ViveroServiciosConexion conServicios = ViveroServiciosConexion.getServicios();

	
	ServiciosCredencial crServ = conServicios.getServiciosCredencial();
	ServiciosEjemplar ejServ = conServicios.getServiciosEjemplar();
	ServiciosMensaje menServ = conServicios.getServiciosMensaje();
	ServiciosPersona perServ = conServicios.getServiciosPersona();
	ServiciosPlanta plServ = conServicios.getServiciosPlanta();
	
	
	
	public static ViveroFachadaPrincipal getPortal() {
		if (portal==null)
				portal = new ViveroFachadaPrincipal();
		return portal;
	}
	
	public void mostrarMenuPrincipal() {
		
		System.out.println();
		System.out.println("--------------------------------------------------");
		System.out.println("¡Bienvenido/a a nuestro vivero! ¿Qué desea hacer?");
		
        int opcion = 0;
        do {
    		System.out.println("Seleccione una opción:");
    		System.out.println("1.  Ver plantas.");
    		System.out.println("2.  Login.");
    		
    		try {
	            opcion = in.nextInt();
	            if (opcion < 1 || opcion > 2) {
	                System.out.println("Opción incorrecta. Inserte uno de los números indicados.");
	                continue;
            }
            switch (opcion) {
            	case 1:
            		portal.mostarPlantas();
            		break;
            	case 2:
            		portal.mostrarMenuLogin();
            		break;
            }
    		} catch (InputMismatchException e) {
				System.out.println("ERROR. Ingrese un número entero.");
				in.nextLine();
	        }
        } while(opcion != 2);
	}
		
	
	public void mostrarMenuLogin() {
		
		Credencial c = this.pedirCredenciales();
		
		if(c.getUsuario().equals("admin") && c.getPassword().equals("admin")) {
			System.out.println("¡Hola, admin!, ¿qué desea hacer?");
			ViveroFachadaPrincipal.admin.mostrarMenuAdmin();	
		}
		else {
			boolean loginCorrecto = false;
			while(!loginCorrecto) {
				if(!Controlador.getServicios().getServCredencial().validarCredencialContraseña(c)) {
					System.out.println("Usuario o contraseña incorrectos, vuelva a introducir los datos.");
					System.out.println();
					c = this.pedirCredenciales();
				} else {
					loginCorrecto = true;
					credencial = Controlador.getServicios().getServCredencial().findByUsuario(c.getUsuario());
				}
			
			}
			//USUARIO: andrea CONTRASEÑA: andrea || USUARIO: a CONTRASEÑA: a
			System.out.println("¡Hola, "+c.getUsuario()+"!, ¿Qué desea hacer?");
			ViveroFachadaPrincipal.personal.mostrarMenuPersonal();		
		}
	}
		
	
	public Credencial pedirCredenciales() {
		
		System.out.println("Introduzca las credenciales de acceso.");
		System.out.println();
		System.out.println("Usuario: ");
		String usuario = in.next();
		System.out.println("Contraseña: ");
		String contraseña = in.next();
		
		Credencial c = new Credencial(usuario, contraseña);
		
		return c;
	}
	
	
	//MÉTODOS COMUNES A TODAS LAS FACHADAS
	
	public void mostarPlantas() {
		System.out.println();
		System.out.println("Estas son las plantas: ");
	 	List<Planta> listaPlantas = Controlador.getServicios().getServPlanta().findAll();
		
		int contador = 1;
	 	for(Planta p : listaPlantas) {
	 		System.out.println(contador + ": " + p.toString());
	 		contador++;
	 	}
	 	System.out.println();
	}
	
	public Credencial getCredencial() {
		return credencial;
	}
	
	public void setCredencial(Credencial credencial) {
		this.credencial = credencial;
	}
	
}
