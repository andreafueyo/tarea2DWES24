package fachada;

import java.util.List;
import java.util.Scanner;

import com.google.protobuf.Internal.ListAdapter;

import control.Controlador;
import control.ViveroServiciosConexion;
import modelo.Credencial;
import modelo.Planta;
import servicios.ServiciosCredencial;
import servicios.ServiciosEjemplar;
import servicios.ServiciosMensaje;
import servicios.ServiciosPersona;
import servicios.ServiciosPlanta;

public class ViveroFachadaPersonal {
	
	private static ViveroFachadaPersonal personal;
	
	private static ViveroFachadaPrincipal portal = ViveroFachadaPrincipal.getPortal();
	
	ViveroServiciosConexion conServicios = ViveroServiciosConexion.getServicios();

	
	ServiciosCredencial crServ = conServicios.getServiciosCredencial();
	ServiciosEjemplar ejServ = conServicios.getServiciosEjemplar();
	ServiciosMensaje menServ = conServicios.getServiciosMensaje();
	ServiciosPersona perServ = conServicios.getServiciosPersona();
	ServiciosPlanta plServ = conServicios.getServiciosPlanta();
	
	
	
	public static ViveroFachadaPersonal getPortal() {
		if (personal==null)
				personal = new ViveroFachadaPersonal();
		return personal;
	}
	
	public void mostrarMenuPersonal() {
		Scanner in = new Scanner(System.in);
		System.out.println();
		
        int opcion = 0;
        do {
    		System.out.println("Seleccione una opcion:");
    		System.out.println("1.  Ver plantas.");
    		System.out.println("2.  Gestión de ejemplares.");
    		System.out.println("3.  Gestión de mensajes.");
    		System.out.println("4.  Volver al menú principal.");
            opcion = in.nextInt();
            if (opcion < 1 || opcion > 4) {
                System.out.println("Opcion incorrecta.");
                continue;
            }
            switch (opcion) {
            	case 1:
            		portal.mostarPlantas();
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
		
	
}
