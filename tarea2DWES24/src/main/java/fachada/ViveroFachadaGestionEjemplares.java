package fachada;

import java.util.List;
import java.util.Scanner;

import com.google.protobuf.Internal.ListAdapter;

import control.Controlador;
import control.ViveroServiciosConexion;
import modelo.Credencial;
import modelo.Ejemplar;
import modelo.Planta;
import servicios.ServiciosCredencial;
import servicios.ServiciosEjemplar;
import servicios.ServiciosMensaje;
import servicios.ServiciosPersona;
import servicios.ServiciosPlanta;

public class ViveroFachadaGestionEjemplares {
	
	private static ViveroFachadaGestionEjemplares personal;
	
	private static ViveroFachadaPrincipal portal = ViveroFachadaPrincipal.getPortal();
	
	ViveroServiciosConexion conServicios = ViveroServiciosConexion.getServicios();

	
	ServiciosCredencial crServ = conServicios.getServiciosCredencial();
	ServiciosEjemplar ejServ = conServicios.getServiciosEjemplar();
	ServiciosMensaje menServ = conServicios.getServiciosMensaje();
	ServiciosPersona perServ = conServicios.getServiciosPersona();
	ServiciosPlanta plServ = conServicios.getServiciosPlanta();
	
	
	
	public static ViveroFachadaGestionEjemplares getPortal() {
		if (personal==null)
				personal = new ViveroFachadaGestionEjemplares();
		return personal;
	}
	
	public void mostrarMenuGestionEjemplares() {
		Scanner in = new Scanner(System.in);
		System.out.println();
		
        int opcion = 0;
        do {
    		System.out.println("Seleccione una opcion:");
    		System.out.println("1.  Registrar un nuevo ejemplar.");
    		System.out.println("2.  Filtrar ejemplares por tipo de planta.");
    		System.out.println("3.  Ver mensajes de seguimiento de un ejemplar.");
    		System.out.println("4.  Volver al menú principal.");
            opcion = in.nextInt();
            if (opcion < 1 || opcion > 4) {
                System.out.println("Opcion incorrecta.");
                continue;
            }
            switch (opcion) {
            	case 1:
            		this.registrarEjemplar();
            		break;
            	case 2:
            		
            		break;
            	case 3:
            		
            		break;
            	case 4:
            		break;
            }
        } while(opcion != 4);
	}
	
	public void registrarEjemplar() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("A continuación se muestran todas las plantas disponibles. Introduce el código de la planta sobre la que quieres crear un ejemplar nuevo.");
		System.out.println();
		portal.mostarPlantas();
		System.out.println();
		System.out.println("Código de planta: ");
		String cod_planta = in.next();

		Planta planta = Controlador.getServicios().getServPlanta().findByCod(cod_planta);
		
		List<Ejemplar> lEjemplares = Controlador.getServicios().getServEjemplar().findByTipo(planta.getCodigo());
		
		Ejemplar ej = new Ejemplar(lEjemplares.size()+1, planta.getCodigo()+"_"+lEjemplares.size()+1, planta.getCodigo());
		
		Controlador.getServicios().getServEjemplar().insertar(ej);
		
		
	}
	
}
