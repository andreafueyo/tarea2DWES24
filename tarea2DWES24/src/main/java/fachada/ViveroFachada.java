package fachada;

import control.ViveroServiciosConexion;
import servicios.ServiciosCredencial;
import servicios.ServiciosEjemplar;
import servicios.ServiciosMensaje;
import servicios.ServiciosPersona;
import servicios.ServiciosPlanta;

public class ViveroFachada {
	
	private static ViveroFachada portal;
	
	ViveroServiciosConexion conServicios = ViveroServiciosConexion.getServicios();

	
	ServiciosCredencial crServ = conServicios.getServiciosCredencial();
	ServiciosEjemplar ejServ = conServicios.getServiciosEjemplar();
	ServiciosMensaje menServ = conServicios.getServiciosMensaje();
	ServiciosPersona perServ = conServicios.getServiciosPersona();
	ServiciosPlanta plServ = conServicios.getServiciosPlanta();
	
	
	
	public static ViveroFachada getPortal() {
		if (portal==null)
				portal = new ViveroFachada();
		return portal;
	}
	
	
	public void mostrarMenuPrincipal() {
		System.out.println("Seleccione una opción:");
		System.out.println("1. Gestionar ");
		System.out.println("2. SALIR");
	}
	
	
	
}
