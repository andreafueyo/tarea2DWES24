package control;

import servicios.ServiciosCredencial;
import servicios.ServiciosEjemplar;
import servicios.ServiciosMensaje;
import servicios.ServiciosPersona;
import servicios.ServiciosPlanta;

public class ViveroServiciosConexion {

	public static ViveroServiciosConexion servicios;

	public static ViveroServiciosConexion getServicios() {
		if (servicios == null)
				servicios = new ViveroServiciosConexion();
		return servicios;
	}
	
	public ServiciosCredencial getServiciosCredencial() {
		return new ServiciosCredencial();
	}

	public ServiciosEjemplar getServiciosEjemplar() {
		return new ServiciosEjemplar();
	}
	
	public ServiciosMensaje getServiciosMensaje() {
		return new ServiciosMensaje();
	}
	
	public ServiciosPersona getServiciosPersona() {
		return new ServiciosPersona();
	}
	
	public ServiciosPlanta getServiciosPlanta() {
		return new ServiciosPlanta();
	}
	
}
