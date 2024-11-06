package fachada;

import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

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

public class ViveroFachadaPrincipal {
	
	private static ViveroFachadaPrincipal portal;
	private static ViveroFachadaInvitado invitado = ViveroFachadaInvitado.getPortal();
	private static ViveroFachadaPersonal personal = ViveroFachadaPersonal.getPortal();
	
	private String nombreUsuario;
	
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
		
	public void mostrarMenuLogin() {
		
		Credencial c = this.pedirCredenciales();
				
		String tipoUsuario = Controlador.getServicios().getServCredencial().validarTipoUsuario(c);
		System.out.println(tipoUsuario);
		switch (tipoUsuario) {
		case "invitado":
			ViveroFachadaPrincipal.invitado.mostrarMenuInvitado();
			break;
		case "admin":
			//this.mostrarMenuAdmin();
		default:
			boolean loginCorrecto = false;
			while(!loginCorrecto) {
				if(!Controlador.getServicios().getServCredencial().validarCredencialContraseña(c)) {
					System.out.println("Usuario incorrecto, vuelva a introducir usuario y contraseña.");
					System.out.println();
					c = this.pedirCredenciales();
				} else {
					loginCorrecto = true;
					nombreUsuario = c.getUsuario();
				}
			
			}
			System.out.println("¡Hola, "+c.getUsuario()+"! que desea hacer?");
			ViveroFachadaPrincipal.personal.mostrarMenuPersonal();
			break;
		}
	}
		
	
	public Credencial pedirCredenciales() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Introduzca las credenciales de acceso. Si eres un invitado, introduzca 'invitado' en usuario y contraseña.");
		System.out.println();
		System.out.println("Usuario: ");
		String usuario = in.next();
		System.out.println("Contraseña: ");
		String contraseña = in.next();
		
		Credencial c = new Credencial(usuario, contraseña);
		
		return c;
	}
	
	
	//Métodos comunes a todas las fachadas
	
	
	public void mostarPlantas() {
		System.out.println();
		System.out.println("Estas son las plantas: ");
	 	List<Planta> lPlantas = Controlador.getServicios().getServPlanta().findAll();
		
		int contador = 1;
	 	for(Planta p : lPlantas) {
	 		System.out.println(contador + ": " + p.toString());
	 		contador++;
	 	}
	 	System.out.println();
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
}
