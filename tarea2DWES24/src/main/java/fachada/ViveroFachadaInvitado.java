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

public class ViveroFachadaInvitado {
	
	private static ViveroFachadaInvitado invitado;
	
	private static ViveroFachadaPrincipal portal = ViveroFachadaPrincipal.getPortal();
	
	ViveroServiciosConexion conServicios = ViveroServiciosConexion.getServicios();

	
	ServiciosCredencial crServ = conServicios.getServiciosCredencial();
	ServiciosEjemplar ejServ = conServicios.getServiciosEjemplar();
	ServiciosMensaje menServ = conServicios.getServiciosMensaje();
	ServiciosPersona perServ = conServicios.getServiciosPersona();
	ServiciosPlanta plServ = conServicios.getServiciosPlanta();
	
	
	
	public static ViveroFachadaInvitado getPortal() {
		if (invitado==null)
				invitado = new ViveroFachadaInvitado();
		return invitado;
	}
	
	public void mostrarMenuInvitado() {
		Scanner in = new Scanner(System.in);
		System.out.println("¡Hola, invitado! que desea hacer?");
		System.out.println();
		
        int opcion = 0;
        do {
    		System.out.println("Seleccione una opcion:");
    		System.out.println("1.  Ver plantas.");
    		System.out.println("2.  Volver al menú principal.");
            opcion = in.nextInt();
            if (opcion < 1 || opcion > 2) {
                System.out.println("Opcion incorrecta.");
                continue;
            }
            switch (opcion) {
            	case 1:
            		portal.mostarPlantas();
            		break;
            	case 2:
            		break;
            }
        } while(opcion != 2);
	}
		
	
}
