package control;

import servicios.ServiciosCredencial;
import servicios.ServiciosEjemplar;
import servicios.ServiciosMensaje;
import servicios.ServiciosPersona;
import servicios.ServiciosPlanta;

public class Controlador {
	
private static Controlador servicios;
	
	private ServiciosPlanta servPlanta;
	private ServiciosCredencial servCredencial;
	private ServiciosEjemplar servEjemplar;
	private ServiciosMensaje servMensaje;
	private ServiciosPersona servPersona;
	
	public static Controlador getServicios() {
		if(servicios == null) 
			servicios = new Controlador();
		return servicios;
	}
	
	private Controlador() {
		servPlanta = new ServiciosPlanta();
		servCredencial = new ServiciosCredencial();
		servEjemplar = new ServiciosEjemplar();
		servMensaje = new ServiciosMensaje();
		servPersona = new ServiciosPersona();		
	}

	
	public ServiciosPlanta getServPlanta() {
		return servPlanta;
	}

	public ServiciosCredencial getServCredencial() {
		return servCredencial;
	}

	public ServiciosEjemplar getServEjemplar() {
		return servEjemplar;
	}

	public ServiciosMensaje getServMensaje() {
		return servMensaje;
	}

	public ServiciosPersona getServPersona() {
		return servPersona;
	}


}
